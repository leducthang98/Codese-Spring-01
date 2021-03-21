package com.example.codese_spring.controller;

import com.example.codese_spring.dto.AccountDTO;
import com.example.codese_spring.dto.LoginSessionDTO;
import com.example.codese_spring.dto.SignInDTO;
import com.example.codese_spring.exception.AccountExistedException;
import com.example.codese_spring.helper.ResponseBuilder.ResponseForm;
import com.example.codese_spring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseForm<LoginSessionDTO>> loginSession(@RequestBody SignInDTO signInDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(authService.loginSession(signInDTO), 1, "okokok"));
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseForm<Boolean>> signUp(@RequestBody AccountDTO accountDTO) throws AccountExistedException {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(authService.signUp(accountDTO), 1, "okokok"));
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseForm<Boolean>> logoutSession(@RequestParam String token) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(authService.logoutSession(token), 1, "okokok"));
    }
}
