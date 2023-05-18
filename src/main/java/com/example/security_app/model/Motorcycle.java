package com.example.security_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_product")
public class Motorcycle {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


    private String motorcycleName;
    private String motorcycleDescription;
    private Double motorcyclePrice;
    private String imageURL;

    @Enumerated(EnumType.STRING)
    private MotorcycleCategory category;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Basket> baskets;

    public Motorcycle(String motorcycleName, String motorcycleDescription, Double motorcyclePrice, String imageURL, MotorcycleCategory category) {
    }
}
