
package com.houarizegai.fxtools.forms.authentification;

import com.houarizegai.fxtools.Launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class FormsDemo extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("model9/Authentification.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        FormsDemo.stage = stage;
        makeStageTransparent();
        stage.setTitle("FXTools - Forms");
        stage.show();
    }

    public static void makeStageTransparent() {
        stage.getScene().setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
    }

}
