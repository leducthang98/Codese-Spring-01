package com.example.codese_spring.exception;

public class AccountExistedException extends Exception{
    public AccountExistedException(String message) {
        super(message);
    }
}
