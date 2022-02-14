package com.codegym.ProductModel;

import java.io.Serializable;

abstract class Product implements Serializable {
    private String productID;
    private String productName;
    private String productType;
    private double price;
    private String unit;

    public Product(String productID, String productName, String productType, double price, String unit) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.unit = unit;
    }

    public Product(String productID, String productName, double price, String unit) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.unit = unit;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", unit='" + unit + '\'' +
                ", productType='" + productType + '\'' +
                ", price=" + price +
                '}';
    }
}
