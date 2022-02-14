package com.codegym.ProductMenu;

import com.codegym.ProductController.TeapotManagement;
import com.codegym.ProductModel.Teapot;

import java.io.IOException;
import java.util.Scanner;

public class TeapotMenu {


    public static final Scanner scanner = new Scanner(System.in);

    public void run() {
        TeapotManagement TeapotManagement = new TeapotManagement();
        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    showDisplayAllTeapot(TeapotManagement);
                    break;
                }
                case 2: {
                    showAddNewTeapot(TeapotManagement);
                    break;
                }
                case 3: {
                    showUpdateTeapot(TeapotManagement);
                    break;
                }
                case 4: {
                    showDeleteById(TeapotManagement);
                    break;
                }
                case 5: {
                    showFindByID(TeapotManagement);
                    break;
                }
            }
        } while (choice != 0);
    }

    private void showFindByID(TeapotManagement TeapotManagement) {
        System.out.println("Nhập mã sản phẩm cần tìm kiếm");
        scanner.nextLine();
        String productID = scanner.nextLine();
        Teapot findTeapot = TeapotManagement.getById(productID);
        if (findTeapot != null) {
            System.out.println("Sản phẩm cần tìm là");
            System.out.println(findTeapot.toString());
        } else {
            System.out.println("Không tồn tại sản phẩm cần tìm");
        }
    }

    private void showDeleteById(TeapotManagement TeapotManagement) {
        System.out.println("Xóa thông tin sản phẩm ấm trà");
        System.out.println("Nhập mã sản phẩm cần xóa");
        scanner.nextLine();
        String productId = scanner.nextLine();
        boolean isDeleted = TeapotManagement.deleteById(productId);
        if (isDeleted) {
            try {
                TeapotManagement.writeFile("teapot.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không thể xóa do mã sản phẩm không tồn tại");
        }
    }

    private void menu() {
        System.out.println("--Quản lý sản phầm ấm trà--");
        System.out.println("1. Hiển thị danh sách ấm trà");
        System.out.println("2. Thêm sản phẩm mới ");
        System.out.println("3. Sửa nội dung sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("0. Quay lại");
        System.out.println("Nhập lựa chọn của bạn");
    }

    public void showDisplayAllTeapot(TeapotManagement TeapotManagement) {

        int size = TeapotManagement.size();
        if (size == 0) {
            System.out.println("Không có sản phẩm nào trong danh sách");
        } else {
            System.out.println("Danh sách ấm trà");
            TeapotManagement.displayAll();
        }
    }


    public void showAddNewTeapot(TeapotManagement TeapotManagement) {
        System.out.println("--Nhập thông tin sản phẩm ấm trà--");
        Teapot Teapot = TeapotManagement.inputTeapotInfo();
        TeapotManagement.addNew(Teapot);
        try {
            TeapotManagement.writeFile("Teapot.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUpdateTeapot(TeapotManagement TeapotManagement) {
        System.out.println("Nhập mã sản phẩm muốn sửa");
        scanner.nextLine();
        String productID = scanner.nextLine();
        int index = TeapotManagement.getIndexByID(productID);
        if (index != -1) {
            Teapot Teapot = TeapotManagement.inputTeapotInfo();
            TeapotManagement.updateById(productID, Teapot);
            try {
                TeapotManagement.writeFile("teapot.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Sửa không thành công do không tồn tại mã sản phẩm");
        }
    }

    
}


