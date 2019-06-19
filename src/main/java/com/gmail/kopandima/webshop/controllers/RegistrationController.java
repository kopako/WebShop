package com.gmail.kopandima.webshop.controllers;

import com.gmail.kopandima.webshop.models.*;
import com.gmail.kopandima.webshop.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

import javax.security.sasl.AuthenticationException;

@Controller
public class RegistrationController {
    final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationForm(User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Map<String, Object> model) {
        try {
            userService.register(user);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }
        return "redirect:/login";
    }
}
