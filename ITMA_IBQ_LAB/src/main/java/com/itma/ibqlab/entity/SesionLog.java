/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cobrakik
 */
@Entity
@Table(name = "sesiones_log", catalog = "itma_ibq_lab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SesionLog.findAll", query = "SELECT s FROM SesionLog s"),
    @NamedQuery(name = "SesionLog.findById", query = "SELECT s FROM SesionLog s WHERE s.id = :id"),
    @NamedQuery(name = "SesionLog.findByEntrada", query = "SELECT s FROM SesionLog s WHERE s.entrada = :entrada"),
    @NamedQuery(name = "SesionLog.findBySalida", query = "SELECT s FROM SesionLog s WHERE s.salida = :salida")})
public class SesionLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @Column(name = "salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salida;
    @JoinColumn(name = "alumnos_no_control", referencedColumnName = "no_control")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alumno alumnosNoControl;

    public SesionLog() {
    }

    public SesionLog(Integer id) {
        this.id = id;
    }

    public SesionLog(Integer id, Date entrada) {
        this.id = id;
        this.entrada = entrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Alumno getAlumnosNoControl() {
        return alumnosNoControl;
    }

    public void setAlumnosNoControl(Alumno alumnosNoControl) {
        this.alumnosNoControl = alumnosNoControl;
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
        if (!(object instanceof SesionLog)) {
            return false;
        }
        SesionLog other = (SesionLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itma.ibqlab.entity.SesionLog[ id=" + id + " ]";
    }
    
}
