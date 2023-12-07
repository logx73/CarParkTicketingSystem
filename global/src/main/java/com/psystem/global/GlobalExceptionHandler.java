package com.psystem.global;

import com.psystem.global.Exception.InvalidCharacterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCharacterException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(InvalidCharacterException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler({RuntimeException.class})
    String runtimeException(RuntimeException ex){ return ex.getMessage(); };

}
