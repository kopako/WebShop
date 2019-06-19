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
@RequestMapping("/product/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute
    public Product product() {
        return new Product();
    }


    @GetMapping("add")
    public String addForm(){
        return "addProduct";
    }

    @PostMapping("add")
    public String add(@ModelAttribute Product product, @RequestParam(value = "multipartFile") MultipartFile multipartFile) {
        try {
            product.setImageBase64(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.save(product);
        return "redirect:/";
    }

    @PostMapping("delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.delete(productService.findById(id));
        return "redirect:/";
    }

}
