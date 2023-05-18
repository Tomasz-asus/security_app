package com.example.security_app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MotorcycleAlreadyExistException extends RuntimeException{

    public MotorcycleAlreadyExistException(String message) {
        super(message);
    }
}
