
package com.houarizegai.javafxtools;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/houarizegai/javafxtools/lists/Lists.fxml"));
        
        stage.setScene(new Scene(root));
        stage.setTitle("JavaFx Tools");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
