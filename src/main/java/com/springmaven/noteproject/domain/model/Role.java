/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author stasiuk-ps
 */
@Entity
@Table(name="roles")
public class Role implements Serializable{
    @Id
    private Long id;
    
    @Column(name = "rolename")
    private String role;
    
    @OneToMany(fetch = FetchType.EAGER)  
    @JoinTable(name = "user_role",   
        joinColumns        = {@JoinColumn(name = "role_id", referencedColumnName = "id")},  
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}  
    )  
    private Set<User> userRole;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<User> userRole) {
        this.userRole = userRole;
    }

    


} 
