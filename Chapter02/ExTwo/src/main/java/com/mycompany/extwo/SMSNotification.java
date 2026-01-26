
package com.mycompany.extwo;
public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Gửi thông báo qua SMS");
    }
}
