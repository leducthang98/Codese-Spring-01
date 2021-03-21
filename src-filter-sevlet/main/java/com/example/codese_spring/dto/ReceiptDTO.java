package com.example.codese_spring.dto;

public class ReceiptDTO {
    private String receiptID;
    private String accountID;
    private String status;
    private int totalMoney;

    public ReceiptDTO() {
    }

    public ReceiptDTO(String receiptID, String accountID, String status, int totalMoney) {
        this.receiptID = receiptID;
        this.accountID = accountID;
        this.status = status;
        this.totalMoney = totalMoney;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
