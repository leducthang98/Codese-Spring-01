package com.example.codese_spring.entity;

public class Receipt {
    private String receiptID;
    private String accountID;
    private String status;
    private String create_at;
    private String update_at;

    private enum deleted {DELETED, EXISTED}

    ;
    private int totalMoney;

    public Receipt() {
    }

    public Receipt(String receiptID, String accountID, String status, String create_at, String update_at, int totalMoney) {
        this.receiptID = receiptID;
        this.accountID = accountID;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
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

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
