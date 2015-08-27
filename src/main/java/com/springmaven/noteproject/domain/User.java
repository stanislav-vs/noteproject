/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain;

/**
 *
 * @author stasiuk-ps
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class User implements Serializable {
    
    private String login;
    private String password;
    
    public User() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
