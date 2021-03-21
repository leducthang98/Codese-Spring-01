package com.example.codese_spring.controller;

import com.example.codese_spring.dto.AccountDTO;
import com.example.codese_spring.helper.ResponseBuilder.ResponseForm;
import com.example.codese_spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addAccount(@RequestBody AccountDTO accountDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(accountService.addAccount(accountDTO), 1, "okokok"));
    }
}
