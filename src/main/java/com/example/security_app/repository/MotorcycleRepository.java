package com.example.security_app.repository;

import com.example.security_app.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

    Optional<Motorcycle> findByMotorcycleName(String motorcycleName);
    void deleteByMotorcycleName(String motorcycleName);
}
