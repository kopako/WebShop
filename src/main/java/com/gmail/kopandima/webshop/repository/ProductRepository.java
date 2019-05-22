package com.gmail.kopandima.webshop.repository;


import com.gmail.kopandima.webshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
