package com.booking.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> catchNoContentException(NotFoundException e) {

        HttpStatus noFound = HttpStatus.NOT_FOUND;
        TemplateApiException apiException = new TemplateApiException(
                e.getMessage(),
                e,
                noFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, noFound);
    }

    @ExceptionHandler(value = {NoValidIdException.class})
    public ResponseEntity<Object> catchNoValidIdException(NoValidIdException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        TemplateApiException apiException = new TemplateApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

}