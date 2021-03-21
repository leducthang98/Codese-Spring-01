package com.example.shopee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
    int totalPage;
    int pageSize;
    int pageLength;
}
