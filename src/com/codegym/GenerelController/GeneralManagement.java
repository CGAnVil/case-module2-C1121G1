package com.codegym.GenerelController;

import com.codegym.ProductModel.Tea;

import java.io.IOException;

public interface GeneralManagement<T> {


    void displayAll();

    void addNew(T t);


    void updateById(String id, T t);

    boolean deleteById(String id);

    T getById(String id);

    void writeFile(String path) throws IOException;

    void readFile(String path) throws IOException, ClassNotFoundException;


}

