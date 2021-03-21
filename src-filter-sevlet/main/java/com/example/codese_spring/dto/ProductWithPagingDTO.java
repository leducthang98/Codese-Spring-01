package com.example.codese_spring.dto;

import java.util.List;

public class ProductWithPagingDTO {
    List<ProductDTO> listProduct;
    PaginationDTO paginationDTO;
    String accountID;

    public ProductWithPagingDTO() {
    }

    public ProductWithPagingDTO(List<ProductDTO> listProduct, PaginationDTO paginationDTO, String accountID) {
        this.listProduct = listProduct;
        this.paginationDTO = paginationDTO;
        this.accountID = accountID;
    }

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    public PaginationDTO getPaginationDTO() {
        return paginationDTO;
    }

    public void setPaginationDTO(PaginationDTO paginationDTO) {
        this.paginationDTO = paginationDTO;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
