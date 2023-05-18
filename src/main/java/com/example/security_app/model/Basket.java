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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMotorcycles(List<Motorcycle> motorcycles) {
        this.motorcycles = motorcycles;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Basket)) return false;
        final Basket other = (Basket) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$motorcycles = this.getMotorcycles();
        final Object other$motorcycles = other.getMotorcycles();
        if (this$motorcycles == null ? other$motorcycles != null : !this$motorcycles.equals(other$motorcycles))
            return false;
        final Object this$basketName = this.getBasketName();
        final Object other$basketName = other.getBasketName();
        if (this$basketName == null ? other$basketName != null : !this$basketName.equals(other$basketName))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Basket;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $motorcycles = this.getMotorcycles();
        result = result * PRIME + ($motorcycles == null ? 43 : $motorcycles.hashCode());
        final Object $basketName = this.getBasketName();
        result = result * PRIME + ($basketName == null ? 43 : $basketName.hashCode());
        return result;
    }

    public String toString() {
        return "Basket(id=" + this.getId() + ", motorcycles=" + this.getMotorcycles() + ", basketName=" + this.getBasketName() + ")";
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
