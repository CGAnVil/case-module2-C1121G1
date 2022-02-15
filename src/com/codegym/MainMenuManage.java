package com.codegym;


import com.codegym.UserController.UserManagement;
import com.codegym.UserMenu.AdminMenu;
import com.codegym.UserMenu.MemberMenu;
import com.codegym.UserMenu.StaffMenu;

import java.util.Scanner;

public class MainMenuManage {

    Scanner scanner = new Scanner(System.in);
    UserManagement userManagement = new UserManagement();
    AdminMenu adminMenu = new AdminMenu();
    MemberMenu memberMenu = new MemberMenu();
    StaffMenu staffMenu = new StaffMenu();
    MainMenuManage mainMenu = new MainMenuManage();

    public void login(UserManagement userManagement) {
        System.out.println("--Nhập thông tin đăng nhập--");
        System.out.println("Nhập username của bạn");
        String userName = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        String role = userManagement.getRoleByName(userName);
        switch (role) {
            case "Admin": {
                adminMenu.run();
                break;
            }
            case "Staff": {
                staffMenu.run();
                break;
            }
            case "Member": {
                memberMenu.run();
            }
        }
    }

    public void run() {
        int choice = 1;
//        do {
        System.out.println("--Chào mừng đến với M2 Tea-- ");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký thành viên");
        System.out.println("3. Tham quan cửa hàng");
        System.out.println("0. Thoát");
        System.out.println("--Mời bạn nhập lựa chọn--");
//            switch (choice) {
//                case 1: {
//                    mainMenu.login(userManagement);
//                    break;
//                }
//                case 2: {
//
//                    break;
//                }
//                case 3: {
//                    break;
//                }
//            }
//        } while (choice != 0);

    }

    public static void main(String[] args) {
        MainMenuManage mainMenuManage = new MainMenuManage();
        mainMenuManage.run();
    }
}
