package com.example.codese_spring.helper.JdbcMapper;

import com.example.codese_spring.dto.LoginSessionDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSessionDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LoginSessionDTO loginSessionDTO = new LoginSessionDTO();
        loginSessionDTO.setKey(resultSet.getString("token"));
        loginSessionDTO.setAccountID(resultSet.getString("accountID"));
        return loginSessionDTO;

    }
}
