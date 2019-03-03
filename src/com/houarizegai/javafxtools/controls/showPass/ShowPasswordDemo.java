package com.houarizegai.javafxtools.controls.showPass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowPasswordDemo extends Application {
    @Override
    public void start(Stage primaryStage) {

        JFXShowPasswordField showPassField = new JFXShowPasswordField();
        showPassField.getField().setPromptText("Type Password");
        showPassField.getField().setStyle("-fx-font-size: 24px; -fx-text-fill: #E00");

        Button btn = new Button("Show/Hide");
        btn.setOnAction(e -> showPassField.setShowPass(!showPassField.isShowing()));

        VBox root = new VBox(10);
        root.getChildren().addAll(showPassField, btn);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}