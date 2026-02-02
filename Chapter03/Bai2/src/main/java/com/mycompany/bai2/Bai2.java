
package com.mycompany.bai2;
class NumberThread extends Thread {
    public NumberThread(String name) {
        super(name); // đặt tên thread
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ": " + i); // in tên thread + số
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new NumberThread("Thread-" + i).start(); // tạo và chạy 5 thread
        }
    }
}
