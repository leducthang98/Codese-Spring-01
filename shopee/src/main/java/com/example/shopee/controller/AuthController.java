package com.example.shopee.controller;

import com.example.shopee.dto.LoginResponseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    public LoginResponseDto login(@RequestBody String email, @RequestBody String password){
        
    }
}
