package com.example.security_app.service;

import com.example.security_app.DTO.OrderCartDTO;
import com.example.security_app.model.OrderCart;
import com.example.security_app.repository.BasketRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderMapper {


    private static BasketRepository basketRepository;

    public OrderMapper() {
    }


    public static OrderCart OrderFromDTO(OrderCartDTO orderCartDTO) {

        return new OrderCart(
                mappingMotorcyclesFromBasket(orderCartDTO.getBasketName()),
                        orderCartDTO.getFirstName(),
                        orderCartDTO.getLastName(),
                        orderCartDTO.getStreet(),
                        orderCartDTO.getPostalCode(),
                        orderCartDTO.getCity(),
                        orderCartDTO.getPhoneNumber(),
                        LocalDateTime.now(),
                        orderCartDTO.getUsername(),
                        orderCartDTO.getBasketName()
                        );
}

    private static Object mappingMotorcyclesFromBasket(String basketName) {
        return new ArrayList<>(basketRepository.findByBasketName(basketName).get().getMotorcycles());}

    public static OrderCartDTO OrderFromEntity(OrderCart orderCart) {

        return new OrderCartDTO(
                orderCart.getId(),
                orderCart.getFirstName(),
                orderCart.getLastName(),
                orderCart.getStreet(),
                orderCart.getPostalCode(),
                orderCart.getCity(),
                orderCart.getPhoneNumber(),
                LocalDateTime.now(),
                orderCart.getUsername(),
                orderCart.getBasketName());
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
