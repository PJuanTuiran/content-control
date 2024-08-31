package com.riwi.workshop.controllers.handlerError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error
}
