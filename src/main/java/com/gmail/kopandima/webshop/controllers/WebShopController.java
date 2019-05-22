package com.gmail.kopandima.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebShopController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
