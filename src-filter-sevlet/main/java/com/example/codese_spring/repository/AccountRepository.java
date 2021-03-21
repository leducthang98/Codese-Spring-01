package com.example.codese_spring.repository;

import com.example.codese_spring.dto.AccountDTO;
import com.example.codese_spring.helper.JdbcMapper.AccountDTOMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AccountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<AccountDTO> getAccountById(String id) {
        String sql = "select * from Account where id = ?;";
        return jdbcTemplate.query(sql, new AccountDTOMapper(), id);
    }

    public List<AccountDTO> getAccountInfoByEmail(String email) {
        String sql = "select * from Account where email = ?";
        return jdbcTemplate.query(sql, new AccountDTOMapper(), email);
    }

    public List<AccountDTO> getAccountByName(String display) {
        String sql = "select * from Account where display = ?;";
        Object[] params = {display};
        return jdbcTemplate.query(sql, new AccountDTOMapper(), params);
    }

    public Integer addAccount(AccountDTO accountDTO) {
        String sql = "insert into Account (accountID, email, display, password, role, avatar) values (?,?,?,?,?,?);";
        String uuid = UUID.randomUUID().toString();
        String hashPassword = BCrypt.hashpw(accountDTO.getPassword(), BCrypt.gensalt(10));
        Object[] params = {uuid, accountDTO.getEmail(), accountDTO.getDisplay(), hashPassword, "USER", accountDTO.getAvatar()};
        return jdbcTemplate.update(sql, params);
    }

}
