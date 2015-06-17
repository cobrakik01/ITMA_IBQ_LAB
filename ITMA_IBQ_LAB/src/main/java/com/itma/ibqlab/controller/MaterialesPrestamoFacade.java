/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.controller;

import com.itma.ibqlab.entity.Material;
import com.itma.ibqlab.entity.MaterialPrestamo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class MaterialesPrestamoFacade extends AbstractFacade<MaterialPrestamo> {

    @PersistenceContext(unitName = "com.itma_ITMA_IBQ_LAB_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialesPrestamoFacade() {
        super(MaterialPrestamo.class);
    }

    public List<MaterialPrestamo> findByPrestamoId(int id) {
        List<MaterialPrestamo> lista = (List<MaterialPrestamo>) getEntityManager()
                .createNamedQuery("MaterialPrestamo.findByPrestamoId")
                .setParameter("prestamoId", id)
                .getResultList();
        return lista;
    }

}
