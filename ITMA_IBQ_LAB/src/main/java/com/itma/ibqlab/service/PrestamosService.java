/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.service;

import com.itma.ibqlab.controller.AlumnoFacade;
import com.itma.ibqlab.controller.PrestamoFacade;
import com.itma.ibqlab.controller.ProfesorFacade;
import com.itma.ibqlab.entity.Alumno;
import com.itma.ibqlab.entity.MaterialPrestamo;
import com.itma.ibqlab.entity.Prestamo;
import com.itma.ibqlab.entity.Profesor;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
        Alumno result = getAlumnosFacade().find(alumno.getNoControl());

        if (result == null) {
            throw new AlumntoNotFoundException();
        }
        if (profesor == null || getProfesoresFacade().find(profesor.getId()) == null) {
            throw new ProfesorNotfoundException();
        }
        if (prestamo == null) {
            throw new PrestamoException("No fue posible crear el prestamo, verifique que los datos se ingresen correctamente.");
        }
        if (listaMaterialPrestamo.size() <= 0) {
            throw new PrestamoException("No es posiblre realizar un prestamo sin ningun material.");
        }

        prestamo.setAlumnoNoControl(alumno);
        prestamo.setFechaPrestamo(new Date());
        prestamo.setMaterialPrestamoList(listaMaterialPrestamo);
        prestamo.setProfesorId(profesor);
        getPrestamosFacade().create(prestamo);
    }

}
