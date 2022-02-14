package com.codegym.UserMenu;

import com.codegym.UserController.UserManagement;
import com.codegym.UserModel.User;

import java.util.Scanner;

public class AdminMenu {
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
                    showUpdateMeber(userManagement);
                    break;
                }

                case 5: {
                    showDeleteByName(userManagement);
                    break;
                }


            }
        } while (choice != 0);
    }

    private void showUpdateMeber(UserManagement userManagement) {
        System.out.println("--Sửa thông tin thành viên--");
        System.out.println("Nhập tên thành viên cần sửa");
        String userName = scanner.nextLine();
        if (userManagement.checkExistByName(userName)) {
            User changeUser = userManagement.addNewUserByAdmin();
            userManagement.updateById(userName, changeUser);
            System.out.println("Sửa thông tin thành công");
        } else {
            System.out.println("Tên thành viên không tồn tại");
        }
    }

    private void showDeleteByName(UserManagement userManagement) {

        System.out.println("Nhập tên người dùng cần xóa");
        String userName = scanner.nextLine();
        if (userManagement.deleteById(userName)) {
            System.out.println("Xóa thành công");
        }
        System.out.println("Không tồn tại tên người dùng");
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
        AdminMenu userManageMenu = new AdminMenu();
        userManageMenu.run();
    }

    public void showAddNewUserByAdmin(UserManagement userManagement) {
        userManagement.addNew(userManagement.addNewUserByAdmin());
    }


}
