package com.simplejdbcapp.exception;

public class NoRecordsException extends RuntimeException {
    public NoRecordsException(String message) {
        super(message);
    }
}
