package com.booking.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResponseStatusException extends RuntimeException{
    public ResponseStatusException(Long id) {
        super("Could not find employee " + id);
    }
}
