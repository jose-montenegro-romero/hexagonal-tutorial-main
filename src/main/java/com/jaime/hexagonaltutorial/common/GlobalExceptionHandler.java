package com.jaime.hexagonaltutorial.common;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception, HttpServletRequest httpRequest) throws UnsupportedEncodingException {

        log.info("NoSuchElementException (404) handled");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("NOT FOUND, request: " + httpRequest.getRequestURI());
    }
}
