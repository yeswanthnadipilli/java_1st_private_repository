package com.simplejdbcapp.exception;

public class UserIdAlreadyTakenException extends RuntimeException {
    public UserIdAlreadyTakenException(String message) {
        super(message);
    }
}
