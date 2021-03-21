package com.example.codese_spring.dto;

import java.util.List;

public class ReceiptRequestDTO {
    private List<ProductRequestDTO> receiptRequestDTO;

    public ReceiptRequestDTO() {
    }

    public ReceiptRequestDTO(List<ProductRequestDTO> receiptRequestDTO) {
        this.receiptRequestDTO = receiptRequestDTO;
    }

    public List<ProductRequestDTO> getReceiptRequestDTO() {
        return receiptRequestDTO;
    }

    public void setReceiptRequestDTO(List<ProductRequestDTO> receiptRequestDTO) {
        this.receiptRequestDTO = receiptRequestDTO;
    }
}
