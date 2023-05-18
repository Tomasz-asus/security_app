package com.example.security_app.exceptions;


public class MotorcycleNotFoundException extends RuntimeException {

    public MotorcycleNotFoundException(String message) {
        super(message);
    }

    public String toString() {
        return "MotorcycleNotFoundException()";
    }

}
