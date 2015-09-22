/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain.authority;

import com.springmaven.noteproject.domain.Users;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author stasiuk-ps
 */
@Entity(name="authorities")
public class Authority {
    @Id
    private Long id;
	
    @OneToOne
    private Users user;
    private Collection<Authority> authorities;
    
    public Collection<Authority> getAuthorities() {
	return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    
} 
