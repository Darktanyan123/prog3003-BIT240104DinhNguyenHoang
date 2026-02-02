
package com.mycompany.bai1;
class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread dang chay...");
    }
}

// WorkerRunnable triển khai Runnable
class WorkerRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable dang chay...");
    }
}

public class Bai1 {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread(); // tạo thread bằng cách kế thừa Thread
        Thread t2 = new Thread(new WorkerRunnable()); // tạo thread từ Runnable

        t1.start(); // chạy WorkerThread
        t2.start(); // chạy WorkerRunnable
    }
}
