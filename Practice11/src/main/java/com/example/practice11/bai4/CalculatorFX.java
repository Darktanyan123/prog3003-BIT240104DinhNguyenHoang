package com.example.practice11.bai4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorFX extends Application {

    private TextField display = new TextField("0");
    private String input = "";
    private boolean justCalculated = false;
    @Override
    public void start(Stage stage) {

        // ===== DISPLAY =====
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle(
                "-fx-font-size: 40px;" +
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: black;"
        );
        display.setPrefHeight(80);

        // ===== MEMORY ROW =====
        HBox memoryRow = new HBox(10);
        memoryRow.setPadding(new Insets(5, 0, 5, 0));


        // ===== BUTTON GRID =====
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        String[][] layout = {
                {"%", "CE", "C", "⌫"},
                {"1/x", "x²", "√", "/"},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"+/-", "0", ".", "="}
        };

        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                String text = layout[i][j];
                Button btn = createButton(text);

                // nút "=" màu xanh
                if (text.equals("=")) {
                    btn.setStyle(
                            "-fx-background-color: #0078D7;" +
                                    "-fx-text-fill: white;" +
                                    "-fx-font-size:16px;" +
                                    "-fx-background-radius: 10;"
                    );
                }

                grid.add(btn, j, i);
            }
        }

        // ===== ROOT =====
        VBox root = new VBox(10, display, memoryRow, grid);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #f3f3f3;");

        Scene scene = new Scene(root, 320, 500);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String text) {
        Button btn = new Button(text);
        btn.setPrefSize(70, 60);

        btn.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-background-color: #e6e6e6;" +
                        "-fx-background-radius: 10;"
        );

        btn.setOnAction(e -> handle(text));
        return btn;
    }

    private void handle(String val) {

        if (justCalculated) {

            if (val.matches("[0-9.]")) {
                input = ""; // reset sạch
            }

            justCalculated = false;
        }
        switch (val) {

            case "C":
                input = "";
                display.setText("0");
                return;

            case "CE":
                input = "";
                display.setText("0");
                return;

            case "⌫":
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                }
                break;

            case "=":
                try {
                    input = String.valueOf(eval(input));
                } catch (Exception e) {
                    input = "Error";
                }
                display.setText(input);
                justCalculated = true;
                break;

            case "+/-":
                if (!input.isEmpty()) {
                    // tìm toán tử cuối
                    int i = input.length() - 1;
                    while (i >= 0 && "0123456789.".indexOf(input.charAt(i)) != -1) {
                        i--;
                    }

                    String prefix = input.substring(0, i + 1);
                    String number = input.substring(i + 1);

                    if (number.startsWith("-"))
                        number = number.substring(1);
                    else
                        number = "-" + number;

                    input = prefix + number;
                }
                break;

            case "√":
                if (!input.isEmpty()) {
                    input = "sqrt(" + input + ")";
                }
                break;

            case "x²":
                if (!input.isEmpty()) {
                    input = "(" + input + ")^2";
                }
                break;

            case "1/x":
                if (!input.isEmpty()) {
                    input = "1/(" + input + ")";
                }
                break;

            // 👉 toán tử
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":

                if (input.isEmpty()) return;

                char last = input.charAt(input.length() - 1);

                // tránh nhập 2 toán tử liên tiếp
                if ("+-*/%".indexOf(last) != -1) {
                    input = input.substring(0, input.length() - 1);
                }

                input += val;
                break;

            // 👉 dấu chấm
            case ".":
                if (input.isEmpty() || !Character.isDigit(input.charAt(input.length() - 1))) {
                    input += "0.";
                } else if (!input.substring(input.lastIndexOf(" ") + 1).contains(".")) {
                    input += ".";
                }
                break;

            default:
                input += val;
        }

        display.setText(input.isEmpty() ? "0" : input);
    }
    // ===== SIMPLE EXPRESSION PARSER =====
    private double eval(String expr) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() { ch = (++pos < expr.length()) ? expr.charAt(pos) : -1; }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) { nextChar(); return true; }
                return false;
            }

            double parse() {
                nextChar();
                return parseExpression();
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;

                // sqrt
                if (Character.isLetter(ch)) {
                    while (Character.isLetter(ch)) nextChar();
                    String func = expr.substring(startPos, this.pos);

                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else {
                        x = parseFactor();
                    }

                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else throw new RuntimeException("Unknown function");
                }

                // số
                else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expr.substring(startPos, this.pos));
                }

                // ngoặc
                else if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                }

                else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                // 👉 lũy thừa ^
                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }

    public static void main(String[] args) {
        launch(args);
    }
}