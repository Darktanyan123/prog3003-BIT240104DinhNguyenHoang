module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.practice11.bai4 to javafx.fxml;
    exports com.example.practice11.bai4;
}
