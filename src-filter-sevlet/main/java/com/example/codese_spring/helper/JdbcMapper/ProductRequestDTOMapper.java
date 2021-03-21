package com.example.codese_spring.helper.JdbcMapper;

import com.example.codese_spring.dto.ProductRequestDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRequestDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setAmount(resultSet.getInt("amount"));
        productRequestDTO.setProductID(resultSet.getString("productID"));
        return productRequestDTO;
    }
}
