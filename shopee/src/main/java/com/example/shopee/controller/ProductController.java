package com.example.shopee.controller;

import com.example.shopee.dto.ListProductWithPagination;
import com.example.shopee.model.Product;
import com.example.shopee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProduct(@RequestParam(required = false) String sortColumn, @RequestParam(required = false) Integer sortType) {

        return productService.getAllProduct(sortColumn, sortType);

    }

    @GetMapping("/all-with-paging")
    public ListProductWithPagination getAllProduct2(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page) {
        if (size == null) {
            size = 10;
        }
        if (page == null) {
            page = 1;
        }
        return productService.getAllProduct2(page, size);
    }


}
