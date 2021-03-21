package com.example.codese_spring.repository;

import com.example.codese_spring.dto.AccountDTO;
import com.example.codese_spring.dto.LoginSessionDTO;
import com.example.codese_spring.helper.JdbcMapper.AccountDTOMapper;
import com.example.codese_spring.helper.JdbcMapper.LoginSessionDTOMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<AccountDTO> loginCheck(String email, String password) {
        String sql = "select * from Account where email = ? and password = ?;";
        return jdbcTemplate.query(sql, new AccountDTOMapper(), email, password);
    }

    public Integer addToken(String accountID, String key) {
        String sql = "insert into Session (accountID, token) values (?,?);";
        Object[] params = {accountID, key};
        return jdbcTemplate.update(sql, params);
    }

    public LoginSessionDTO getAccountID(String key) {
        String sql = "select * from Session where token = ?;";
        return (LoginSessionDTO) jdbcTemplate.queryForObject(sql, new LoginSessionDTOMapper(), key);
    }

    public Integer changeSessionStatus(String token) {
        String sql = "update Session set isActive = 0 where token = ?;";
        return jdbcTemplate.update(sql, token);
    }

}
