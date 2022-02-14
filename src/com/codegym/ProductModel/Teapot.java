package com.codegym.ProductModel;

public class Teapot extends Product{

    public Teapot(String productID, String productName, double price, String unit) {
        super(productID, productName, price, unit);
        super.setProductType("Ấm trà");
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
