package com.example.codese_spring.service;

import com.example.codese_spring.constant.Constant;
import com.example.codese_spring.dto.ProductRequestDTO;
import com.example.codese_spring.dto.ReceiptRequestDTO;
import com.example.codese_spring.helper.Jwt.Jwt;
import com.example.codese_spring.repository.AccountRepository;
import com.example.codese_spring.repository.ProductRepository;
import com.example.codese_spring.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductRepository productRepository;

    public Boolean addReceipt(ReceiptRequestDTO receiptRequestDTO, String token) {
        String accountID = Jwt.verifyToken(token, Constant.SECRET_KEY);// lấy accountID
        String uuid = UUID.randomUUID().toString(); // tạo ID
        Integer totalMoney = 0;
        List<ProductRequestDTO> productRequestDTOList = receiptRequestDTO.getReceiptRequestDTO();
        for (ProductRequestDTO productRequestDTO : productRequestDTOList) {
            totalMoney = totalMoney + productRepository.getProductById(accountID).getPriceOut() * productRequestDTO.getAmount(); // gọi về product repo được không?
        } // tính tổng tiền
        String status = "chưa thanh toán"; // tạo status

        for (ProductRequestDTO productRequestDTO : productRequestDTOList) {
            if (productRepository.checkAmountOfProduct(productRequestDTO.getProductID(), productRequestDTO.getAmount())) {
                if (receiptRepository.addReceiptDetail(uuid, productRequestDTO.getProductID(), productRequestDTO.getAmount()) == 0) {
                    return false;
                }
            }
        }
        if (receiptRepository.addReceipt(uuid, accountID, status, totalMoney) == 0) {
            return false;
        }
        return true;
    }
}
