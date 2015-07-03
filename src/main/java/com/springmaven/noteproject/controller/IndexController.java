/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.controller;

import com.springmaven.noteproject.domain.NoteEntity;
import com.springmaven.noteproject.domain.NoteRepository;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 *
 * @author stasiuk-ps
 */
 
@Controller 
public class IndexController { 
 
    @RequestMapping(value="/login.html", method = RequestMethod.POST)
    public String loginPage(Model model){
        return "login.html";
    }
    
    @RequestMapping(value="/logout.html", method = RequestMethod.POST)
    public String logoutPage(Model model){
        return "login.html";
    }
    
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login.html";
    }
  
    protected final Logger log = LoggerFactory.getLogger(getClass()); 
    
    @Autowired 
    private NoteRepository noteRepository; 
 
    @RequestMapping("/") 
    public String home(Model model) {
        List<NoteEntity> noteList = noteRepository.findAll();
        model.addAttribute("list", noteList);
        return "home";
    }
    
   
    
     
    @RequestMapping(value="/note/edit", method = RequestMethod.POST)
    @ResponseBody
    public String editNote(@RequestParam("id") long id) {
        NoteEntity oneNote = noteRepository.findById(id);
        this.noteRepository.save(oneNote);
        return "ok";
    }
    
    @RequestMapping("/note/create")
    public String createNote(Model model) {
        NoteEntity newNote = new NoteEntity();
        
        model.addAttribute("note", newNote);
        return "createnote";
    }
    
    @RequestMapping(value="/note/save", method = RequestMethod.POST)
    public @ResponseBody NoteEntity saveNote (NoteEntity note, MultipartHttpServletRequest request, HttpServletResponse response) {
        
        if (!note.getPictureFile().isEmpty()) {
            
            try {
                String fileName = UUID.randomUUID().toString();
                
                String path = request.getServletContext().getRealPath("/");
                
                byte[] bytes = note.getPictureFile().getBytes();
                File directory = new File(path+ "/uploads");
                directory.mkdirs();
                File file = new File(directory.getAbsolutePath() + System.getProperty("file.separator") + fileName);
                
                BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(file));
                stream.write(bytes);
                
                note.setPicture(fileName);
                
                stream.close();
            } catch (Exception e) {
                return null;
            }
        }
        
        return this.noteRepository.save(note);
        
    }
    
    
    @RequestMapping(value="/note/delete", method = RequestMethod.POST)
    @ResponseBody
    
    public String deleteNote (@RequestParam("id") long id) {
        noteRepository.delete(id);
        return "ok";
    }

    @RequestMapping(value="/note/list", method = RequestMethod.POST)
    @ResponseBody
    public List<NoteEntity> noteList () {
        List<NoteEntity> noteList = noteRepository.findAll();
        return noteList;
    }
    
            
} 


