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
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class NoteEntity implements Serializable {
    
    private Long id;
    private String title;
    private String description;
    private String picture;
    
    @JsonIgnore
    private MultipartFile pictureFile;
    
    // ... additional members, often include @OneToMany mappings

    public NoteEntity() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }
    
    public NoteEntity(String name, String description) {
        this.title = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
    }

    
}
