package com.example.practice12.bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap a: ");
        int a = sc.nextInt();

        System.out.print("Nhap b: ");
        int b = sc.nextInt();

        MathOperation add = (x, y) -> x + y;
        MathOperation sub = (x, y) -> x - y;
        MathOperation mul = (x, y) -> x * y;
        MathOperation div = (x, y) -> {
            if (y == 0) throw new ArithmeticException("Khong chia duoc cho 0");
            return x / y;
        };

        System.out.println("Cộng: " + add.compute(a, b));
        System.out.println("Trừ: " + sub.compute(a, b));
        System.out.println("Nhân: " + mul.compute(a, b));
        System.out.println("Chia: " + div.compute(a, b));
    }
}