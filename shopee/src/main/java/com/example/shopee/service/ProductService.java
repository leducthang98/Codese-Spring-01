package com.example.shopee.service;

import com.example.shopee.dto.ListProductWithPagination;
import com.example.shopee.dto.Pagination;
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

    public ListProductWithPagination getAllProduct2(Integer page, Integer size) {

        Integer limit = size;
        Integer offset = (page - 1) * size; // size = 9, page 2

        // get
        List<Product> data = productRepository.getAllProduct2(limit, offset);

        // count
        Integer totalItem = productRepository.countProduct();
        Integer totalPage;

        if (totalItem % size == 0) {
            totalPage = totalItem / size;
        } else {
            totalPage = totalItem / size + 1;
        }

        Pagination pagination = new Pagination(totalPage, data.size(), size);
        return new ListProductWithPagination(data, pagination);

    }

}
