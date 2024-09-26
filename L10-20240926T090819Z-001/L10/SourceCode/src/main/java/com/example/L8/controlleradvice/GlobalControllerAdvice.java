package com.example.L8.controlleradvice;

import com.example.L8.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler( value = UserNotFoundException.class)
    public ResponseEntity<String> catchUserNotFound(){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }



}
