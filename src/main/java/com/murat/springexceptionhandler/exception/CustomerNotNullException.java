package com.murat.springexceptionhandler.exception;

public class CustomerNotNullException extends RuntimeException {
    public CustomerNotNullException(String message){
        super(message);
    }
}
