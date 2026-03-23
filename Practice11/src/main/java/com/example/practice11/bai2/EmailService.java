package com.example.practice11.bai2;

public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}