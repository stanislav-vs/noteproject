/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.dao;

import com.springmaven.noteproject.domain.model.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stasiuk-ps
 */
@Repository
public class RoleDaoImpl implements RoleDao{
   private Collection<? extends GrantedAuthority> getRole(Integer role) {
               
        List<GrantedAuthority> userRole = new ArrayList<GrantedAuthority>();
         
            userRole.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return userRole;
    
    } 

    @Override
    public Role getRole(int id) {
       Role role = null;
        return role;
    }
    
    @Override
    public Role findByName(String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
