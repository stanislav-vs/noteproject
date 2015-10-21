/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.controller;

import com.springmaven.noteproject.dao.UserDao;
import com.springmaven.noteproject.domain.model.User;
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
    private UserDao userDao; 
    
    @RequestMapping("/users")
    public String getUsersPage(Model model) {
        List<User> usersList = userDao.findAllUsers();
        model.addAttribute("list", usersList);
        return "users";
    }  
    
    @RequestMapping(value="/userslist", method = RequestMethod.POST)
    @ResponseBody
    public List<User> usersList () {
        List<User> usersList = userDao.findAllUsers();
        return usersList;
    }
}
