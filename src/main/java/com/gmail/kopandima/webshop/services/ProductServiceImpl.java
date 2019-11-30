package com.gmail.kopandima.webshop.services;

import com.gmail.kopandima.webshop.models.Product;
import com.gmail.kopandima.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

}
