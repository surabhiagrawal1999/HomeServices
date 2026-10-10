package com.homeserve.homeserve.exception;

public class ServiceNotFoundException extends RuntimeException{


    public ServiceNotFoundException(String message){
        super(message);
    }
}
