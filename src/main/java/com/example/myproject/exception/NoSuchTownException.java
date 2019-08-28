package com.example.myproject.exception;

public class NoSuchTownException extends Exception{
    public NoSuchTownException() {
    }

    public NoSuchTownException(String message) {
        super(message);
    }

    public NoSuchTownException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchTownException(Throwable cause) {
        super(cause);
    }

    public NoSuchTownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
