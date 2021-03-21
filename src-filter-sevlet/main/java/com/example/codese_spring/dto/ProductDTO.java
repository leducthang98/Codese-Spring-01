package com.example.codese_spring.dto;

public class ProductDTO {
    private String productID;
    private String display;
    private int priceIn;
    private int priceOut;
    private int priceSale;
    private int amount;
    private int shipday;
    private String description;
    private String images;

    public ProductDTO() {

    }

    public ProductDTO(String productID, String display, int priceIn, int priceOut, int priceSale, int amount, int shipday, String description, String images) {
        this.productID = productID;
        this.display = display;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.priceSale = priceSale;
        this.amount = amount;
        this.shipday = shipday;
        this.description = description;
        this.images = images;
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

    public int getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(int priceIn) {
        this.priceIn = priceIn;
    }

    public int getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(int priceOut) {
        this.priceOut = priceOut;
    }

    public int getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(int priceSale) {
        this.priceSale = priceSale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShipday() {
        return shipday;
    }

    public void setShipday(int shipday) {
        this.shipday = shipday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productID='" + productID + '\'' +
                ", display='" + display + '\'' +
                ", priceIn=" + priceIn +
                ", priceOut=" + priceOut +
                ", priceSale=" + priceSale +
                ", amount=" + amount +
                ", shipday=" + shipday +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
