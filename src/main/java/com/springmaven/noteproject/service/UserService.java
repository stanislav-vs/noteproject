/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.service;

import com.springmaven.noteproject.domain.User;

/**
 *
 * @author stasiuk-ps
 */
public interface UserService {
    
    User getUser(String login);
    
}
