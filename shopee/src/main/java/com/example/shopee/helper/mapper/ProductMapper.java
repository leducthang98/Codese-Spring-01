package com.example.shopee.helper.mapper;

import com.example.shopee.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductID(resultSet.getString("productID"));
        product.setDisplay(resultSet.getString("display"));
        product.setPriceIn(resultSet.getLong("priceIn"));
        product.setPriceOut(resultSet.getLong("priceOut"));
        product.setPriceSale(resultSet.getLong("priceSale"));
        product.setAmount(resultSet.getLong("amount"));
        product.setShipday(resultSet.getInt("shipday"));
        product.setDescription(resultSet.getString("description"));
        product.setImages(resultSet.getString("images"));
        product.setDeleted(resultSet.getInt("deleted"));
        product.setCreated_at(resultSet.getString("create_at"));
        product.setUpdated_at(resultSet.getString("update_at"));
        return product;
    }
}
