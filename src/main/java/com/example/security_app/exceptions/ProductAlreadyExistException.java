package com.example.security_app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductAlreadyExistException extends RuntimeException{

    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
