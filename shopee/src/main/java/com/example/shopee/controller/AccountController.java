package com.example.shopee.controller;


import com.example.shopee.constant.Role;
import com.example.shopee.dto.RegistAccountDto;
import com.example.shopee.helper.encrypt.Encryptor;
import com.example.shopee.model.Account;
import com.example.shopee.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public Account register(@RequestBody(required = true) RegistAccountDto registAccountDto) throws Exception {
        Account account = new Account();

        String hashPassword = Encryptor.bcryptHash(registAccountDto.getPassword());
        UUID id = UUID.randomUUID();

        account.setAccountID(id.toString());
        account.setRole("USER");
        account.setDeleted(0);
        account.setPassword(hashPassword);
        account.setDisplay(registAccountDto.getDisplay());
        account.setEmail(registAccountDto.getEmail());

        Boolean result = accountService.regist(account);
        if (result) {
            return account;
        } else {
            throw new Exception("Fail to regist");
        }

    }


}
