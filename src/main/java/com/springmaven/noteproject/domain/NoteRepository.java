/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.domain;

/**
 *
 * @author stasiuk-ps
 */
import java.util.List;

public interface NoteRepository {

    List<NoteEntity> findAll();
    
    NoteEntity findById(long id);
    
    NoteEntity save(NoteEntity note);
    
    NoteEntity delete(long id);
    
}
