package com.houarizegai.javafxtools.newfeatures.showPass;

import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowPasswordDemo extends Application {
    @Override
    public void start(Stage primaryStage) {

        JFXShowPasswordField showPassField = new JFXShowPasswordField();
        showPassField.getField().setPromptText("Type Password");
        showPassField.getField().setStyle("-fx-font-size: 24px");

        MaterialIconView iconVisible = new MaterialIconView(MaterialIcon.VISIBILITY_OFF);
        iconVisible.setSize("25px");

        iconVisible.setOnMouseClicked(e -> {
            if(showPassField.isShowing()) {
                showPassField.setShowPass(false);
                iconVisible.setIcon(MaterialIcon.VISIBILITY_OFF);
            } else {
                showPassField.setShowPass(true);
                iconVisible.setIcon(MaterialIcon.VISIBILITY);
            }
        });

        HBox container = new HBox(5);
        container.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(showPassField, iconVisible);

        Scene scene = new Scene(new StackPane(container), 500, 250);
        primaryStage.setTitle("Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}