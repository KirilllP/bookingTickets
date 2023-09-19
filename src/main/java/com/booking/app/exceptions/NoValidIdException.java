package com.booking.app.exceptions;

public class NoValidIdException extends RuntimeException{
    public NoValidIdException(String message) {
        super(message);
    }
    public NoValidIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
