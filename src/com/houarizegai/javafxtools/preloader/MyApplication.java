package com.houarizegai.javafxtools.preloader;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {

    private static final int COUNT_LIMIT = 10;

    @Override
    public void init() {
        // load all (database start, check update for application, ...and more)
        for(int i = 0; i < COUNT_LIMIT; i++) {
            double progressValue =  i / (double) COUNT_LIMIT;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progressValue));

            try {Thread.sleep(1000);} catch(Exception e) {e.printStackTrace();}
        }
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        stage.setScene(scene);
        stage.setTitle("My Application");
        stage.show();
    }

    public Parent createContent() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("app/MyApp.fxml"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return root;
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(MyApplication.class, MyPreLoader.class, args);
    }
}