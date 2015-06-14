/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cobrakik
 */
@Embeddable
public class AlumnosProfesoresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "alumnos_no_control")
    private String alumnosNoControl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "profesores_id")
    private int profesoresId;

    public AlumnosProfesoresPK() {
    }

    public AlumnosProfesoresPK(int id, String alumnosNoControl, int profesoresId) {
        this.id = id;
        this.alumnosNoControl = alumnosNoControl;
        this.profesoresId = profesoresId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumnosNoControl() {
        return alumnosNoControl;
    }

    public void setAlumnosNoControl(String alumnosNoControl) {
        this.alumnosNoControl = alumnosNoControl;
    }

    public int getProfesoresId() {
        return profesoresId;
    }

    public void setProfesoresId(int profesoresId) {
        this.profesoresId = profesoresId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (alumnosNoControl != null ? alumnosNoControl.hashCode() : 0);
        hash += (int) profesoresId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnosProfesoresPK)) {
            return false;
        }
        AlumnosProfesoresPK other = (AlumnosProfesoresPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.alumnosNoControl == null && other.alumnosNoControl != null) || (this.alumnosNoControl != null && !this.alumnosNoControl.equals(other.alumnosNoControl))) {
            return false;
        }
        if (this.profesoresId != other.profesoresId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.AlumnosProfesoresPK[ id=" + id + ", alumnosNoControl=" + alumnosNoControl + ", profesoresId=" + profesoresId + " ]";
    }
    
}
