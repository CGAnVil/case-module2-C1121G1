package com.codegym.ProductModel;

public class TeaTool extends Product{
    public TeaTool(String productID, String productName, double price, String unit) {
        super(productID, productName, price, unit);
        super.setProductType("Trà cụ");
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
