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
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

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

    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
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

}
