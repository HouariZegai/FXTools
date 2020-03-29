
package com.houarizegai.fxtools.lists;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ListsDemo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("model1/List.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FXTools - List");
        stage.show();
    }

}
