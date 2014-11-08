/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.mapper;

import com.springmaven.noteproject.domain.NoteEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author stasiuk-ps
 */
public class NoteMapper implements RowMapper<NoteEntity> {

    @Override
    public NoteEntity mapRow(ResultSet rs, int i) throws SQLException {
        NoteEntity note = new NoteEntity();
        note.setId(Long.valueOf(rs.getInt("id")));
        note.setTitle(rs.getString("title"));
        note.setDescription(rs.getString("description"));
        return note;
         
    }
    
}
