package com.example.security_app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "_motorcycle")
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Motorcycle(Integer id, String motorcycleName, String motorcycleDescription, Double motorcyclePrice, String imageURL, MotorcycleCategory category, List<Basket> baskets) {
        this.id = id;
        this.motorcycleName = motorcycleName;
        this.motorcycleDescription = motorcycleDescription;
        this.motorcyclePrice = motorcyclePrice;
        this.imageURL = imageURL;
        this.category = category;
        this.baskets = baskets;
    }

    public Motorcycle() {
    }

    public static MotorcycleBuilder builder() {
        return new MotorcycleBuilder();
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Motorcycle)) return false;
        final Motorcycle other = (Motorcycle) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$motorcycleName = this.getMotorcycleName();
        final Object other$motorcycleName = other.getMotorcycleName();
        if (this$motorcycleName == null ? other$motorcycleName != null : !this$motorcycleName.equals(other$motorcycleName))
            return false;
        final Object this$motorcycleDescription = this.getMotorcycleDescription();
        final Object other$motorcycleDescription = other.getMotorcycleDescription();
        if (this$motorcycleDescription == null ? other$motorcycleDescription != null : !this$motorcycleDescription.equals(other$motorcycleDescription))
            return false;
        final Object this$motorcyclePrice = this.getMotorcyclePrice();
        final Object other$motorcyclePrice = other.getMotorcyclePrice();
        if (this$motorcyclePrice == null ? other$motorcyclePrice != null : !this$motorcyclePrice.equals(other$motorcyclePrice))
            return false;
        final Object this$imageURL = this.getImageURL();
        final Object other$imageURL = other.getImageURL();
        if (this$imageURL == null ? other$imageURL != null : !this$imageURL.equals(other$imageURL)) return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final Object this$baskets = this.getBaskets();
        final Object other$baskets = other.getBaskets();
        if (this$baskets == null ? other$baskets != null : !this$baskets.equals(other$baskets)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Motorcycle;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $motorcycleName = this.getMotorcycleName();
        result = result * PRIME + ($motorcycleName == null ? 43 : $motorcycleName.hashCode());
        final Object $motorcycleDescription = this.getMotorcycleDescription();
        result = result * PRIME + ($motorcycleDescription == null ? 43 : $motorcycleDescription.hashCode());
        final Object $motorcyclePrice = this.getMotorcyclePrice();
        result = result * PRIME + ($motorcyclePrice == null ? 43 : $motorcyclePrice.hashCode());
        final Object $imageURL = this.getImageURL();
        result = result * PRIME + ($imageURL == null ? 43 : $imageURL.hashCode());
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $baskets = this.getBaskets();
        result = result * PRIME + ($baskets == null ? 43 : $baskets.hashCode());
        return result;
    }

    public String toString() {
        return "Motorcycle(id=" + this.getId() + ", motorcycleName=" + this.getMotorcycleName() + ", motorcycleDescription=" + this.getMotorcycleDescription() + ", motorcyclePrice=" + this.getMotorcyclePrice() + ", imageURL=" + this.getImageURL() + ", category=" + this.getCategory() + ", baskets=" + this.getBaskets() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getMotorcycleName() {
        return this.motorcycleName;
    }

    public String getMotorcycleDescription() {
        return this.motorcycleDescription;
    }

    public Double getMotorcyclePrice() {
        return this.motorcyclePrice;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public MotorcycleCategory getCategory() {
        return this.category;
    }

    public List<Basket> getBaskets() {
        return this.baskets;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMotorcycleName(String motorcycleName) {
        this.motorcycleName = motorcycleName;
    }

    public void setMotorcycleDescription(String motorcycleDescription) {
        this.motorcycleDescription = motorcycleDescription;
    }

    public void setMotorcyclePrice(Double motorcyclePrice) {
        this.motorcyclePrice = motorcyclePrice;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCategory(MotorcycleCategory category) {
        this.category = category;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public static class MotorcycleBuilder {
        private Integer id;
        private String motorcycleName;
        private String motorcycleDescription;
        private Double motorcyclePrice;
        private String imageURL;
        private MotorcycleCategory category;
        private List<Basket> baskets;

        MotorcycleBuilder() {
        }

        public MotorcycleBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public MotorcycleBuilder motorcycleName(String motorcycleName) {
            this.motorcycleName = motorcycleName;
            return this;
        }

        public MotorcycleBuilder motorcycleDescription(String motorcycleDescription) {
            this.motorcycleDescription = motorcycleDescription;
            return this;
        }

        public MotorcycleBuilder motorcyclePrice(Double motorcyclePrice) {
            this.motorcyclePrice = motorcyclePrice;
            return this;
        }

        public MotorcycleBuilder imageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public MotorcycleBuilder category(MotorcycleCategory category) {
            this.category = category;
            return this;
        }

        public MotorcycleBuilder baskets(List<Basket> baskets) {
            this.baskets = baskets;
            return this;
        }

        public Motorcycle build() {
            return new Motorcycle(this.id, this.motorcycleName, this.motorcycleDescription, this.motorcyclePrice, this.imageURL, this.category, this.baskets);
        }

        public String toString() {
            return "Motorcycle.MotorcycleBuilder(id=" + this.id + ", motorcycleName=" + this.motorcycleName + ", motorcycleDescription=" + this.motorcycleDescription + ", motorcyclePrice=" + this.motorcyclePrice + ", imageURL=" + this.imageURL + ", category=" + this.category + ", baskets=" + this.baskets + ")";
        }
    }
}
