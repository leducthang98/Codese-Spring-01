package com.example.codese_spring.helper.JdbcMapper;

import com.example.codese_spring.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductHomepageDTOMapper implements RowMapper {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductID(resultSet.getString("productID"));
        product.setDisplay(resultSet.getString("display"));
        product.setPriceSale(resultSet.getInt("priceSale"));
        product.setImages(resultSet.getString("images"));
        return product;
    }
}
