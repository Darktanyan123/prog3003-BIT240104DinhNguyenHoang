
package com.mycompany.exone;
public class DatabaseConnection {

    private static DatabaseConnection instance; // lưu instance duy nhất

    private DatabaseConnection() { // constructor private
        System.out.println("Ket noi CSDL đuoc thiet lap");
    }

    public static DatabaseConnection getInstance() { // method lấy instance
        if (instance == null) {
            instance = new DatabaseConnection(); // tạo mới nếu chưa có
        }
        return instance; // trả về instance đã có
    }
}
