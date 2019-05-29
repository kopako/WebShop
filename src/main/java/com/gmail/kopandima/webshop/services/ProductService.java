package com.gmail.kopandima.webshop.services;

import com.gmail.kopandima.webshop.models.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void update(Product product);

    void delete(Product product);
}
