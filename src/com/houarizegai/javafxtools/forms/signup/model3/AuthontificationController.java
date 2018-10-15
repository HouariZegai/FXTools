package com.houarizegai.javafxtools.forms.signup.model3;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthontificationController implements Initializable {
    @FXML
    private StackPane rootSign;
    @FXML
    private VBox paneSignIn, paneSignUp;

    /* Sign In Attribute */
    @FXML
    private JFXTextField fieldEmailSignIn;
    @FXML
    private JFXPasswordField fieldPasswordSignIn;

    /* Sign Up Attribute */
    @FXML
    private JFXTextField fieldFullNameSignUp, fieldEmailSignUp;
    @FXML
    private JFXPasswordField fieldPasswordSignUp;

    // for animation
    TranslateTransition translateAnimation;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        translateAnimation = new TranslateTransition();
    }

    /* Change Pane (between Sign in and Sign up */
    @FXML
    private void goToSignIn() {
        translateAnimation.setToX(0);
        translateAnimation.setNode(rootSign);
        translateAnimation.setDuration(Duration.seconds(1.5));
        translateAnimation.play();
        translateAnimation.setOnFinished(e -> {
            paneSignIn.setVisible(true);
            paneSignUp.setVisible(false);
        });
    }
    @FXML
    private void goToSignUp() {
        translateAnimation.setToX(-500);
        translateAnimation.setNode(rootSign);
        translateAnimation.setDuration(Duration.seconds(1.5));
        translateAnimation.play();
        translateAnimation.setOnFinished(e -> {
            paneSignIn.setVisible(false);
            paneSignUp.setVisible(true);
        });
    }

    /* Sign In Action */
    @FXML
    private void onSignIn() {

    }

    /* Sign Up Action */
    @FXML
    private void onSignUp() {

    }
}
