package com.houarizegai.fxtools.tables;

import com.houarizegai.fxtools.Launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TablesDemo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("model1/Table.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FXTools - Tables");
        Launch.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
