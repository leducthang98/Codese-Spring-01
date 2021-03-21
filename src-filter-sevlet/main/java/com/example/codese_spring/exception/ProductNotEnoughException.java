package com.example.codese_spring.exception;

public class ProductNotEnoughException extends RuntimeException {
    public ProductNotEnoughException(String message) {
        super(message);
    }
}
