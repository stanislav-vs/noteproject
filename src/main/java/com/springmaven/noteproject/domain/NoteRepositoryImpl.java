/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain;

import com.springmaven.noteproject.mapper.NoteMapper;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    @Override
    public List<NoteEntity> findAll() {
        String q = "SELECT * FROM notes";

        List<NoteEntity> result = jdbc.query(q, new NoteMapper());
        return result;
    }

    @Override
    public NoteEntity findById(long id) {
        String q = "SELECT * FROM notes WHERE id = " + id;
        NoteEntity result = jdbc.queryForObject(q, new NoteMapper());
        return result;
    }

    @Override
    public NoteEntity save(NoteEntity note) {
        if (note.getId() == 0) {
            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc).withTableName("notes").usingGeneratedKeyColumns("id");
            HashMap parameters = new HashMap();
            parameters.put("title", note.getTitle());
            parameters.put("description", note.getDescription());
            final Number key = insert.executeAndReturnKey(parameters);
            final long pk = key.longValue();
            note.setId(pk);
        } else {
            String q = "UPDATE notes SET title=?, description=? WHERE id=?";
            jdbc.update(q, new Object[]{note.getTitle(), note.getDescription(), note.getId()});
        }
        return note;
    }

    @Override
    public NoteEntity delete(long id) {
        String q = "DELETE FROM notes WHERE id=?";
        jdbc.update(q, new Object[]{id});
        return null;
    }

}
