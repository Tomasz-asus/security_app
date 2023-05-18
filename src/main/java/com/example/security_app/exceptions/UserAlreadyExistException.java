package com.example.security_app.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public String toString() {
        return "UserAlreadyExistException()";
    }

    }

