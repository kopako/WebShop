package com.gmail.kopandima.webshop.services;

import com.gmail.kopandima.webshop.models.*;
import com.gmail.kopandima.webshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User customUser) {
        userRepository.save(customUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(User customUser) throws AuthenticationException {
        if (userRepository.findByUsername(customUser.getUsername())!=null) {
            throw new AuthenticationException("CustomUser already exists");
        }
        HashSet<Role> userRoles = new HashSet<>();
        Role userRole = new Role();
          userRole.setName("ROLE_USER");
        userRoles.add(userRole);
        customUser.setRoles(userRoles);
        userRepository.save(customUser);
    }
}
