package com.example.security_app.service;

import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.model.Motorcycle;
import com.example.security_app.model.OrderCart;
import com.example.security_app.repository.BasketRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {


    private static BasketRepository basketRepository;

    public OrderMapper() {
    }


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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderMapper)) return false;
        final OrderMapper other = (OrderMapper) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderMapper;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "OrderMapper()";
    }
}
