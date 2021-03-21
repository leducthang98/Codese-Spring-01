package com.example.codese_spring.entity;

public class Account {
    private String accountID;
    private String email;
    private String display;
    private String password;
    private enum role {STAFF, ADMIN, USER};
    private String avatar;
    private enum deleted {EXISTED, DELETED};
    private String create_at;
    private String update_at;

    public Account() {
    }

    public Account(String accountID, String email, String display, String password, String avatar, String create_at, String update_at) {
        this.accountID = accountID;
        this.email = email;
        this.display = display;
        this.password = password;
        this.avatar = avatar;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
}
