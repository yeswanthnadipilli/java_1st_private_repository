package com.simplejdbcapp.exception;

public class InvalidIdInputException extends RuntimeException{
    public InvalidIdInputException(String message) {
        super(message);
    }
}
