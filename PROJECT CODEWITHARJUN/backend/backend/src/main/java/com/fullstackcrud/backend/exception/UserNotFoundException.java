package com.fullstackcrud.backend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id){
        super("could not found ");
    }
}
