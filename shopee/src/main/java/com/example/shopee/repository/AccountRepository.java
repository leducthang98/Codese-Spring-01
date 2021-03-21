package com.example.shopee.repository;

import com.example.shopee.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Boolean regist(Account account) {
        String sql = "insert into `Account` (accountID,email,display,password,role,avatar,deleted) values (?,?,?,?,?,?,?)";
        int res = jdbcTemplate.update(sql, new Object[]{account.getAccountID(), account.getEmail(), account.getDisplay(), account.getPassword(), account.getRole(), account.getAvatar(), account.getDeleted()});
        if (res == 1) {
            return true;
        } else {
            return false;
        }
    }
    public Integer check(String email , String password){
        String sql = "select accountID from Account where email = ? and password = ? ;" ;
        Integer  ID = jdbcTemplate.update(sql ,new Object[]{email, password});
        return ID;
    }

}
