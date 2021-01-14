package com.example.shopee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    String productID;
    String display;
    long priceIn;
    long priceOut;
    long priceSale;
    long amount;
    int shipday;
    String description;
    String images;
    int deleted;
    String created_at;
    String updated_at;
}
