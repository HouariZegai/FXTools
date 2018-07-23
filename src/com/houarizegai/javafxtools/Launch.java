
package com.houarizegai.javafxtools;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Launch extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/houarizegai/javafxtools/box/model1/Model1.fxml"));
        
        stage.setTitle("JavaFx Tools");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
