package com.example.security_app.DTO;

import com.example.security_app.model.MotorcycleCategory;


public class MotorcycleDTO {

    private String motorcycleName;
    private String motorcycleDescription;
    private Double motorcyclePrice;
    private String imageURL;
    private MotorcycleCategory category;

    public MotorcycleDTO(String motorcycleName, String motorcycleDescription, Double motorcyclePrice, String imageURL, MotorcycleCategory category) {
        this.motorcycleName = motorcycleName;
        this.motorcycleDescription = motorcycleDescription;
        this.motorcyclePrice = motorcyclePrice;
        this.imageURL = imageURL;
        this.category = category;
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

}
