package com.example.shopee.service;

import com.example.shopee.model.Product;
import com.example.shopee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(String sortColumn, Integer sortType) {
        return productRepository.getAllProduct(sortColumn, sortType);
    }

}
