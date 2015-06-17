/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.service;

import com.itma.ibqlab.entity.Alumno;
import com.itma.ibqlab.entity.Material;
import com.itma.ibqlab.entity.MaterialPrestamo;
import com.itma.ibqlab.entity.Prestamo;
import com.itma.ibqlab.entity.Profesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cobrakik
 */
@Local
public interface PrestamosServiceLocal {

    void hacerPrestamo(Profesor profesor, Alumno alumno, Prestamo prestamo, List<MaterialPrestamo> listaMaterialPrestamo) throws AlumntoNotFoundException, PrestamoException, ProfesorNotfoundException;

    void hacerPrestamo(Alumno alumno, Prestamo prestamo, List<MaterialPrestamo> listaMaterialPrestamo) throws AlumntoNotFoundException, PrestamoException, ProfesorNotfoundException;
    /// void hacerPrestamo(Alumno alumno, Prestamo prestamo, List<Material> listaMaterialPrestamo) throws AlumntoNotFoundException, PrestamoException, ProfesorNotfoundException;

    public List<Prestamo> findByNoControl(String numeroControl);

    public List<Prestamo> findByNoControl(String numeroControl, boolean deudor);
}
