package com.example.security_app.DTO;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "_orderCartDTO")
public class OrderCartDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;
    private String street;
    private String postalCode;
    private String city;
    private Integer phoneNumber;
    private LocalDateTime orderDate;
    private String username;
    private String basketName;


    public OrderCartDTO(Integer id, String firstName, String lastName, String street, String postalCode, String city, Integer phoneNumber, LocalDateTime orderDate, String username, String basketName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.username = username;
        this.basketName = basketName;
    }

    public OrderCartDTO() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public String getUsername() {
        return this.username;
    }

    public String getBasketName() {
        return this.basketName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

}
