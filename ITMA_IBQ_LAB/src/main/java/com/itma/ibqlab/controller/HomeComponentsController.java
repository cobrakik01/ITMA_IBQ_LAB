/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.controller;

import com.itma.ibqlab.entity.Alumno;
import com.itma.ibqlab.entity.Material;
import com.itma.ibqlab.entity.MaterialPrestamo;
import com.itma.ibqlab.entity.Prestamo;
import com.itma.ibqlab.entity.ViewDeudor;
import com.itma.ibqlab.service.PrestamosServiceLocal;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;

/**
 *
 * @author cobrakik
 */
public class HomeComponentsController implements Serializable {

    @EJB
    protected AlumnoFacade alumnoFacade;
    @EJB
    protected MaterialFacade materialFacade;
    @EJB
    protected PrestamosServiceLocal prestamoService;
    @EJB
    protected ViewDeudoresFacade deudoresFacade;

    private List<Alumno> listaAlumnos;
    private List<Material> listaMaterial;
    private Alumno alumnoSeleccionado;
    private Material materialSeleccionado;
    private WrapperMaterial materialSeleccionadoListaPrestamo;
    private List<HomeController.WrapperMaterial> listaMaterialSeleccionado;
    private int cantidadMaterial = 1;
    private UIComponent messageComponent;
    private Prestamo prestamo;
    private List<ViewDeudor> listaDeudores;
    private ViewDeudor deudor;
    private List<Prestamo> listaPrestamosDeudor;

    public List<Prestamo> getListaPrestamosDeudor() {
        return listaPrestamosDeudor;
    }

    public void setListaPrestamosDeudor(List<Prestamo> listaPrestamosDeudor) {
        this.listaPrestamosDeudor = listaPrestamosDeudor;
    }

    public ViewDeudor getDeudor() {
        return deudor;
    }

    public void setDeudor(ViewDeudor deudor) {
        this.deudor = deudor;
    }

    public HomeComponentsController() {
        alumnoSeleccionado = new Alumno();
        materialSeleccionado = new Material();
        prestamo = new Prestamo();
        listaMaterialSeleccionado = new LinkedList<>();
    }

    public List<ViewDeudor> getListaDeudores() {
        listaDeudores = deudoresFacade.findAll();
        return listaDeudores;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public PrestamosServiceLocal getPrestamoService() {
        return prestamoService;
    }

    public UIComponent getMessageComponent() {
        return messageComponent;
    }

    public WrapperMaterial getMaterialSeleccionadoListaPrestamo() {
        return materialSeleccionadoListaPrestamo;
    }

    public void setMaterialSeleccionadoListaPrestamo(WrapperMaterial materialSeleccionadoListaPrestamo) {
        this.materialSeleccionadoListaPrestamo = materialSeleccionadoListaPrestamo;
    }

    public void setMessageComponent(UIComponent messageComponent) {
        this.messageComponent = messageComponent;
    }

    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public List<WrapperMaterial> getListaMaterialSeleccionado() {
        return listaMaterialSeleccionado;
    }

    public void setListaMaterialSeleccionado(List<WrapperMaterial> listaMaterialSeleccionado) {
        this.listaMaterialSeleccionado = listaMaterialSeleccionado;
    }

    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    public Material getMaterialSeleccionado() {
        return materialSeleccionado;
    }

    public void setMaterialSeleccionado(Material materialSeleccionado) {
        this.materialSeleccionado = materialSeleccionado;
    }

    public List<Material> getListaMaterial() {
        listaMaterial = materialFacade.findAll();
        return listaMaterial;
    }

    public void setListaMaterial(List<Material> listaMaterial) {
        this.listaMaterial = listaMaterial;
    }

    public List<Alumno> getListaAlumnos() {
        listaAlumnos = alumnoFacade.findAll();
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public class WrapperMaterial {

        private Integer id;
        private String nombre;
        private Integer cantidad;
        private Material material;
        private MaterialPrestamo materialPrestamo;

        public MaterialPrestamo getMaterialPrestamo() {
            return materialPrestamo;
        }

        public void setMaterialPrestamo(MaterialPrestamo materialPrestamo) {
            this.materialPrestamo = materialPrestamo;
        }

        public Material getMaterial() {
            return material;
        }

        public void setMaterial(Material material) {
            this.material = material;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

    }

}
