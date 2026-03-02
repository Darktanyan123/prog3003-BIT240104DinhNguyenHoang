module com.example.practice1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens bai1 to javafx.fxml;
    exports bai1;
}