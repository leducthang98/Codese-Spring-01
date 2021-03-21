package com.example.codese_spring.dto;

import com.example.codese_spring.entity.Product;

public class ProductHomepageDTO {
    private String productID;
    private String display;
    private int priceSale;
    private String images;

    public ProductHomepageDTO() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(int priceSale) {
        this.priceSale = priceSale;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ProductHomepageDTO{" +
                "productID='" + productID + '\'' +
                ", display='" + display + '\'' +
                ", priceSale=" + priceSale +
                ", images='" + images + '\'' +
                '}';
    }
}
