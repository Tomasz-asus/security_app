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
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


    private String productName;
    private String productDescription;
    private Double productPrice;
    private String imageURL;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Basket> baskets;
}
