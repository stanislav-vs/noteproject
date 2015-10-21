/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.dao;

import com.springmaven.noteproject.domain.model.User;
import com.springmaven.noteproject.mapper.UserMapper;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    
    @Autowired
    protected JdbcTemplate jdbc;
   
    @Override
    public User getUser(String username) {
           
    String q = "SELECT * FROM users WHERE username = " + username;
        User result = jdbc.queryForObject(q, new UserMapper());
        return result;
    
    }

    @Override
    public User saveNewUser(User user) {
        if (user.getId() == null) {
            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc).withTableName("users").usingGeneratedKeyColumns("id");
            HashMap parameters = new HashMap();
            parameters.put("username", user.getUsername());
            parameters.put("firstname", user.getFirstName());
            parameters.put("lastname", user.getLastName());
            parameters.put("email", user.getEmail());
            parameters.put("password", user.getPassword());
            
            final Number key = insert.executeAndReturnKey(parameters);
            final long pk = key.longValue();
            user.setId(pk);
        } else {

        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        String q = "SELECT * FROM users WHERE email = " + email;
        User result = jdbc.queryForObject(q, new UserMapper());
        return result;
    }

    @Override
    public List<User> findAllUsers() {
        String q = "SELECT * FROM users";
        List<User> result = jdbc.query(q, new UserMapper());
        return result;
    }

}

    