/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itma.ibqlab.service;

/**
 *
 * @author cobrakik
 */
public class ProfesorNotfoundException extends Exception {

    public ProfesorNotfoundException() {
        super("No se encontro a ningun profesor");
    }

}
