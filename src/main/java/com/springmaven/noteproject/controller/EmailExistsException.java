/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.controller;

/**
 *
 * @author stasiuk-ps
 */
class EmailExistsException extends Exception {
   
    public EmailExistsException() {
        super();
   }

    EmailExistsException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
