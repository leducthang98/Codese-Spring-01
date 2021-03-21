package com.example.codese_spring.dto;

public class PaginationDTO {
    public Integer totalPage;
    public Integer pageSize;
    public Integer pageLength;

    public PaginationDTO() {
    }

    public PaginationDTO(Integer totalPage, Integer pageSize, Integer pageLength) {
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.pageLength = pageLength;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageLength() {
        return pageLength;
    }

    public void setPageLength(Integer pageLength) {
        this.pageLength = pageLength;
    }
}
