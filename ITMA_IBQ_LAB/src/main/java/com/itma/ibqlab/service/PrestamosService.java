/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.service;

import com.itma.ibqlab.controller.AlumnoFacade;
import com.itma.ibqlab.controller.MaterialFacade;
import com.itma.ibqlab.controller.PrestamoFacade;
import com.itma.ibqlab.controller.ProfesorFacade;
import com.itma.ibqlab.entity.Alumno;
import com.itma.ibqlab.entity.Material;
import com.itma.ibqlab.entity.MaterialPrestamo;
import com.itma.ibqlab.entity.MaterialPrestamoPK;
import com.itma.ibqlab.entity.Prestamo;
import com.itma.ibqlab.entity.Profesor;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class PrestamosService implements PrestamosServiceLocal {

    @EJB
    private PrestamoFacade prestamosFacade;

    @EJB
    private AlumnoFacade alumnosFacade;

    @EJB
    private ProfesorFacade profesoresFacade;

    @EJB
    private MaterialFacade materialFacade;

    @PersistenceContext(unitName = "com.itma_ITMA_IBQ_LAB_war_1.0PU")
    private EntityManager em;

    private PrestamoFacade getPrestamosFacade() {
        return prestamosFacade;
    }

    private AlumnoFacade getAlumnosFacade() {
        return alumnosFacade;
    }

    private ProfesorFacade getProfesoresFacade() {
        return profesoresFacade;
    }

    @Override
    public void hacerPrestamo(Profesor profesor, Alumno alumno, Prestamo prestamo, List<MaterialPrestamo> listaMaterialPrestamo) throws AlumntoNotFoundException, PrestamoException, ProfesorNotfoundException {
        Alumno alumnoResult = getAlumnosFacade().find(alumno.getNoControl());
        if (alumnoResult == null) {
            throw new AlumntoNotFoundException();
        }
        if (prestamo == null) {
            throw new PrestamoException("No fue posible crear el prestamo, verifique que los datos se ingresen correctamente.");
        }
        if (listaMaterialPrestamo.size() <= 0) {
            throw new PrestamoException("No es posiblre realizar un prestamo sin ningun material.");
        }

        prestamo.setAlumnoNoControl(alumno);
        prestamo.setFechaPrestamo(new Date());
        prestamo.setProfesorId(profesor);
        prestamosFacade.create(prestamo);

        for (MaterialPrestamo mp : listaMaterialPrestamo) {
            mp.setMaterialPrestamoPK(new MaterialPrestamoPK(prestamo.getId(), mp.getMaterial().getId()));
        }
        prestamo.setMaterialPrestamoList(listaMaterialPrestamo);
        prestamosFacade.edit(prestamo);

        for (MaterialPrestamo mp : listaMaterialPrestamo) {
            Material materialResult = mp.getMaterial();
            materialResult.setCantidadDisponible(materialResult.getCantidadDisponible() - mp.getCantidad());
            materialFacade.edit(materialResult);
        }

    }

    @Override
    public void hacerPrestamo(Alumno alumno, Prestamo prestamo, List<MaterialPrestamo> listaMaterialPrestamo) throws AlumntoNotFoundException, PrestamoException, ProfesorNotfoundException {
        hacerPrestamo(null, alumno, prestamo, listaMaterialPrestamo);
    }


    /*
     @Override
     public void hacerPrestamo(Alumno alumno, Prestamo prestamo, List<Material> listaMaterialPrestamo) throws AlumntoNotFoundException, PrestamoException, ProfesorNotfoundException {
     Alumno alumnoResult = getAlumnosFacade().find(alumno.getNoControl());
     if (alumnoResult == null) {
     throw new AlumntoNotFoundException();
     }
     if (prestamo == null) {
     throw new PrestamoException("No fue posible crear el prestamo, verifique que los datos se ingresen correctamente.");
     }
     if (listaMaterialPrestamo.size() <= 0) {
     throw new PrestamoException("No es posiblre realizar un prestamo sin ningun material.");
     }
     }
     */
}
