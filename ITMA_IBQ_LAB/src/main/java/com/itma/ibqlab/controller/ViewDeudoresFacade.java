/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.controller;

import com.itma.ibqlab.entity.Alumno;
import com.itma.ibqlab.entity.ViewDeudores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cobrakik
 */
@Stateless
public class ViewDeudoresFacade extends AbstractFacade<ViewDeudores> {
    @PersistenceContext(unitName = "com.itma_ITMA_IBQ_LAB_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViewDeudoresFacade() {
        super(ViewDeudores.class);
    }
    
}
