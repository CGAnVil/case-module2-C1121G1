package com.codegym.ProductMenu;

import com.codegym.ProductController.TeaToolManagement;
import com.codegym.ProductModel.TeaTool;

import java.io.IOException;
import java.util.Scanner;

public class TeaToolMenu {
    public static final Scanner scanner = new Scanner(System.in);

    public void run() {
        TeaToolManagement TeaToolManagement = new TeaToolManagement();
        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    showDisplayAllTeaTool(TeaToolManagement);
                    break;
                }
                case 2: {
                    showAddNewTeaTool(TeaToolManagement);
                    break;
                }
                case 3: {
                    showUpdateTeaTool(TeaToolManagement);
                    break;
                }
                case 4: {
                    showDeleteById(TeaToolManagement);
                    break;
                }
                case 5: {
                    showFindByID(TeaToolManagement);
                    break;
                }
            }
        } while (choice != 0);
    }

    private void showFindByID(TeaToolManagement TeaToolManagement) {
        System.out.println("Nhập mã sản phẩm cần tìm kiếm");
        scanner.nextLine();
        String productID = scanner.nextLine();
        TeaTool findTeaTool = TeaToolManagement.getById(productID);
        if (findTeaTool != null) {
            System.out.println("Sản phẩm cần tìm là");
            System.out.println(findTeaTool.toString());
        } else {
            System.out.println("Không tồn tại sản phẩm cần tìm");
        }
    }

    private void showDeleteById(TeaToolManagement TeaToolManagement) {
        System.out.println("Xóa thông tin sản phẩm trà cụ");
        System.out.println("Nhập mã sản phẩm cần xóa");
        scanner.nextLine();
        String productId = scanner.nextLine();
        boolean isDeleted = TeaToolManagement.deleteById(productId);
        if (isDeleted) {
            try {
                TeaToolManagement.writeFile("teatool.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không thể xóa do mã sản phẩm không tồn tại");
        }
    }

    private void menu() {
        System.out.println("--Quản lý sản phầm trà cụ--");
        System.out.println("1. Hiển thị danh sách trà cụ");
        System.out.println("2. Thêm sản phẩm mới ");
        System.out.println("3. Sửa nội dung sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("0. Quay lại");
        System.out.println("Nhập lựa chọn của bạn");
    }

    public void showDisplayAllTeaTool(TeaToolManagement TeaToolManagement) {

        int size = TeaToolManagement.size();
        if (size == 0) {
            System.out.println("Không có sản phẩm nào trong danh sách");
        } else {
            System.out.println("Danh sách trà cụ");
            TeaToolManagement.displayAll();
        }
    }


    public void showAddNewTeaTool(TeaToolManagement TeaToolManagement) {
        System.out.println("--Nhập thông tin sản phẩm trà cụ--");
        TeaTool TeaTool = TeaToolManagement.inputTeaToolInfo();
        TeaToolManagement.addNew(TeaTool);
        try {
            TeaToolManagement.writeFile("TeaTool.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUpdateTeaTool(TeaToolManagement TeaToolManagement) {
        System.out.println("Nhập mã sản phẩm muốn sửa");
        scanner.nextLine();
        String productID = scanner.nextLine();
        int index = TeaToolManagement.getIndexByID(productID);
        if (index != -1) {
            TeaTool TeaTool = TeaToolManagement.inputTeaToolInfo();
            TeaToolManagement.updateById(productID, TeaTool);
            try {
                TeaToolManagement.writeFile("teatool.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Sửa không thành công do không tồn tại mã sản phẩm");
        }
    }
}
