package com.example.practice11.bai2;

public class MainApp {
    public static void main(String[] args) {

        Notification notification = new Notification();

        // Dùng Email
        notification.setMessageService(new EmailService());
        notification.notifyUser("Hello via Email!");

        // Dùng SMS
        notification.setMessageService(new SMSService());
        notification.notifyUser("Hello via SMS!");
    }
}