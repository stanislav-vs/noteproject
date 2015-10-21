/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.mapper;

import com.springmaven.noteproject.dao.RoleDao;
import com.springmaven.noteproject.domain.model.Role;
import com.springmaven.noteproject.domain.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author stasiuk-ps
 */
public class UserMapper implements RowMapper<User> {
    
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        
        User user = new User();
        user.setId(Long.valueOf(rs.getInt("id")));
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
        
    }
}
