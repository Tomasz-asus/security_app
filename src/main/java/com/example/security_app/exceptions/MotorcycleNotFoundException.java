package com.example.security_app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MotorcycleNotFoundException extends RuntimeException {

    public MotorcycleNotFoundException(String message) {
        super(message);
    }
}
