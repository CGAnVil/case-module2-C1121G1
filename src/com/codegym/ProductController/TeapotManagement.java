package com.codegym.ProductController;

import com.codegym.GenerelController.GeneralManagement;
import com.codegym.ProductModel.Teapot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeapotManagement implements GeneralManagement<Teapot> {
    private List<Teapot> listTeapot = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public TeapotManagement() {
        File file = new File("teapot.txt");
        if (file.exists()) {
            try {
                readFile("teapot.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void displayAll() {
        for (Teapot Teapot : listTeapot) {
            System.out.println(Teapot);
        }
    }

    @Override
    public void addNew(Teapot Teapot) {

        listTeapot.add(Teapot);
    }

    @Override
    public void updateById(String id, Teapot Teapot) {
        int index = getIndexByID(id);
        listTeapot.set(index, Teapot);
    }

    @Override
    public boolean deleteById(String id) {
        int index = getIndexByID(id);
        if (index != -1) {
            listTeapot.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Teapot getById(String id) {
        int index = getIndexByID(id);
        if (index != -1) {
            return listTeapot.get(index);
        }
        return null;


    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.listTeapot);
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.listTeapot = (List<Teapot>) ois.readObject();
    }

    public Teapot inputTeapotInfo() {

        System.out.println("Nhập mã sản phẩm");

        String TeapotId = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String TeapotName = scanner.nextLine();
        System.out.println("Nhập đơn vị tính");
        String TeapotUnit = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = scanner.nextFloat();
        Teapot Teapot = new Teapot(TeapotId, TeapotName, price, TeapotUnit);
        return Teapot;
    }

    public int getIndexByID(String productID) {
        int index = -1;
        for (int i = 0; i < listTeapot.size(); i++) {
            if (listTeapot.get(i).getProductID().equals(productID)) {
                index = i;
            }
        }
        return index;
    }


    public int size() {
        return listTeapot.size();
    }
}
