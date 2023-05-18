package com.example.security_app.service;

import com.example.security_app.DTO.MotorcycleDTO;
import com.example.security_app.model.Motorcycle;


public class MotorcycleMapper {

    public MotorcycleMapper() {
    }

    public static MotorcycleDTO fromEntity(Motorcycle motorcycle) {
        return new MotorcycleDTO(motorcycle.getMotorcycleName(),
                motorcycle.getMotorcycleDescription(),
                motorcycle.getMotorcyclePrice(),
                motorcycle.getImageURL(),
                motorcycle.getCategory());
    }

    public static Motorcycle fromDTO(MotorcycleDTO motorcycleDTO) {
        return new Motorcycle(
                motorcycleDTO.getMotorcycleName(),
                motorcycleDTO.getMotorcycleDescription(),
                motorcycleDTO.getMotorcyclePrice(),
                motorcycleDTO.getImageURL(),
                motorcycleDTO.getCategory());
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MotorcycleMapper)) return false;
        final MotorcycleMapper other = (MotorcycleMapper) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MotorcycleMapper;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "MotorcycleMapper()";
    }
}
