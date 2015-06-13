/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itma.ibqlab.service;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author andru
 */
@Named(value = "menuView")
@SessionScoped
public class MenuView implements Serializable {

   public void save() {
        addMessage("Correcto", "Datos Guardados");
    }
     
    public void update() {
        addMessage("Correcto", "Datos Modificado");
    }
     
    public void delete() {
        addMessage("Correcto", "Datos Elimiandos");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
