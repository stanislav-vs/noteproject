/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain;

import com.springmaven.noteproject.mapper.UserMapper;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    protected JdbcTemplate jdbc;
    
    /**
     *
     * @return
     */
    @Override
    public List<Users> findAllUsers() {
        String q = "SELECT * FROM users";

        List<Users> result = jdbc.query(q, new UserMapper());
        return result;
    }

    @Override
    public Users getUser (String username) {
        String q = "SELECT * FROM users WHERE username = " + username;
        Users result = jdbc.queryForObject(q, new UserMapper());
        return result;
    }

    @Override
    public Users saveNewUser(Users user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc).withTableName("users").usingGeneratedKeyColumns("id");
        HashMap parameters = new HashMap();
        parameters.put("username", user.getUsername());
        parameters.put("firstname", user.getFirstName());
        parameters.put("lastname", user.getLastName());
        parameters.put("email", user.getEmail());
        parameters.put("password", user.getPassword());
        final Number key = insert.executeAndReturnKey(parameters);
        final long pk = key.longValue();
    return user;
    }
}

    