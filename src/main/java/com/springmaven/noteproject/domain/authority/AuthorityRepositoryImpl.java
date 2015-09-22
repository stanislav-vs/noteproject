/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain.authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author stasiuk-ps
 */
public class AuthorityRepositoryImpl implements AuthorityRepository{
    
    @Autowired
    private AuthorityRepository authorityRepository;
    
    private Collection<? extends GrantedAuthority> getAuthority(Integer role) {
               
        List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
         
            authority.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return authority;
    
    }

   
}
