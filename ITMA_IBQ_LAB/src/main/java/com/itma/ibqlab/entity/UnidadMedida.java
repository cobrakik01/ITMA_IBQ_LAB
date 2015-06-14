/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "unidades_medida", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByUnidad", query = "SELECT u FROM UnidadMedida u WHERE u.unidad = :unidad")})
public class UnidadMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "unidad")
    private String unidad;
    @ManyToMany(mappedBy = "unidadMedidaList", fetch = FetchType.LAZY)
    private List<TipoMaterial> tipoMaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedida", fetch = FetchType.LAZY)
    private List<MaterialInventario> materialInventarioList;

    public UnidadMedida() {
    }

    public UnidadMedida(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @XmlTransient
    public List<TipoMaterial> getTipoMaterialList() {
        return tipoMaterialList;
    }

    public void setTipoMaterialList(List<TipoMaterial> tipoMaterialList) {
        this.tipoMaterialList = tipoMaterialList;
    }

    @XmlTransient
    public List<MaterialInventario> getMaterialInventarioList() {
        return materialInventarioList;
    }

    public void setMaterialInventarioList(List<MaterialInventario> materialInventarioList) {
        this.materialInventarioList = materialInventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidad != null ? unidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.unidad == null && other.unidad != null) || (this.unidad != null && !this.unidad.equals(other.unidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.UnidadMedida[ unidad=" + unidad + " ]";
    }
    
}
