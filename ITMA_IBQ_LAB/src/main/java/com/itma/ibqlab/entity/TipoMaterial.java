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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "tipos_materiales", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMaterial.findAll", query = "SELECT t FROM TipoMaterial t"),
    @NamedQuery(name = "TipoMaterial.findById", query = "SELECT t FROM TipoMaterial t WHERE t.id = :id"),
    @NamedQuery(name = "TipoMaterial.findByNombreMateria", query = "SELECT t FROM TipoMaterial t WHERE t.nombreMateria = :nombreMateria")})
public class TipoMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @JoinTable(name = "unidades_medida_tipos_materiales", joinColumns = {
        @JoinColumn(name = "tipo_material_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "unidad_medida", referencedColumnName = "unidad")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<UnidadMedida> unidadMedidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposMaterialesId", fetch = FetchType.LAZY)
    private List<Material> materialList;

    public TipoMaterial() {
    }

    public TipoMaterial(Integer id) {
        this.id = id;
    }

    public TipoMaterial(Integer id, String nombreMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @XmlTransient
    public List<UnidadMedida> getUnidadMedidaList() {
        return unidadMedidaList;
    }

    public void setUnidadMedidaList(List<UnidadMedida> unidadMedidaList) {
        this.unidadMedidaList = unidadMedidaList;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
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
        if (!(object instanceof TipoMaterial)) {
            return false;
        }
        TipoMaterial other = (TipoMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.TipoMaterial[ id=" + id + " ]";
    }
    
}
