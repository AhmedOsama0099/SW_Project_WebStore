package com.example.webstore.Exceptions.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginUserExceptionController {
    @ExceptionHandler(value = LoginUserNotFoundException.class)
    public ResponseEntity<Object> exception(LoginUserNotFoundException exception) {
        return new ResponseEntity<>("User not found or Pw is not correct", HttpStatus.NOT_FOUND);
    }
}
