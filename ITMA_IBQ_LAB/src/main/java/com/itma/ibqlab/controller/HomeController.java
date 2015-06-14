/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.controller;

import com.itma.ibqlab.entity.Alumno;
import com.itma.ibqlab.entity.Material;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author cobrakik
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    @EJB
    private AlumnoFacade alumnoFacade;
    @EJB
    private MaterialFacade materialFacade;

    private List<Alumno> listaAlumnos;
    private List<Material> listaMaterial;
    private Alumno alumnoSeleccionado;
    private Material materialSeleccionado;
    private List<WrapperMaterial> listaMaterialSeleccionado;
    private int cantidadMaterial;

    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
        alumnoSeleccionado = new Alumno();
        materialSeleccionado = new Material();
        listaMaterialSeleccionado = new LinkedList<>();
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

    public void onRowSelectAlumnos(SelectEvent event) {
        Alumno alumno = (Alumno) event.getObject();
    }

    private HashMap<String, WrapperMaterial> mapaMateriales = new HashMap<>();

    public void onRowSelectMaterial(SelectEvent event) {
        //this.cantidadMaterial = 0;
    }

    public void handleKeyEventCantidadMaterial() {
        System.out.println("Cantidad en keyup: " + cantidadMaterial);
        /*
         if(materialSeleccionadoPrestamo != null) {
         if(mapaMateriales.containsKey(materialSeleccionadoPrestamo.getNombre())) {
         WrapperMaterial m = mapaMateriales.get(materialSeleccionadoPrestamo.getNombre());
         m.cantidad = m.cantidad + cantidadMaterial;
         }
         }
         */
    }

    public void agregarMaterial() {
        System.out.println("Cantidad en agregarMaterial(): " + cantidadMaterial);
        if (materialSeleccionado != null && materialSeleccionado.getId() != null && this.cantidadMaterial > 0) {
            if (!mapaMateriales.containsKey(materialSeleccionado.getNombre())) {
                WrapperMaterial w = new WrapperMaterial();
                w.setId(materialSeleccionado.getId());
                w.setCantidad(this.cantidadMaterial);
                w.setNombre(materialSeleccionado.getNombre());
                mapaMateriales.put(materialSeleccionado.getNombre(), w);
            }
        } else {
            FacesMessage msg = new FacesMessage("Seleccionar Material", "Es nesesario que seleccione un material.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        listaMaterialSeleccionado.clear();
        Collection<WrapperMaterial> values = mapaMateriales.values();
        listaMaterialSeleccionado.addAll(values);
    }

    public void limpiarListaMaterialSeleccionado() {
        listaMaterialSeleccionado.clear();
        mapaMateriales.clear();
    }

    public class WrapperMaterial {

        private Integer id;
        private String nombre;
        private Integer cantidad;

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
