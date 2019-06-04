package com.houarizegai.fxtools.forms.authentification.model8;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private StackPane paneRoot;

    @FXML // panes
    private VBox paneLogin, paneForgetRoot, paneForgetEmail, paneForgetNewPassword, paneForgetCongrate;

    /* Login info */
    @FXML
    private JFXTextField fieldEmail;
    @FXML
    private JFXPasswordField fieldPassword;

    @FXML
    private JFXCheckBox checkRememberMe;
    /* Forget Part */

    @FXML
    private JFXTextField fieldEmailForget;

    @FXML
    private JFXPasswordField fieldNewPassword;
    @FXML
    private JFXPasswordField fieldConfirmNewPassword;

    /* Additional Component */
    private JFXSnackbar toastMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toastMsg = new JFXSnackbar(paneRoot);
    }

    /* Login Methods */

    @FXML
    private void onForgetPassword() {
        paneLogin.setVisible(false);
        paneForgetRoot.setVisible(true);
        paneForgetEmail.setVisible(true);
    }

    @FXML
    private void onSignIn() {
        if(fieldEmail.getText() == null) {
            toastMsg.show("Email is empty !", 3000);
            return;
        }
        if(!fieldEmail.getText().trim().matches("[a-zA-Z0-9_]{5,40}")) {
            toastMsg.show("Email is failed !", 3000);
            return;
        }
        if(fieldPassword.getText() == null) {
            toastMsg.show("Password is Empty :", 3000);
            return;
        }
        if(fieldPassword.getText().length() < 4) {
            toastMsg.show("Password is less than 4 catactère !", 3000);
            return;
        }
        AnchorPane manageUser = null;
        try {
            manageUser = FXMLLoader.load(getClass().getResource(""));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        ((Stage) fieldEmail.getScene().getWindow()).setScene(new Scene(manageUser));
    }

    /* Forget Methods */
    @FXML
    private void onSendEmail() {
        if(fieldEmailForget.getPromptText().equalsIgnoreCase("Email")) {
            fieldEmailForget.setPromptText("Code");
        } else {
            paneForgetEmail.setVisible(false);
            paneForgetNewPassword.setVisible(true);
            fieldEmailForget.setPromptText("Email");
        }
    }

    @FXML
    private void onSendNewPassword() { // send new password for reset password
        paneForgetNewPassword.setVisible(false);
        paneForgetCongrate.setVisible(true);
    }

    @FXML
    private void onBackToLogin() {
        paneForgetCongrate.setVisible(false);
        paneForgetRoot.setVisible(false);
        paneLogin.setVisible(true);
    }
}
