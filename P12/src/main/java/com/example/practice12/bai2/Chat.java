package com.example.practice12.bai2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Chat extends Application {
    private WebSocketClient webSocketClient;
    private TextArea chatArea;
    private TextField inputField;

    @Override
    public void start(Stage primaryStage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        VBox.setVgrow(chatArea, Priority.ALWAYS);

        inputField = new TextField();
        inputField.setPromptText("Nhap tin nhan...");
        HBox.setHgrow(inputField, Priority.ALWAYS);

        Button btnSend = new Button("Gui");

        HBox bottomBox = new HBox(10, inputField, btnSend);
        VBox root = new VBox(10, chatArea, bottomBox);
        root.setPadding(new Insets(10));

        connectToServer();

        btnSend.setOnAction(e -> sendMessage());
        inputField.setOnAction(e -> sendMessage());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Chat Local");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(e -> {
            if (webSocketClient != null) {
                webSocketClient.close();
            }
        });

        primaryStage.show();
    }

    private void connectToServer() {
        try {
            URI serverUri = new URI("ws://172.17.144.92:8887");

            webSocketClient = new WebSocketClient(serverUri) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    Platform.runLater(() -> chatArea.appendText(">> Đã kết nối!\n"));
                }

                @Override
                public void onMessage(String message) {
                    Platform.runLater(() -> chatArea.appendText("Người lạ: " + message + "\n"));
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Platform.runLater(() -> chatArea.appendText(">> Mất kết nối\n"));
                }

                @Override
                public void onError(Exception ex) {
                    Platform.runLater(() -> chatArea.appendText("Lỗi: " + ex.getMessage() + "\n"));
                }
            };

            webSocketClient.connectBlocking();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String text = inputField.getText().trim();
        if (!text.isEmpty() && webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.send(text);
            chatArea.appendText("Tôi: " + text + "\n");
            inputField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}