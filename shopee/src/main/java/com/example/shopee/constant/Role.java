package com.example.shopee.constant;

public enum Role {

    ADMIN("ADMIN"), USER("USER");

    String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
