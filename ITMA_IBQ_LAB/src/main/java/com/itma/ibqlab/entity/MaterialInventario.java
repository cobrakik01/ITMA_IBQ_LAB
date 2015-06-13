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
@Table(name = "materiales_inventario", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialInventario.findAll", query = "SELECT m FROM MaterialInventario m"),
    @NamedQuery(name = "MaterialInventario.findByInventariosId", query = "SELECT m FROM MaterialInventario m WHERE m.materialInventarioPK.inventariosId = :inventariosId"),
    @NamedQuery(name = "MaterialInventario.findByMaterialesId", query = "SELECT m FROM MaterialInventario m WHERE m.materialInventarioPK.materialesId = :materialesId"),
    @NamedQuery(name = "MaterialInventario.findByCantidad", query = "SELECT m FROM MaterialInventario m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MaterialInventario.findByObservaciones", query = "SELECT m FROM MaterialInventario m WHERE m.observaciones = :observaciones")})
public class MaterialInventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MaterialInventarioPK materialInventarioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "inventarios_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventario inventario;
    @JoinColumn(name = "materiales_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Material material;
    @JoinColumn(name = "unidad_medida", referencedColumnName = "unidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadMedida unidadMedida;

    public MaterialInventario() {
    }

    public MaterialInventario(MaterialInventarioPK materialInventarioPK) {
        this.materialInventarioPK = materialInventarioPK;
    }

    public MaterialInventario(MaterialInventarioPK materialInventarioPK, int cantidad) {
        this.materialInventarioPK = materialInventarioPK;
        this.cantidad = cantidad;
    }

    public MaterialInventario(int inventariosId, int materialesId) {
        this.materialInventarioPK = new MaterialInventarioPK(inventariosId, materialesId);
    }

    public MaterialInventarioPK getMaterialInventarioPK() {
        return materialInventarioPK;
    }

    public void setMaterialInventarioPK(MaterialInventarioPK materialInventarioPK) {
        this.materialInventarioPK = materialInventarioPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialInventarioPK != null ? materialInventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialInventario)) {
            return false;
        }
        MaterialInventario other = (MaterialInventario) object;
        if ((this.materialInventarioPK == null && other.materialInventarioPK != null) || (this.materialInventarioPK != null && !this.materialInventarioPK.equals(other.materialInventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.MaterialInventario[ materialInventarioPK=" + materialInventarioPK + " ]";
    }
    
}
