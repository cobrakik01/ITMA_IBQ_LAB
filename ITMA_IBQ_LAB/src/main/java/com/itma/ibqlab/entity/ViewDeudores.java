/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "view_deudores", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewDeudores.findAll", query = "SELECT v FROM ViewDeudores v"),
    @NamedQuery(name = "ViewDeudores.findByNoPrestamo", query = "SELECT v FROM ViewDeudores v WHERE v.noPrestamo = :noPrestamo"),
    @NamedQuery(name = "ViewDeudores.findByNumeroControl", query = "SELECT v FROM ViewDeudores v WHERE v.numeroControl = :numeroControl"),
    @NamedQuery(name = "ViewDeudores.findByAlumno", query = "SELECT v FROM ViewDeudores v WHERE v.alumno = :alumno"),
    @NamedQuery(name = "ViewDeudores.findByCarrera", query = "SELECT v FROM ViewDeudores v WHERE v.carrera = :carrera"),
    @NamedQuery(name = "ViewDeudores.findByFechaPrestamo", query = "SELECT v FROM ViewDeudores v WHERE v.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "ViewDeudores.findByFechaDevolucionProgramada", query = "SELECT v FROM ViewDeudores v WHERE v.fechaDevolucionProgramada = :fechaDevolucionProgramada")})
public class ViewDeudores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_prestamo")
    private int noPrestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "numero_control")
    private String numeroControl;
    @Size(max = 137)
    @Column(name = "alumno")
    private String alumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carrera")
    private String carrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion_programada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucionProgramada;

    public ViewDeudores() {
    }

    public int getNoPrestamo() {
        return noPrestamo;
    }

    public void setNoPrestamo(int noPrestamo) {
        this.noPrestamo = noPrestamo;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucionProgramada() {
        return fechaDevolucionProgramada;
    }

    public void setFechaDevolucionProgramada(Date fechaDevolucionProgramada) {
        this.fechaDevolucionProgramada = fechaDevolucionProgramada;
    }

}
