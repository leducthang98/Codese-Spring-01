package com.example.shopee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session implements Serializable {
    String user_id;
    String token;
    Account account;
}
