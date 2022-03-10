package com.simplejdbcapp.exception;

public class SearchUserNotPresentException extends RuntimeException {

    public SearchUserNotPresentException(String message) {
        super(message);
    }
}
