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
public class MaterialPrestamoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "prestamo_id")
    private int prestamoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_id")
    private int materialId;

    public MaterialPrestamoPK() {
    }

    public MaterialPrestamoPK(int prestamoId, int materialId) {
        this.prestamoId = prestamoId;
        this.materialId = materialId;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prestamoId;
        hash += (int) materialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialPrestamoPK)) {
            return false;
        }
        MaterialPrestamoPK other = (MaterialPrestamoPK) object;
        if (this.prestamoId != other.prestamoId) {
            return false;
        }
        if (this.materialId != other.materialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.MaterialPrestamoPK[ prestamoId=" + prestamoId + ", materialId=" + materialId + " ]";
    }
    
}
