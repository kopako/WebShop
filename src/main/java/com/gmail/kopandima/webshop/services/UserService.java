package com.gmail.kopandima.webshop.services;

import com.gmail.kopandima.webshop.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(User user);
    User findByUsername(String username);
}
