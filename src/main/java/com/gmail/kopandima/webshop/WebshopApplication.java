package com.gmail.kopandima.webshop;

import com.gmail.kopandima.webshop.models.User;
import com.gmail.kopandima.webshop.models.Role;
import com.gmail.kopandima.webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User testUser = User.CustomUserBuilder.aCustomUser()
                .withPassword("$2a$10$.KR5Zh.QXEA33491jUcZTuJ2e653BLDFuZybm4zQc9jHPahYsJOSq")
                .withUsername("test")
                .withRoles(new ArrayList<Role>())
                .build();
        userService.save(testUser);
    }
}
