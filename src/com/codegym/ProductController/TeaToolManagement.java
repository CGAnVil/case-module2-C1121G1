package com.codegym.ProductController;

import com.codegym.GenerelController.GeneralManagement;
import com.codegym.ProductModel.TeaTool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeaToolManagement implements GeneralManagement<TeaTool> {
    Scanner scanner = new Scanner(System.in);
    List<TeaTool> listTeaTool = new ArrayList<>();

    public TeaToolManagement() {
        File file = new File("teatool.txt");
        if (file.exists()) {
            try {
                readFile("teatool.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void displayAll() {
        for (TeaTool TeaTool : listTeaTool) {
            System.out.println(TeaTool);
        }
    }

    @Override
    public void addNew(TeaTool TeaTool) {

        listTeaTool.add(TeaTool);
    }

    @Override
    public void updateById(String id, TeaTool TeaTool) {
        int index = getIndexByID(id);
        listTeaTool.set(index, TeaTool);
    }

    @Override
    public boolean deleteById(String id) {
        int index = getIndexByID(id);
        if (index != -1) {
            listTeaTool.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public TeaTool getById(String id) {
        int index = getIndexByID(id);
        if (index != -1) {
            return listTeaTool.get(index);
        }
        return null;


    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.listTeaTool);
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.listTeaTool = (List<TeaTool>) ois.readObject();
    }

    public TeaTool inputTeaToolInfo() {

        System.out.println("Nhập mã sản phẩm");

        String TeaToolId = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String TeaToolName = scanner.nextLine();
        System.out.println("Nhập đơn vị tính");
        String TeaToolUnit = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = scanner.nextFloat();
        TeaTool TeaTool = new TeaTool(TeaToolId, TeaToolName, price, TeaToolUnit);
        return TeaTool;
    }

    public int getIndexByID(String productID) {
        int index = -1;
        for (int i = 0; i < listTeaTool.size(); i++) {
            if (listTeaTool.get(i).getProductID().equals(productID)) {
                index = i;
            }
        }
        return index;
    }


    public int size() {
        return listTeaTool.size();
    }
}
