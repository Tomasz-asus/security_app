package com.example.security_app.repository;

import com.example.security_app.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<Basket> findById(Integer id);
    Optional<Basket> findByBasketName(String name);
    void deleteByBasketName(String name);
}
