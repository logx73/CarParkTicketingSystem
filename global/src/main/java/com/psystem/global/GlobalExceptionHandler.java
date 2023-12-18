package com.psystem.global;

import com.psystem.global.Exception.InvalidCharacterException;
import com.psystem.global.Exception.ParkingSpaceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCharacterException.class)
    ResponseEntity<List<String>> employeeNotFoundHandler(InvalidCharacterException ex) {
        return new ResponseEntity<>(Collections.singletonList(ex.getMessage()),HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ParkingSpaceException.class)
    ResponseEntity<String> employeeNotFoundHandler(ParkingSpaceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({RuntimeException.class})
    String runtimeException(RuntimeException ex){ return ex.getMessage(); };

}
