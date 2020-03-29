package com.houarizegai.fxtools.custom.controls.showpassfield;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;

public class JFXShowPasswordField extends VBox {
    // text field to show password as unmasked
    final JFXTextField textField;
    // Actual password field
    final JFXPasswordField passwordField;

    public JFXShowPasswordField() {
        textField = new JFXTextField();
        passwordField = new JFXPasswordField();

        // Set initial state
        textField.setManaged(false);
        textField.setVisible(false);

        // Binds changing of style between textField & passwordField
        textField.styleProperty().bind(passwordField.styleProperty());

        // Bind the textField and passwordField text values bidirectionally.
        textField.textProperty().bindBidirectional(passwordField.textProperty());

        this.getChildren().addAll(passwordField, textField);
    }

    public JFXShowPasswordField(String text) {
        this();
        this.getField().setText(text);
    }

    public void setShowPass(boolean show) {
        textField.setManaged(show);
        textField.setVisible(show);
        passwordField.setManaged(!show);
        passwordField.setVisible(!show);
    }

    public boolean isShowing() {
        return textField.isVisible();
    }

    public PasswordField getField() {
        return this.passwordField;
    }

}
