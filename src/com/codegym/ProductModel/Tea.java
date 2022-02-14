package com.codegym.ProductModel;

import java.io.Serializable;

public class Tea extends Product implements Serializable {
    public Tea(String productID, String productName, String productType, double price, String unit) {
        super(productID, productName, productType, price, unit);
    }

    public Tea(String productID, String productName, double price, String unit) {
        super(productID, productName, price, unit);
        super.setProductType("Trà");
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
