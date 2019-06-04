package com.houarizegai.fxtools.fonts.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChangeFontDemo extends Application {

    @Override
    public void start(Stage stage) {
        Font digitalFont = Font.loadFont(getClass().getResourceAsStream("/com/houarizegai/fxtools/fonts/digital-7.ttf"), 50);

        Label lbl = new Label("0123456789 DA"); // Test digit number (using in sell system)
        // change font using java
        lbl.setFont(digitalFont);
        lbl.setStyle("-fx-background-color: #333; -fx-text-fill: #FFF");

        TextField textField = new TextField();
        textField.setFont(digitalFont);

        Scene scene = new Scene(new VBox(20, lbl, textField), 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
