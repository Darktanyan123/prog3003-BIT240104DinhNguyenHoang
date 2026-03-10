package bai4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class TemperatureConverter extends Application {

    @Override
    public void start(Stage stage) {

        TextField celsiusInput = new TextField();
        celsiusInput.setPromptText("Nhap");
        Label celsiusLabel = new Label("°C");
        HBox inputBox = new HBox(8, celsiusInput, celsiusLabel);

        VBox root = getVBox(celsiusInput, inputBox);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 150);

        stage.setTitle("°C -> °F");
        stage.setScene(scene);
        stage.show();
    }

    private static VBox getVBox(TextField celsiusInput, HBox inputBox) {
        Button convertButton = new Button("Chuyển đổi");

        Label resultLabel = new Label("Kết quả: ");

        convertButton.setOnAction(e -> {
            try {
                double c = Double.parseDouble(celsiusInput.getText().trim());
                double f = c * 9 / 5 + 32;
                resultLabel.setText(String.format("Kết quả: %.2f °F", f));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Vui lòng nhập số hợp lệ");
            }
        });

        VBox root = new VBox(10, inputBox, convertButton, resultLabel);
        return root;
    }

    public static void main(String[] args) {
        launch();
    }
}
