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
@Table(name = "materiales_prestamo", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialPrestamo.findAll", query = "SELECT m FROM MaterialPrestamo m"),
    @NamedQuery(name = "MaterialPrestamo.findByPrestamoId", query = "SELECT m FROM MaterialPrestamo m WHERE m.materialPrestamoPK.prestamoId = :prestamoId"),
    @NamedQuery(name = "MaterialPrestamo.findByMaterialId", query = "SELECT m FROM MaterialPrestamo m WHERE m.materialPrestamoPK.materialId = :materialId"),
    @NamedQuery(name = "MaterialPrestamo.findByCantidad", query = "SELECT m FROM MaterialPrestamo m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MaterialPrestamo.findByObservacionesPrestamo", query = "SELECT m FROM MaterialPrestamo m WHERE m.observacionesPrestamo = :observacionesPrestamo"),
    @NamedQuery(name = "MaterialPrestamo.findByObservacionesDevolucion", query = "SELECT m FROM MaterialPrestamo m WHERE m.observacionesDevolucion = :observacionesDevolucion")})
public class MaterialPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MaterialPrestamoPK materialPrestamoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 500)
    @Column(name = "observaciones_prestamo")
    private String observacionesPrestamo;
    @Size(max = 500)
    @Column(name = "observaciones_devolucion")
    private String observacionesDevolucion;
    @JoinColumn(name = "prestamo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Prestamo prestamo;
    @JoinColumn(name = "material_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Material material;

    public MaterialPrestamo() {
    }

    public MaterialPrestamo(MaterialPrestamoPK materialPrestamoPK) {
        this.materialPrestamoPK = materialPrestamoPK;
    }

    public MaterialPrestamo(MaterialPrestamoPK materialPrestamoPK, int cantidad) {
        this.materialPrestamoPK = materialPrestamoPK;
        this.cantidad = cantidad;
    }

    public MaterialPrestamo(int prestamoId, int materialId) {
        this.materialPrestamoPK = new MaterialPrestamoPK(prestamoId, materialId);
    }

    public MaterialPrestamoPK getMaterialPrestamoPK() {
        return materialPrestamoPK;
    }

    public void setMaterialPrestamoPK(MaterialPrestamoPK materialPrestamoPK) {
        this.materialPrestamoPK = materialPrestamoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialPrestamoPK != null ? materialPrestamoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialPrestamo)) {
            return false;
        }
        MaterialPrestamo other = (MaterialPrestamo) object;
        if ((this.materialPrestamoPK == null && other.materialPrestamoPK != null) || (this.materialPrestamoPK != null && !this.materialPrestamoPK.equals(other.materialPrestamoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.MaterialPrestamo[ materialPrestamoPK=" + materialPrestamoPK + " ]";
    }
    
}
