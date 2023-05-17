package com.example.security_app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasketNotFoundException extends RuntimeException {

    public BasketNotFoundException(String message) {
        super(message);
    }
}
