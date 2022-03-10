package com.simplejdbcapp.exception;

public class FieldCannotEmptyException extends RuntimeException {
    public FieldCannotEmptyException(String message) {
        super(message);
    }
}
