/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.mapper;

import com.springmaven.noteproject.domain.UserDto;
import com.springmaven.noteproject.domain.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author stasiuk-ps
 */
public class UserMapper implements RowMapper<Users> {
    
   

    @Override
    public Users mapRow(ResultSet rs, int i) throws SQLException {
        
        Users userDto = new Users();
        
        userDto.setUsername(rs.getString("username"));
        userDto.setFirstName(rs.getString("firstname"));
        userDto.setLastName(rs.getString("lastname"));
        userDto.setEmail(rs.getString("email"));
        userDto.setPassword(rs.getString("password"));
        return userDto;
        
    }
}
