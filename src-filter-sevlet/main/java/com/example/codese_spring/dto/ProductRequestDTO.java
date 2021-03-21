package com.example.codese_spring.dto;

public class ProductRequestDTO {
    private String productID;
    private int amount;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String productID, int amount) {
        this.productID = productID;
        this.amount = amount;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
