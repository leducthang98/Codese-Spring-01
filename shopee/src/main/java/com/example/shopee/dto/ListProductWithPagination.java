package com.example.shopee.dto;

import com.example.shopee.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListProductWithPagination {
    List<Product> products; // data
    Pagination pagination; // pagination
}
