package com.example.practice10.Bai4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bai4 extends Application {

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Tạo components
        Label lbl1 = new Label("So thu nhat:");
        TextField txt1 = new TextField();

        Label lbl2 = new Label("So thu hai:");
        TextField txt2 = new TextField();

        Label resultLabel = new Label("Ket qua: ");

        Button btn = new Button("Tinh tong");

        // Thêm vào grid
        grid.add(lbl1, 0, 0);
        grid.add(txt1, 1, 0);

        grid.add(lbl2, 0, 1);
        grid.add(txt2, 1, 1);

        grid.add(btn, 0, 2);
        grid.add(resultLabel, 1, 2);

        btn.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(txt1.getText());
                double num2 = Double.parseDouble(txt2.getText());

                double sum = num1 + num2;

                resultLabel.setText("Ket qua: " + sum);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Lỗi!");
            }
        });

        // Tạo scene
        Scene scene = new Scene(grid, 300, 150);

        stage.setTitle("May tinh cong");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}