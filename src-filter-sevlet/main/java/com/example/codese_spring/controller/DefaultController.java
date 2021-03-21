package com.example.codese_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping("/default")
public class DefaultController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return (String) request.getAttribute("user_id");
    }

}

// JWT
// Filter (áp dụng cho mọi api) => baseController => controller
// Truy nhập vào request, response thông qua sevlet
// Filter (custom cho từng api)

// Base Controller
