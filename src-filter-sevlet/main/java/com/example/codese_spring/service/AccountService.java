package com.example.codese_spring.service;

import com.example.codese_spring.dto.AccountDTO;
import com.example.codese_spring.exception.AccountExistedException;
import com.example.codese_spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Boolean addAccount(AccountDTO accountDTO) throws AccountExistedException {
        if (accountRepository.getAccountByName(accountDTO.getDisplay()) == null) {
            if (accountRepository.addAccount(accountDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new AccountExistedException("Account existed");
        }
    }
}
