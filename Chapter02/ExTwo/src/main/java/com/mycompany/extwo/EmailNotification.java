
package com.mycompany.extwo;
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Gửi thông báo qua Email");
    }
}
