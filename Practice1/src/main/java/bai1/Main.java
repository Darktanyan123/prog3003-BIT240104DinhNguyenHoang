package bai1;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String mssv;
    private String name;
    private double gpa;

    public Student(String mssv, String name, double gpa) {
        this.mssv = mssv;
        this.name = name;
        this.gpa = gpa;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "MSSV: " + mssv + ", Tên: " + name + ", GPA: " + gpa;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n===== MElU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm theo tên");
            System.out.println("4. Xóa theo MSSV");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.next();
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("0")) {
                System.out.println("Lựa chọn không hợp lệ!");
                System.out.print("Chọn: ");
                choice = scanner.next();
            }
            scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Nhập MSSV: ");
                    String mssv = scanner.nextLine();

                    System.out.print("Nhập Tên: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    students.add(new Student(mssv, name, gpa));
                    System.out.println("Thêm thành công!");
                    break;

                case "2":
                    if (students.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.getName().contains(searchName)) {
                            System.out.println(s);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên!");
                    }
                    break;

                case "4":
                    System.out.print("Nhập MSSV cần xóa: ");
                    String deleteMssv = scanner.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getMssv().equals(deleteMssv)) {
                            students.remove(i);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy MSSV!");
                    }
                    break;

                case "0":
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (!choice.equals("0"));

        scanner.close();
    }
}