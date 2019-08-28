package com.example.myproject.exception;

public class RepidNameOfTownException extends Exception {
    public RepidNameOfTownException() {
    }

    public RepidNameOfTownException(String message) {
        super(message);
    }

    public RepidNameOfTownException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepidNameOfTownException(Throwable cause) {
        super(cause);
    }

    public RepidNameOfTownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
