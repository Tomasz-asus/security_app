package com.example.security_app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public String toString() {
        return "UserAlreadyExistException()";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserAlreadyExistException)) return false;
        final UserAlreadyExistException other = (UserAlreadyExistException) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserAlreadyExistException;
    }

    public int hashCode() {
        int result = super.hashCode();
        return result;
    }
}
