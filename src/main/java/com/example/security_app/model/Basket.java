package com.example.security_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Motorcycle> motorcycles = new ArrayList<>();

    private String basketName;


    public void removeMotorcycleFromBasket(Motorcycle byMotorcycleName) {
        motorcycles.remove(motorcycles);
    }
}
