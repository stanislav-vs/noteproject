/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain;

import java.util.List;


/**
 *
 * @author stasiuk-ps
 */

public interface UserRepository {
    
    Users getUser(String username);
    
    List<Users> findAllUsers();

    Users saveNewUser(Users user);
    
}
