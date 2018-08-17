package com.houarizegai.javafxtools.forms.login.model2;

import com.jfoenix.controls.JFXSnackbar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class LoginController implements Initializable {

    @FXML
    private VBox root;
    
    @FXML
    private JFXSnackbar toastMsg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toastMsg = new JFXSnackbar(root);
        toastMsg.getStylesheets().add("login.css");
        
        root.setOnKeyReleased(e -> {
            if(e.getCode().equals(KeyCode.ENTER)) {
                onLogin();
            }
        });
    }
    
    @FXML
    private void onLogin() {
        toastMsg.show("Connection failed !", 3000);
    }
    
}
