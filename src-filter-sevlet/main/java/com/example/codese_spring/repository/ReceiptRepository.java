package com.example.codese_spring.repository;

import com.example.codese_spring.dto.ProductRequestDTO;
import com.example.codese_spring.dto.ReceiptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ReceiptRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    public Integer addReceipt(String receiptID, String accountID, String status, Integer totalMoney) {
        String sql = "insert into Receipt (receiptID, accountID, status, totalMoney) values (?,?,?,?);";
        Object[] params = {receiptID, accountID, status, totalMoney};
        return jdbcTemplate.update(sql, params);
    }

    public Integer addReceiptDetail(String receiptID, String productID, Integer amount) {
        String sql = "insert into ReceiptDetail (receiptID, productID, amount) values (?,?,?);";
        Object[] params = {receiptID, productID, amount};
        return jdbcTemplate.update(sql, params);
    }

}
