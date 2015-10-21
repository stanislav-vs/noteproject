/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.dao;

import com.springmaven.noteproject.domain.model.User;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author stasiuk-ps
 */

public interface UserDao {
    
    public User getUser(String username);

    public User saveNewUser(User user) throws SQLException;

    public User findByEmail(String email);

    public List<User> findAllUsers();
    
}
