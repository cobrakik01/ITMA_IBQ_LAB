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
public class GrupoUsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_grupo")
    private String nombreGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "usuario_alumno_no_control")
    private String usuarioAlumnoNoControl;

    public GrupoUsuarioPK() {
    }

    public GrupoUsuarioPK(String nombreGrupo, String usuarioAlumnoNoControl) {
        this.nombreGrupo = nombreGrupo;
        this.usuarioAlumnoNoControl = usuarioAlumnoNoControl;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getUsuarioAlumnoNoControl() {
        return usuarioAlumnoNoControl;
    }

    public void setUsuarioAlumnoNoControl(String usuarioAlumnoNoControl) {
        this.usuarioAlumnoNoControl = usuarioAlumnoNoControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreGrupo != null ? nombreGrupo.hashCode() : 0);
        hash += (usuarioAlumnoNoControl != null ? usuarioAlumnoNoControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuarioPK)) {
            return false;
        }
        GrupoUsuarioPK other = (GrupoUsuarioPK) object;
        if ((this.nombreGrupo == null && other.nombreGrupo != null) || (this.nombreGrupo != null && !this.nombreGrupo.equals(other.nombreGrupo))) {
            return false;
        }
        if ((this.usuarioAlumnoNoControl == null && other.usuarioAlumnoNoControl != null) || (this.usuarioAlumnoNoControl != null && !this.usuarioAlumnoNoControl.equals(other.usuarioAlumnoNoControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.GrupoUsuarioPK[ nombreGrupo=" + nombreGrupo + ", usuarioAlumnoNoControl=" + usuarioAlumnoNoControl + " ]";
    }
    
}
