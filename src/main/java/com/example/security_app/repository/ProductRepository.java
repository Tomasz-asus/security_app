package com.example.security_app.repository;

import com.example.security_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByMotorcycleName(String motorcycleName);
    void deleteByMotorcycleName(String motorcycleName);
}
