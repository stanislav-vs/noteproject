/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmaven.noteproject.controller;

import com.springmaven.noteproject.domain.UserDto;
import com.springmaven.noteproject.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author stasiuk-ps
 */
@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authMgr;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") UserDto userAccountData,
            BindingResult result, WebRequest request, Errors errors) {

        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", userAccountData);
        } else {
            return new ModelAndView("successRegister", "user", userAccountData);
        }
    }

    private UserDto createUserAccount(UserDto userAccountData, BindingResult result) {
        try {
            
//            String registered = userRepository.saveNewUser(userAccountData);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }
        return null;
    }

}
