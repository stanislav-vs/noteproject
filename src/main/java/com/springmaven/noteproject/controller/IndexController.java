/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.controller;

import com.springmaven.noteproject.domain.NoteEntity;
import com.springmaven.noteproject.domain.NoteRepository;
import java.util.List;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author stasiuk-ps
 */
 
 
@Controller 
public class IndexController { 
    protected final Logger log = LoggerFactory.getLogger(getClass()); 
 
    @Autowired 
    private NoteRepository noteRepository; 
 
    @RequestMapping("/") 
    public String home(Model model) {
        List<NoteEntity> noteList = noteRepository.findAll();
        model.addAttribute("list", noteList);
        return "home"; 
    }
    
     
    @RequestMapping("/note/{id}")
    public String editNote(Model model, @PathVariable("id") long id) {
        NoteEntity oneNote = noteRepository.findById(id);
        model.addAttribute("note", oneNote);
        return "/editnote";
    }
    
    @RequestMapping("/note/create")
    public String createNote(Model model) {
        NoteEntity newNote = new NoteEntity();
        
        model.addAttribute("note", newNote);
        return "editnote";
    }
    
    @RequestMapping(value="/savenote", method = RequestMethod.POST)
    public @ResponseBody NoteEntity saveNote (NoteEntity note) {
        
        return this.noteRepository.save(note);
        
    }
    
    @RequestMapping(value="/deletenote", method = RequestMethod.GET)
    public NoteEntity deleteNote (@RequestParam("id") long id) {
        
        return this.noteRepository.delete(id);
    }

    
} 


