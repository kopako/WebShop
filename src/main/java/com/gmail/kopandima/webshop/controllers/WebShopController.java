package com.gmail.kopandima.webshop.controllers;

import com.gmail.kopandima.webshop.models.Product;
import com.gmail.kopandima.webshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebShopController {

    final ProductService productService;

    @Autowired
    public WebShopController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("allProducts")
    public List<Product> populateProducts() {
        return (List<Product>) this.productService.findAll();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/";
    }

}
