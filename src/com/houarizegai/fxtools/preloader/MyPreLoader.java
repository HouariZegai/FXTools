package com.houarizegai.fxtools.preloader;

import com.houarizegai.fxtools.preloader.splash.SplashScreenController;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreLoader extends Preloader {

    private Stage splashScreenStage;
    private Scene scene;

    @Override
    public void init() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("splash/SplashScreen.fxml"));
        scene = new Scene(root);
    }

    @Override
    public void start(Stage stage) {
        splashScreenStage = stage;
        splashScreenStage.setScene(scene);
        splashScreenStage.initStyle(StageStyle.UNDECORATED);
        splashScreenStage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification notification) {
        if(notification instanceof ProgressNotification) {
            double progressValue = ((ProgressNotification) notification).getProgress();
            System.out.println(progressValue);
            SplashScreenController.staticProgress.setProgress(progressValue);
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_START:
                System.out.println("Before start !");
                splashScreenStage.hide();
                break;
        }
     }
}
