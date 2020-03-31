package com.example.webstore.Exceptions.signUp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignUpUserNotFoundController {
    @ExceptionHandler(value = SignUpUserNotFoundException.class)
    public ResponseEntity<Object> exception(SignUpUserNotFoundException exception) {
        return new ResponseEntity<>("UserName found before", HttpStatus.NOT_FOUND);
    }
}
