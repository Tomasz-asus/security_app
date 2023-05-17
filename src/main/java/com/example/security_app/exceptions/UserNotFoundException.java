package com.example.security_app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserNotFoundException extends RuntimeException{

        public UserNotFoundException(String message) {
            super(message);
        }
    }

