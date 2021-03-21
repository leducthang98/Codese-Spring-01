package com.example.shopee.service;

import com.example.shopee.model.Account;
import com.example.shopee.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Boolean regist(Account account) {
        return accountRepository.regist(account);
    }


}
