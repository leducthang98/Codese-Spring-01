package com.example.shopee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    String accountID;
    String email; //
    String display; //
    String password; //
    String role;
    String avatar;
    int deleted;
    String create_at;
    String delete_at;
}

// account.setRole(Role.USER.getValue());