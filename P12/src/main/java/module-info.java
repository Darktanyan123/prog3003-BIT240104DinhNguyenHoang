module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires Java.WebSocket;

    opens com.example.practice12.bai2 to javafx.fxml;
    exports com.example.practice12.bai2;
}
