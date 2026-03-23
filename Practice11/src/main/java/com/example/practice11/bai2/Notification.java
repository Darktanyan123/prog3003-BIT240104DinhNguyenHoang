package com.example.practice11.bai2;

public class Notification {

    private MessageService messageService; // dependency

    // Setter Injection
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message) {
        if (messageService != null) {
            messageService.sendMessage(message);
        } else {
            System.out.println("No MessageService provided!");
        }
    }
}