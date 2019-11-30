package com.gmail.kopandima.webshop.services;

import com.gmail.kopandima.webshop.models.User;

import javax.security.sasl.AuthenticationException;

public interface UserService {

    void save(User customUser);
    User findByUsername(String username);
    void register(User customUser) throws AuthenticationException;
}
