package com.houarizegai.fxtools.forms.authentification.model3;

import com.houarizegai.fxtools.Launch;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthentificationController implements Initializable {
    @FXML
    private AnchorPane root;
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

    // For Make Stage Drageable
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        translateAnimation = new TranslateTransition();
        makeStageDrageable();
    }

    private void makeStageDrageable() {
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Launch.stage.setX(event.getScreenX() - xOffset);
                Launch.stage.setY(event.getScreenY() - yOffset);
                Launch.stage.setOpacity(0.7f);
            }
        });
        root.setOnDragDone((e) -> {
            Launch.stage.setOpacity(1.0f);
        });
        root.setOnMouseReleased((e) -> {
            Launch.stage.setOpacity(1.0f);
        });

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

    /* Control Stage action */
    @FXML
    private void onClose() {
        Platform.exit();
    }
    @FXML
    private void onHide() {
        ((Stage) fieldEmailSignIn.getScene().getWindow()).setIconified(true);
    }
}
