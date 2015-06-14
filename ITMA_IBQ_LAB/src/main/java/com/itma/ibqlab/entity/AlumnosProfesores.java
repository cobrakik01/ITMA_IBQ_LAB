/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "alumnos_has_profesores", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnosProfesores.findAll", query = "SELECT a FROM AlumnosProfesores a"),
    @NamedQuery(name = "AlumnosProfesores.findById", query = "SELECT a FROM AlumnosProfesores a WHERE a.alumnosProfesoresPK.id = :id"),
    @NamedQuery(name = "AlumnosProfesores.findByAlumnosNoControl", query = "SELECT a FROM AlumnosProfesores a WHERE a.alumnosProfesoresPK.alumnosNoControl = :alumnosNoControl"),
    @NamedQuery(name = "AlumnosProfesores.findByProfesoresId", query = "SELECT a FROM AlumnosProfesores a WHERE a.alumnosProfesoresPK.profesoresId = :profesoresId"),
    @NamedQuery(name = "AlumnosProfesores.findByNombre", query = "SELECT a FROM AlumnosProfesores a WHERE a.nombre = :nombre")})
public class AlumnosProfesores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnosProfesoresPK alumnosProfesoresPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "alumnos_no_control", referencedColumnName = "no_control", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alumno alumno;
    @JoinColumn(name = "profesores_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profesor profesor;

    public AlumnosProfesores() {
    }

    public AlumnosProfesores(AlumnosProfesoresPK alumnosProfesoresPK) {
        this.alumnosProfesoresPK = alumnosProfesoresPK;
    }

    public AlumnosProfesores(AlumnosProfesoresPK alumnosProfesoresPK, String nombre) {
        this.alumnosProfesoresPK = alumnosProfesoresPK;
        this.nombre = nombre;
    }

    public AlumnosProfesores(int id, String alumnosNoControl, int profesoresId) {
        this.alumnosProfesoresPK = new AlumnosProfesoresPK(id, alumnosNoControl, profesoresId);
    }

    public AlumnosProfesoresPK getAlumnosProfesoresPK() {
        return alumnosProfesoresPK;
    }

    public void setAlumnosProfesoresPK(AlumnosProfesoresPK alumnosProfesoresPK) {
        this.alumnosProfesoresPK = alumnosProfesoresPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnosProfesoresPK != null ? alumnosProfesoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnosProfesores)) {
            return false;
        }
        AlumnosProfesores other = (AlumnosProfesores) object;
        if ((this.alumnosProfesoresPK == null && other.alumnosProfesoresPK != null) || (this.alumnosProfesoresPK != null && !this.alumnosProfesoresPK.equals(other.alumnosProfesoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.AlumnosProfesores[ alumnosProfesoresPK=" + alumnosProfesoresPK + " ]";
    }
    
}
