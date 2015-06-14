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

/**
 *
 * @author cobrakik
 */
@Embeddable
public class MaterialInventarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventarios_id")
    private int inventariosId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materiales_id")
    private int materialesId;

    public MaterialInventarioPK() {
    }

    public MaterialInventarioPK(int inventariosId, int materialesId) {
        this.inventariosId = inventariosId;
        this.materialesId = materialesId;
    }

    public int getInventariosId() {
        return inventariosId;
    }

    public void setInventariosId(int inventariosId) {
        this.inventariosId = inventariosId;
    }

    public int getMaterialesId() {
        return materialesId;
    }

    public void setMaterialesId(int materialesId) {
        this.materialesId = materialesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) inventariosId;
        hash += (int) materialesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialInventarioPK)) {
            return false;
        }
        MaterialInventarioPK other = (MaterialInventarioPK) object;
        if (this.inventariosId != other.inventariosId) {
            return false;
        }
        if (this.materialesId != other.materialesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.MaterialInventarioPK[ inventariosId=" + inventariosId + ", materialesId=" + materialesId + " ]";
    }
    
}
