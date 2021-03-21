package com.example.shopee.repository;

import com.example.shopee.helper.mapper.ProductMapper;
import com.example.shopee.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProduct(String sortColumn, Integer sortType) {
        // 0: ASC, 1: DESC, default ASC
        String sortStatus = sortType != null && sortType == 0
                ? " ASC"
                : " DESC";
//        if (sortType != null) {
//            if (sortType != 0) {
//                sortStatus = " DESC";
//            }
//        }
        String sql = "select * from Product where deleted = 0";
        if (sortColumn != null) {
            sql += " order by " + sortColumn + sortStatus;
        }
        System.out.printf("sql:" + sql);

        return jdbcTemplate.query(sql, new ProductMapper());
    }

    public List<Product> getAllProduct2(Integer limit, Integer offset) {
        String sql = "select * from Product limit ? offset ?";
        return jdbcTemplate.query(sql, new ProductMapper(), new Object[]{limit, offset});
    }

    public Integer countProduct() {
        String sql = "select count(productID) from Product";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
