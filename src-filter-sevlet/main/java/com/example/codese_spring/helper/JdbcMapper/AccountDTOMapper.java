package com.example.codese_spring.helper.JdbcMapper;

import com.example.codese_spring.dto.AccountDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDTOMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountID(resultSet.getString("accountID"));
        accountDTO.setEmail(resultSet.getString("email"));
        accountDTO.setDisplay(resultSet.getString("display"));
        accountDTO.setPassword(resultSet.getString("password"));
        accountDTO.setRole(resultSet.getString("role"));
        accountDTO.setAvatar(resultSet.getString("avatar"));
        return accountDTO;
    }
}
