package com.codegym;

import com.codegym.ProductController.TeaManagement;
import com.codegym.ProductMenu.TeaManageMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeaManagement teaManagement = new TeaManagement();
        TeaManageMenu teaManageMenu = new TeaManageMenu();
        int choice = 1;
        do {
            System.out.println("--Chào mừng đến với M2 Tea-- ");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký thành viên");
            System.out.println("3. Tham quan cửa hàng");
            System.out.println("0. Thoát");
            System.out.println("--Mời bạn nhập lựa chọn--");
            switch (choice) {
                case 1: {
                    System.out.println("--Nhập thông tin đăng nhập--");
                    System.out.println("Nhập username của bạn");
                    String userName = scanner.nextLine();
                    System.out.println("Nhập mật khẩu");
                    String password = scanner.nextLine();
                }
            }
        } while (choice != 0);

    }
}
