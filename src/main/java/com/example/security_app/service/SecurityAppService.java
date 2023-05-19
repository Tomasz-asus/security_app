package com.example.security_app.service;

import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.model.Basket;
import com.example.security_app.model.Motorcycle;

import java.util.List;

public interface SecurityAppService {

    MotorcycleDTO addMotorcycle(MotorcycleDTO motorcycleDTO);

    List<MotorcycleDTO> getAllMotorcycles();

    List<Basket> getAllBaskets();

    void deleteMotorcycle(String name);

    void deleteBasket(String name);

    void deleteMotorcycleFromBasket(String basket, String motorcycleName);

    void clearMotorcyclesList();

    void addBasket(Basket basket);

    void addMotorcycleToBasket(String basketName, String motorcycleName);

    List<Motorcycle> getAllMotorcyclesFromBasket(String basketName);

    OrderCartDTO addOrder(OrderCartDTO orderDTO);
}

