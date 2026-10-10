package com.homeserve.homeserve.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleServiceNotFound(ServiceNotFoundException ex){
        ErrorResponse errorResponse= new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND). body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgInvalid(MethodArgumentNotValidException ex){
       String message= ex.getBindingResult().getFieldErrors().getFirst().getDefaultMessage();
       ErrorResponse err= new ErrorResponse(HttpStatus.BAD_REQUEST, message);
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
