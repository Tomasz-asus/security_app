package com.example.security_app.service;

import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.model.Motorcycle;


public class MotorcycleMapper {


    public static Motorcycle fromDTO(
            MotorcycleDTO motorcycleDTO) {
        return new Motorcycle(
                motorcycleDTO.getMotorcycleName(),
                motorcycleDTO.getMotorcycleDescription(),
                motorcycleDTO.getMotorcyclePrice(),
                motorcycleDTO.getImageURL(),
                motorcycleDTO.getCategory());
    }

    public static MotorcycleDTO fromEntity(Motorcycle motorcycle) {
        return new MotorcycleDTO(motorcycle.getMotorcycleName(),
                motorcycle.getMotorcycleDescription(),
                motorcycle.getMotorcyclePrice(),
                motorcycle.getImageURL(),
                motorcycle.getCategory());
    }

}
