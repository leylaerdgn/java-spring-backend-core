package com.leyla.spring_demo.exception;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(String message){
        super(message);
    }
}
