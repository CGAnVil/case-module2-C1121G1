package com.codegym.UserMenu;

import com.codegym.UserController.UserManagement;

import java.util.Scanner;

public class UserManageMenu {
    Scanner scanner = new Scanner(System.in);
    UserManagement userManagement = new UserManagement();

    public void run() {
        int choice = -1;

        do {
            choice = menu();
            switch (choice) {
                case 1: {
                    showDisplayAll(userManagement);
                    break;
                }
                case 2: {
                    int size = userManagement.size();
                    if (size == 0) {
                        System.out.println("Không có người dùng mới đăng ký");
                    } else {
                        userManagement.displayAllRegister();
                        int choiceRegister = -1;
                    }
                }
                case 3: {
                    showAddNewUserByAdmin(userManagement);
                    break;
                }
                case 4: {
                    System.out.println("Nhập ");
                }

            }
        } while (choice != 0);
    }


    private void showDisplayAll(UserManagement userManagement) {
        int size = userManagement.size();
        if (size == 0) {
            System.out.println("Không có thành viên trong danh sách");
        } else {
            userManagement.displayAll();
        }
    }

    private void showDisplayAllRegister(UserManagement userManagement) {

    }

    private int menu() {
        int choice;
        System.out.println("--Menu quản lý người dùng--");
        System.out.println("1. Xem toàn bộ danh sách thành viên");
        System.out.println("2. Xem đăng ký mới ");
        System.out.println("3. Thêm người dùng mới");
        System.out.println("4. Sửa thông tin người dùng");
        System.out.println("5. Xóa người dùng");
        System.out.println("0. Quay lại");
        System.out.println("Nhập lựa chọn của bạn");
        choice = scanner.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        UserManageMenu userManageMenu = new UserManageMenu();
        userManageMenu.run();
    }

    public void showAddNewUserByAdmin(UserManagement userManagement) {
        userManagement.addNew(userManagement.addNewUserByAdmin());
    }
}
