package com.gmail.kopandima.webshop.controllers;

import com.gmail.kopandima.webshop.models.Product;
import com.gmail.kopandima.webshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/addProduct")
public class AddProductController {

    private final ProductService productService;

    @Autowired
    public AddProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute
    public Product product() {
        return new Product();
    }


    @GetMapping
    public String addProductForm(){
        return "addProduct";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product, @RequestParam(value = "multipartFile") MultipartFile multipartFile) {
        try {
            product.setImageBase64(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.save(product);
        return "redirect:/";
    }

}
