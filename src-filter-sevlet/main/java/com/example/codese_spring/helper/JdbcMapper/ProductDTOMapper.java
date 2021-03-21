package com.example.codese_spring.helper.JdbcMapper;

import com.example.codese_spring.dto.ProductDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDTOMapper implements RowMapper {
    @Override
    public ProductDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductID(resultSet.getString("productID"));
        productDTO.setDisplay(resultSet.getString("display"));
        productDTO.setAmount(resultSet.getInt("amount"));
        productDTO.setPriceIn(resultSet.getInt("priceIn"));
        productDTO.setPriceOut(resultSet.getInt("priceOut"));
        productDTO.setDescription(resultSet.getString("description"));
        productDTO.setShipday(resultSet.getInt("shipday"));
        productDTO.setImages(resultSet.getString("images"));
        productDTO.setPriceSale(resultSet.getInt("priceSale"));
        return productDTO;
    }
}
