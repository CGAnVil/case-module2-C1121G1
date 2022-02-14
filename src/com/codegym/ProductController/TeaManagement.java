package com.codegym.ProductController;

import com.codegym.GenerelController.GeneralManagement;
import com.codegym.ProductModel.Tea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeaManagement implements GeneralManagement<Tea> {
    private List<Tea> listTea = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public TeaManagement() {
        File file = new File("tea.txt");
        if (file.exists()) {
            try {
                readFile("tea.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void displayAll() {
        for (Tea tea : listTea) {
            System.out.println(tea);
        }
    }

    @Override
    public void addNew(Tea tea) {

        listTea.add(tea);
    }

    @Override
    public void updateById(String id, Tea tea) {
        int index = getIndexByID(id);
        listTea.set(index, tea);
    }

    @Override
    public boolean deleteById(String id) {
        int index = getIndexByID(id);
        if (index != -1) {
            listTea.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Tea getById(String id) {
        int index = getIndexByID(id);
        if (index != -1) {
            return listTea.get(index);
        }
        return null;


    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.listTea);
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.listTea = (List<Tea>) ois.readObject();
    }

    public Tea inputTeaInfo() {

        System.out.println("Nhập mã sản phẩm");
        String teaId = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String teaName = scanner.nextLine();
        System.out.println("Nhập đơn vị tính");
        String teaUnit = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = scanner.nextFloat();
        Tea tea = new Tea(teaId, teaName, price, teaUnit);
        return tea;
    }

    public int getIndexByID(String productID) {
        int index = -1;
        for (int i = 0; i < listTea.size(); i++) {
            if (listTea.get(i).getProductID().equals(productID)) {
                index = i;
            }
        }
        return index;
    }


    public int size() {
        return listTea.size();
    }

}
