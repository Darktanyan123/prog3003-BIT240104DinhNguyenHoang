
package com.mycompany.extwo;
public class Main {
    public static void main(String[] args) {
        Notification n1 = NotificationFactory.createNotification("SMS");
        n1.notifyUser();

        Notification n2 = NotificationFactory.createNotification("EMAIL");
        n2.notifyUser();
    }
}
