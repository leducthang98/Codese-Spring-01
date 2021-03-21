package com.example.codese_spring.dto;

public class LoginSessionDTO {
    private String key;
    private String accountID;

    public LoginSessionDTO() {
    }

    public LoginSessionDTO(String key, String accountID) {
        this.key = key;
        this.accountID = accountID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
