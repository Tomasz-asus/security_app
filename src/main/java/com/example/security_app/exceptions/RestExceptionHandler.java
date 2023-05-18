package com.example.security_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    public RestExceptionHandler() {
    }

    @ExceptionHandler(value = BasketNotFoundException.class)
    public ResponseEntity<String> handleBasketNotFound(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MotorcycleNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MotorcycleAlreadyExistException.class)
    public ResponseEntity<String> handleProductAlreadyExist(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExist(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RestExceptionHandler)) return false;
        final RestExceptionHandler other = (RestExceptionHandler) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RestExceptionHandler;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "RestExceptionHandler()";
    }
}
