package com.codegym.ProductMenu;

import java.util.Scanner;

public class ProductManageMenu {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        TeapotMenu teapotMenu = new TeapotMenu();
        TeaManageMenu teaMenu = new TeaManageMenu();
        TeaToolMenu teaToolMenu = new TeaToolMenu();
        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    teaMenu.run();
                    break;
                }
                case 2: {
                    teapotMenu.run();
                    break;
                }
                case 3: {
                    teaToolMenu.run();
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void menu() {
        System.out.println("--Danh mục quản lý sản phẩm--");
        System.out.println("1. Quản lý sản phẩm trà ");
        System.out.println("2. Quản lý sản phẩm ấm trà");
        System.out.println("3. Quản lý sản phẩm trà cụ");
        System.out.println("0. Quay lại");
        System.out.println("Nhập lựa chọn của bạn");
    }

    public static void main(String[] args) {
        ProductManageMenu productManageMenu = new ProductManageMenu();
        productManageMenu.run();
    }
}
