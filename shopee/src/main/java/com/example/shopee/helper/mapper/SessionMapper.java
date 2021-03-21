package com.example.shopee.helper.mapper;

import com.example.shopee.model.Session;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SessionMapper implements RowMapper {
     @Override
     public Object mapRow(ResultSet resultSet, int i) throws SQLException {
         Session session = new Session();
         session.setUser_id(resultSet.getString("user_id"));
         session.setToken(resultSet.getString("token"));
         return session;
     }
}
