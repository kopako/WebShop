package com.gmail.kopandima.webshop.controllers;

import com.gmail.kopandima.webshop.models.Role;
import com.gmail.kopandima.webshop.models.User;
import com.gmail.kopandima.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    final UserRepository userService;

    @Autowired
    public RegistrationController(UserRepository userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Map<String, Object> model) {
        User userDB = userService.findByUsername(user.getUsername());

        if (userDB != null) {
            model.put("message", "User exists!");
        }
        Role role = new Role();
        role.setName("ROLE_USER");
        user.setEnabled(true);
        userService.save(user);
        return "redirect:/login";
    }
}
