package com.example.codese_spring.exception;

public class LoginFailException extends Exception{
    public LoginFailException(String message){
        super(message);
    }
}
