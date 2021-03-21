package com.example.codese_spring.dto;

public class SignInDTO {
    private String email;
    private String password;

    public SignInDTO() {
    }

    public SignInDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
