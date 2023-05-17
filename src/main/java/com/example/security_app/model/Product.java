package com.example.security_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_motorcycle")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


    private String motorcycleName;
    private String motorcycleDescription;
    private Double motorcyclePrice;
    private String imageURL;

    @Enumerated(EnumType.STRING)
    private MotorcycleType motorcycleType;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Basket> basketList;

}
