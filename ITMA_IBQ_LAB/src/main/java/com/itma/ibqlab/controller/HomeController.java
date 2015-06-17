/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.controller;

import com.itma.ibqlab.controller.util.JsfUtil;
import com.itma.ibqlab.entity.Material;
import com.itma.ibqlab.entity.MaterialPrestamo;
import com.itma.ibqlab.entity.Prestamo;
import com.itma.ibqlab.entity.ViewDeudor;
import com.itma.ibqlab.service.AlumntoNotFoundException;
import com.itma.ibqlab.service.PrestamoException;
import com.itma.ibqlab.service.ProfesorNotfoundException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author cobrakik
 */
@Named(value = "homeController")
@ViewScoped
public class HomeController extends HomeComponentsController implements Serializable {

    private HashMap<String, WrapperMaterial> mapaMateriales = new HashMap<>();

    public void agregarMaterial() {
        if (getMaterialSeleccionado().getId() == null) {
            JsfUtil.addWarningMessage(getMessageComponent().getClientId(), "Seleccione un material");
            return;
        }
        if (getCantidadMaterial() <= 0) {
            JsfUtil.addWarningMessage(getMessageComponent().getClientId(), "Por vafor, introdusca una cantidad mayor a cero.");
            return;
        }
        if (getCantidadMaterial() > getMaterialSeleccionado().getCantidadDisponible()) {
            JsfUtil.addWarningMessage(getMessageComponent().getClientId(), "La cantidad a prestar no debe de superar a la cantidad disponible.");
            return;
        }
        agregarMaterial(getMaterialSeleccionado(), getCantidadMaterial());
    }

    private void agregarMaterial(Material material, int cantidadMaterial) {
        if (!mapaMateriales.containsKey(material.getNombre())) {
            WrapperMaterial w = new WrapperMaterial();
            w.setId(material.getId());
            w.setCantidad(cantidadMaterial);
            w.setNombre(material.getNombre());
            w.setMaterial(material);

            MaterialPrestamo mp = new MaterialPrestamo();
            mp.setCantidad(cantidadMaterial);
            mp.setMaterial(material);
            w.setMaterialPrestamo(mp);
            mapaMateriales.put(material.getNombre(), w);
        } else {
            mapaMateriales.get(material.getNombre()).setCantidad(cantidadMaterial);
            mapaMateriales.get(material.getNombre()).getMaterialPrestamo().setCantidad(cantidadMaterial);
        }
        refreshListaMaterialSeleccionado();
    }

    private void refreshListaMaterialSeleccionado() {
        getListaMaterialSeleccionado().clear();
        Collection<WrapperMaterial> values = mapaMateriales.values();
        getListaMaterialSeleccionado().addAll(values);
    }

    public void quitarMaterial() {
        if (getMaterialSeleccionadoListaPrestamo() == null) {
            JsfUtil.addErrorMessage("No se encontro ningun material para remover de la lista.");
            return;
        }
        quitarMaterial(getMaterialSeleccionadoListaPrestamo());
    }

    public void quitarMaterial(WrapperMaterial material) {
        if (mapaMateriales.containsKey(material.getNombre())) {
            mapaMateriales.remove(material.getNombre());
            refreshListaMaterialSeleccionado();
        }
    }

    public void limpiarListaMaterialSeleccionado() {
        getListaMaterialSeleccionado().clear();
        mapaMateriales.clear();
    }

    public void realizarPrestamo() {
        try {
            List<MaterialPrestamo> listaMaterialPrestamo = new LinkedList<>();
            Collection<WrapperMaterial> lista = mapaMateriales.values();
            for (WrapperMaterial wm : lista) {
                wm.getMaterialPrestamo().setMaterial(wm.getMaterial());
                listaMaterialPrestamo.add(wm.getMaterialPrestamo());
            }
            getPrestamoService().hacerPrestamo(getAlumnoSeleccionado(), getPrestamo(), listaMaterialPrestamo);
        } catch (AlumntoNotFoundException | PrestamoException | ProfesorNotfoundException ex) {
            // Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            JsfUtil.addErrorMessage(ex, "No fue posible realizar el prestamo.");
        }
    }

    public void cargarListaPrestamoDeudores() {
        this.setListaMaterialesPrestamoDeudor(new LinkedList<WrapperMaterial>());
        ViewDeudor vd = this.getDeudor();
        if (vd != null) {
            List<Prestamo> lista = this.prestamoService.findByNoControl(vd.getNumeroControl(), true);
            this.setListaPrestamosDeudor(lista);
        }
    }

    public void cargarMaterialesPrestamoDeudor(SelectEvent event) {
        Prestamo prestamo = (Prestamo) event.getObject();
        if (prestamo != null) {
            List<MaterialPrestamo> lista = this.materialesPrestamoService.findByPrestamoId(prestamo.getId());
            List<WrapperMaterial> lstWrapperMaterial = new LinkedList<>();
            for (MaterialPrestamo mp : lista) {
                WrapperMaterial wm = new WrapperMaterial();
                wm.setCantidad(mp.getCantidad());
                wm.setMaterial(mp.getMaterial());
                wm.setNombre(mp.getMaterial().getNombre());
                lstWrapperMaterial.add(wm);
            }
            this.setListaMaterialesPrestamoDeudor(lstWrapperMaterial);
        }
    }

}
