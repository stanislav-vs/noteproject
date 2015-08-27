/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.service;

import com.springmaven.noteproject.domain.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author stasiuk-ps
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("123");
 
        return user;
    }
}
