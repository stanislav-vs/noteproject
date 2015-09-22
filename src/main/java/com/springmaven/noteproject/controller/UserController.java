/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.controller;

import com.springmaven.noteproject.domain.UserRepository;
import com.springmaven.noteproject.domain.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author stasiuk-ps
 */

@Controller
public class UserController {
 
    @Autowired 
    private UserRepository userRepository; 
    
    @RequestMapping("/users")
    public String getUsersPage(Model model) {
        List<Users> usersList = userRepository.findAllUsers();
        model.addAttribute("list", usersList);
        return "users";
    }  
    
    @RequestMapping(value="/list/users", method = RequestMethod.POST)
    @ResponseBody
    public List<Users> usersList () {
        List<Users> usersList = userRepository.findAllUsers();
        return usersList;
    }
}
