/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "prestamos", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findById", query = "SELECT p FROM Prestamo p WHERE p.id = :id"),
    @NamedQuery(name = "Prestamo.findByFechaPrestamo", query = "SELECT p FROM Prestamo p WHERE p.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "Prestamo.findByFechaDevolucion", query = "SELECT p FROM Prestamo p WHERE p.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "Prestamo.findByFechaDevolucionReal", query = "SELECT p FROM Prestamo p WHERE p.fechaDevolucionReal = :fechaDevolucionReal"),
    @NamedQuery(name = "Prestamo.findByObservacionesPrestamo", query = "SELECT p FROM Prestamo p WHERE p.observacionesPrestamo = :observacionesPrestamo"),
    @NamedQuery(name = "Prestamo.findByObservacionesDevolucion", query = "SELECT p FROM Prestamo p WHERE p.observacionesDevolucion = :observacionesDevolucion")})
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;
    @Column(name = "fecha_devolucion_real")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucionReal;
    @Size(max = 500)
    @Column(name = "observaciones_prestamo")
    private String observacionesPrestamo;
    @Size(max = 500)
    @Column(name = "observaciones_devolucion")
    private String observacionesDevolucion;
    @JoinColumn(name = "alumno_no_control", referencedColumnName = "no_control")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alumno alumnoNoControl;
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profesor profesorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamo", fetch = FetchType.LAZY)
    private List<MaterialPrestamo> materialPrestamoList;

    public Prestamo() {
    }

    public Prestamo(Integer id) {
        this.id = id;
    }

    public Prestamo(Integer id, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public String getObservacionesPrestamo() {
        return observacionesPrestamo;
    }

    public void setObservacionesPrestamo(String observacionesPrestamo) {
        this.observacionesPrestamo = observacionesPrestamo;
    }

    public String getObservacionesDevolucion() {
        return observacionesDevolucion;
    }

    public void setObservacionesDevolucion(String observacionesDevolucion) {
        this.observacionesDevolucion = observacionesDevolucion;
    }

    public Alumno getAlumnoNoControl() {
        return alumnoNoControl;
    }

    public void setAlumnoNoControl(Alumno alumnoNoControl) {
        this.alumnoNoControl = alumnoNoControl;
    }

    public Profesor getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Profesor profesorId) {
        this.profesorId = profesorId;
    }

    @XmlTransient
    public List<MaterialPrestamo> getMaterialPrestamoList() {
        return materialPrestamoList;
    }

    public void setMaterialPrestamoList(List<MaterialPrestamo> materialPrestamoList) {
        this.materialPrestamoList = materialPrestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.Prestamo[ id=" + id + " ]";
    }
    
}
