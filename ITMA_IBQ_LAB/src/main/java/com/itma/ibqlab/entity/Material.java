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
@Table(name = "materiales", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id"),
    @NamedQuery(name = "Material.findByUriImagen", query = "SELECT m FROM Material m WHERE m.uriImagen = :uriImagen"),
    @NamedQuery(name = "Material.findByNombre", query = "SELECT m FROM Material m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Material.findByCantidadMinima", query = "SELECT m FROM Material m WHERE m.cantidadMinima = :cantidadMinima"),
    @NamedQuery(name = "Material.findByCantidadDisponible", query = "SELECT m FROM Material m WHERE m.cantidadDisponible = :cantidadDisponible"),
    @NamedQuery(name = "Material.findByDescripcion", query = "SELECT m FROM Material m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Material.findByCreatedAt", query = "SELECT m FROM Material m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "Material.findByUpdatedAt", query = "SELECT m FROM Material m WHERE m.updatedAt = :updatedAt")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "uri_imagen")
    private String uriImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_minima")
    private int cantidadMinima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material", fetch = FetchType.LAZY)
    private List<MaterialPrestamo> materialPrestamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material", fetch = FetchType.LAZY)
    private List<MaterialInventario> materialInventarioList;
    @JoinColumn(name = "tipos_materiales_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMaterial tiposMaterialesId;
    @JoinColumn(name = "bloque_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bloque bloqueId;

    public Material() {
    }

    public Material(Integer id) {
        this.id = id;
    }

    public Material(Integer id, String nombre, int cantidadMinima, int cantidadDisponible, Date createdAt, Date updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMinima = cantidadMinima;
        this.cantidadDisponible = cantidadDisponible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUriImagen() {
        return uriImagen;
    }

    public void setUriImagen(String uriImagen) {
        this.uriImagen = uriImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public List<MaterialPrestamo> getMaterialPrestamoList() {
        return materialPrestamoList;
    }

    public void setMaterialPrestamoList(List<MaterialPrestamo> materialPrestamoList) {
        this.materialPrestamoList = materialPrestamoList;
    }

    @XmlTransient
    public List<MaterialInventario> getMaterialInventarioList() {
        return materialInventarioList;
    }

    public void setMaterialInventarioList(List<MaterialInventario> materialInventarioList) {
        this.materialInventarioList = materialInventarioList;
    }

    public TipoMaterial getTiposMaterialesId() {
        return tiposMaterialesId;
    }

    public void setTiposMaterialesId(TipoMaterial tiposMaterialesId) {
        this.tiposMaterialesId = tiposMaterialesId;
    }

    public Bloque getBloqueId() {
        return bloqueId;
    }

    public void setBloqueId(Bloque bloqueId) {
        this.bloqueId = bloqueId;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.Material[ id=" + id + " ]";
    }
    
}
