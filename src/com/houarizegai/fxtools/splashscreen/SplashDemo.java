package com.houarizegai.fxtools.splashscreen;

import com.houarizegai.fxtools.Launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SplashDemo extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("model3/SplashScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FXTools - Splash Screen");
        SplashDemo.stage = stage;
        makeStageTransparent();
        stage.show();
    }

    public static void makeStageTransparent() {
        stage.getScene().setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
