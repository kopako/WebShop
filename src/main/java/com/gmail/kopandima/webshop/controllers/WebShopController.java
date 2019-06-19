package com.gmail.kopandima.webshop.controllers;

import com.gmail.kopandima.webshop.models.Product;
import com.gmail.kopandima.webshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebShopController {

    private final ProductService productService;

    @Autowired
    public WebShopController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("allProducts")
    public List<Product> populateProducts() {
        return (List<Product>) this.productService.findAll();
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
