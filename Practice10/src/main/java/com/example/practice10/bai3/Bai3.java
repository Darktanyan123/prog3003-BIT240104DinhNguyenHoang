package com.example.practice10.bai3;

class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

class WorkerRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnabling...");
    }
}

public class Bai3 {
    public static void main(String[] args) {

        WorkerThread t1 = new WorkerThread();
        t1.start();


        Thread t2 = new Thread(new WorkerRunnable());
        t2.start();
    }
}