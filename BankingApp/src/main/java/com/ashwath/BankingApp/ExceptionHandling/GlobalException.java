package com.ashwath.BankingApp.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(value = UserNotFoundException.class)
public ResponseEntity<ExceptionInfo> userNotFoundExe(UserNotFoundException ex){
ExceptionInfo info=new ExceptionInfo();
info.setMessage(ex.getMessage());
info.setStatusCode(401);
    return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
}

}
