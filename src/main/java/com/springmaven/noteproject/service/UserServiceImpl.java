/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.service;

import com.springmaven.noteproject.domain.UserDto;
import com.springmaven.noteproject.domain.UserRepository;
import com.springmaven.noteproject.domain.Users;
import com.springmaven.noteproject.domain.authority.Authority;
import java.lang.annotation.Annotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author stasiuk-ps
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private Environment env;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }
    
    @Transactional
    public Users registerNewUserAccount(UserDto userAccountData){   
        Users user = new Users();    
        user.setFirstName(userAccountData.getFirstName());
        user.setLastName(userAccountData.getLastName());
        user.setEmail(userAccountData.getEmail());
        user.setPassword(userAccountData.getPassword());
        user.setUsername(userAccountData.getUsername());
//        user.setAuthority(new Authority(userAccountData.getRole(), user));
        return repository.saveNewUser(user);       
    }      
}
