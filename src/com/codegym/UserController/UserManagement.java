package com.codegym.UserController;

import com.codegym.GenerelController.GeneralManagement;
import com.codegym.UserModel.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement implements GeneralManagement<User> {
    Scanner scanner = new Scanner(System.in);
    List<User> listUser = new ArrayList<>();

    @Override
    public void displayAll() {
        for (User user : listUser
        ) {
            System.out.println(user);

        }
    }

    @Override
    public void addNew(User user) {
        listUser.add(user);

    }

    @Override
    public void updateById(String id, User user) {

    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.listUser);
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.listUser = (List<User>) ois.readObject();
    }

    public int size() {
        return listUser.size();
    }

    public boolean checkExistByName(String checkUserName) {
        boolean checkExist = false;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUserName().equals(checkUserName)) {
                checkExist = true;
                break;
            }
        }
        return checkExist;
    }

    public boolean checkExistByID(String userID) {
        boolean checkExist = false;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUserName().equals(userID)) {
                checkExist = true;
                break;
            }
        }
        return checkExist;
    }

    public User inputRegisterInfo() {
        User newUser = new User();
        System.out.println("Nhập tên đăng nhập của bạn");
        String userName = scanner.nextLine();
        if (checkExistByName(userName)) {
            System.out.println("Tên đăng nhập đã tồn tại");
        } else {
            System.out.println("Nhập mật khẩu");
            String password = scanner.nextLine();
            newUser = new User(userName, password);
        }
        return newUser;
    }

    public void registerUser() {
        User registerUser = inputRegisterInfo();
        addNew(registerUser);
    }

    public boolean checkValidRole(String role) {

        if (role == "Admin" || role == "Member" || role == "Staff") {
            return true;
        }
        return false;
    }

    public User addNewUserByAdmin() {
        User newUser = new User();
        System.out.println("Nhập ID người dùng mới");
        String userID = scanner.nextLine();
        System.out.println("Nhập tên đăng nhập");
        String userName = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        System.out.println("Nhập vai trò người dùng");
        System.out.println("Nhập 1 trong 3 role sau đây: Admin, Member, Staff");
        String role = scanner.nextLine();
        if (checkExistByName(userName) || checkExistByID(userID)) {
            System.out.println("Tên hoặc Id đã tồn tại");
        } else if (checkValidRole(role)) {
            newUser = new User(userID, userName, password, role);
            System.out.println("Tạo người dùng mới thành công");
        } else {
            System.out.println("Vai trò không hơp lệ");
        }
        return newUser;

    }

    public void displayAllRegister() {
        for (User user : listUser
        ) {
            if (user.getRole().equals(null)) {
                System.out.println(user);
            }

        }
    }

}
