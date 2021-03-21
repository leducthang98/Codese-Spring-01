package com.example.codese_spring.helper.ResponseBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseForm<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResponseForm<T> buildResponse(T data) {
        ResponseForm<T> response = new ResponseForm<T>();
        response.data = data;
        response.code = 0;
        response.message = "ok";
        return response;
    }

    public static <T> ResponseForm<T> buildCustomResponse(T data, int code, String message) {
        ResponseForm<T> response = new ResponseForm<T>();
        response.data = data;
        response.code = code;
        response.message = message;
        return response;
    }
}
