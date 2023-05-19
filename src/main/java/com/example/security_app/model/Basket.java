package com.example.security_app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "_basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Motorcycle> motorcycles = new ArrayList<>();

    private String basketName;

    public Basket(Integer id, List<Motorcycle> motorcycles, String basketName) {
        this.id = id;
        this.motorcycles = motorcycles;
        this.basketName = basketName;
    }

    public Basket() {
    }

    public static BasketBuilder builder() {
        return new BasketBuilder();
    }


    public void removeMotorcycleFromBasket(Motorcycle byMotorcycleName) {
        motorcycles.remove(motorcycles);
    }

    public Integer getId() {
        return this.id;
    }

    public List<Motorcycle> getMotorcycles() {
        return this.motorcycles;
    }

    public String getBasketName() {
        return this.basketName;
    }


    public static class BasketBuilder {
        private Integer id;
        private List<Motorcycle> motorcycles;
        private String basketName;

        BasketBuilder() {
        }

        public BasketBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BasketBuilder motorcycles(List<Motorcycle> motorcycles) {
            this.motorcycles = motorcycles;
            return this;
        }

        public BasketBuilder basketName(String basketName) {
            this.basketName = basketName;
            return this;
        }

        public Basket build() {
            return new Basket(this.id, this.motorcycles, this.basketName);
        }

        public String toString() {
            return "Basket.BasketBuilder(id=" + this.id + ", motorcycles=" + this.motorcycles + ", basketName=" + this.basketName + ")";
        }
    }
}
