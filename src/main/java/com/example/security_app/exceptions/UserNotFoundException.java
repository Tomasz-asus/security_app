package com.example.security_app.exceptions;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public String toString() {
        return "UserNotFoundException()";
    }

}

