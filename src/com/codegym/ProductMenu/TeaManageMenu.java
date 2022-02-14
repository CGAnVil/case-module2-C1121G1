package com.codegym.ProductMenu;

import com.codegym.ProductController.TeaManagement;
import com.codegym.ProductModel.Tea;

import java.io.IOException;
import java.util.Scanner;

public class TeaManageMenu {
    public static final Scanner scanner = new Scanner(System.in);

    public void run() {
        TeaManagement teaManagement = new TeaManagement();
        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    showDisplayAllTea(teaManagement);
                    break;
                }
                case 2: {
                    showAddNewTea(teaManagement);
                    break;
                }
                case 3: {
                    showUpdateTea(teaManagement);
                    break;
                }
                case 4: {
                    showDeleteById(teaManagement);
                    break;
                }
                case 5: {
                    showFindByID(teaManagement);
                    break;
                }
            }
        } while (choice != 0);
    }

    private void showFindByID(TeaManagement teaManagement) {
        System.out.println("Nhập mã sản phẩm cần tìm kiếm");
        scanner.nextLine();
        String productID = scanner.nextLine();
        Tea findTea = teaManagement.getById(productID);
        if (findTea != null) {
            System.out.println("Sản phẩm cần tìm là");
            System.out.println(findTea.toString());
        } else {
            System.out.println("Không tồn tại sản phẩm cần tìm");
        }
    }

    private void showDeleteById(TeaManagement teaManagement) {
        System.out.println("Xóa thông tin sản phẩm trà");
        System.out.println("Nhập mã sản phẩm cần xóa");
        scanner.nextLine();
        String productId = scanner.nextLine();
        boolean isDeleted = teaManagement.deleteById(productId);
        if (isDeleted) {
            try {
                teaManagement.writeFile("tea.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Xóa thành công");

        } else {
            System.out.println("Không thể xóa do mã sản phẩm không tồn tại");
        }
    }

    private void menu() {
        System.out.println("--Quản lý sản phầm trà");
        System.out.println("1. Hiển thị danh sách trà");
        System.out.println("2. Thêm sản phẩm mới ");
        System.out.println("3. Sửa nội dung sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("0. Quay lại");
        System.out.println("Nhập lựa chọn của bạn");
    }

    public void showDisplayAllTea(TeaManagement teaManagement) {

        int size = teaManagement.size();
        if (size == 0) {
            System.out.println("Không có sản phẩm nào trong danh sách");
        } else {
            System.out.println("Danh sách trà");
            teaManagement.displayAll();
        }
    }


    public void showAddNewTea(TeaManagement teaManagement) {
        System.out.println("--Nhập thông tin sản phẩm trà--");
        Tea tea = teaManagement.inputTeaInfo();
        teaManagement.addNew(tea);
        try {
            teaManagement.writeFile("tea.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUpdateTea(TeaManagement teaManagement) {
        System.out.println("Nhập mã sản phẩm muốn sửa");
        scanner.nextLine();
        String productID = scanner.nextLine();
        int index = teaManagement.getIndexByID(productID);
        if (index != -1) {
            Tea tea = teaManagement.inputTeaInfo();
            teaManagement.updateById(productID, tea);
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Sửa không thành công do không tồn tại mã sản phẩm");
        }
    }

    public static void main(String[] args) {
        TeaManageMenu teaManageMenu = new TeaManageMenu();
        teaManageMenu.run();

    }
}
