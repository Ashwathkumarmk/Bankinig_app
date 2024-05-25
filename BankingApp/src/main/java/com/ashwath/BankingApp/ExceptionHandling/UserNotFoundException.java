package com.ashwath.BankingApp.ExceptionHandling;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg){
        super(msg);
    }
}
