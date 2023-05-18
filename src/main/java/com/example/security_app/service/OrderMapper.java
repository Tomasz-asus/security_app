package com.example.security_app.service;

import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.model.Motorcycle;
import com.example.security_app.model.OrderCart;
import com.example.security_app.repository.BasketRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderMapper {


    private static BasketRepository basketRepository;



    public static OrderCart OrderfromDTO(OrderCartDTO orderCartDTO) {

        return new OrderCart(mappingProductsFromBasket(orderCartDTO.getBasketName()),
                orderCartDTO.getStreet(),
                orderCartDTO.getPostalCode(),
                orderCartDTO.getCity(),
                orderCartDTO.getPhoneNumber(),
                LocalDateTime.now(),
                orderCartDTO.getFirstAndLastName(),
                orderCartDTO.getUsername(),
                orderCartDTO.getBasketName()
        );
    }

    public static OrderCartDTO OrderfromEntity(OrderCart orderCart) {

        return new OrderCartDTO(orderCart.getUsername(),
                orderCart.getFirstAndLastName(),
                orderCart.getBasketName(),
                orderCart.getStreet(),
                orderCart.getPostalCode(),
                orderCart.getCity(),
                orderCart.getPhoneNumber());
    }

    private static List<Motorcycle> mappingProductsFromBasket(String basketName) {
        return new ArrayList<>(basketRepository.findByBasketName(basketName).get().getMotorcycles());
    }

}
