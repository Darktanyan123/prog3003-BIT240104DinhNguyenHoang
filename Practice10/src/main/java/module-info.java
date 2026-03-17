module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.practice10.Bai4 to javafx.fxml;
    exports com.example.practice10.Bai4;
}



//        opens bai1 to javafx.fxml;
//        exports bai1;
//        opens bai4 to javafx.graphics;
//        exports bai4;
//        }
