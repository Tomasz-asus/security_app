package com.example.security_app.repository;

import com.example.security_app.model.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCartRepository extends JpaRepository<OrderCart, Integer> {


}
