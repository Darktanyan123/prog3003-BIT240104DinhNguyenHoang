module bai1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens bai1 to javafx.fxml;
    exports bai1;
    opens bai4 to javafx.graphics;
    exports bai4;
}