package com.example.codese_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

// ngang cap voi RestController
@RestControllerAdvice
public class ApiExceptionHandler {
    // MissingServletRequestParameterException

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public String unknownErr(Exception e, WebRequest request) {
//        return "dunno";
//    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String invalidInputException(Exception e, WebRequest request) {
        return "Thiếu input đầu vào";
    }

    @ExceptionHandler(LoginFailException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String loginFailException(Exception e, WebRequest request) {return "Wrong email or password";}

    @ExceptionHandler(AccountExistedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String accountExistedException(Exception e, WebRequest request) {return "Account existed";}

}
