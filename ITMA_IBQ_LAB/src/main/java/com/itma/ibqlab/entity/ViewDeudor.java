/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andru
 */
@Entity
@Table(name = "view_deudores", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewDeudor.findAll", query = "SELECT v FROM ViewDeudor v"),
    @NamedQuery(name = "ViewDeudor.findByNumeroControl", query = "SELECT v FROM ViewDeudor v WHERE v.numeroControl = :numeroControl"),
    @NamedQuery(name = "ViewDeudor.findByNoPrestamos", query = "SELECT v FROM ViewDeudor v WHERE v.noPrestamos = :noPrestamos"),
    @NamedQuery(name = "ViewDeudor.findByAlumno", query = "SELECT v FROM ViewDeudor v WHERE v.alumno = :alumno"),
    @NamedQuery(name = "ViewDeudor.findByCarrera", query = "SELECT v FROM ViewDeudor v WHERE v.carrera = :carrera")})
public class ViewDeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "numero_control")
    private String numeroControl;
    @Column(name = "no_prestamos")
    private BigInteger noPrestamos;
    @Size(max = 137)
    @Column(name = "alumno")
    private String alumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carrera")
    private String carrera;

    public ViewDeudor() {
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public BigInteger getNoPrestamos() {
        return noPrestamos;
    }

    public void setNoPrestamos(BigInteger noPrestamos) {
        this.noPrestamos = noPrestamos;
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

}
