
package com.mycompany.extwo;
public class NotificationFactory {

    public static Notification createNotification(String channel) {
        if (channel.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (channel.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (channel.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null; // nếu không hợp lệ
    }
}
