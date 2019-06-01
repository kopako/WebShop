package com.gmail.kopandima.webshop.repository;


import com.gmail.kopandima.webshop.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
