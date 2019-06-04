package com.houarizegai.fxtools.preloader.splash;

import com.jfoenix.controls.JFXSpinner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {
    @FXML
    private JFXSpinner progress;

    public static JFXSpinner staticProgress;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        staticProgress = progress;
    }
}
