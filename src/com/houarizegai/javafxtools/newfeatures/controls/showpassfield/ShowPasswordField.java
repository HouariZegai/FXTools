package com.houarizegai.javafxtools.newfeatures.controls.showpassfield;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ShowPasswordField extends VBox {
    // text field to show password as unmasked
    final TextField textField;
    // Actual password field
    final PasswordField passwordField;

    public ShowPasswordField() {
        textField = new TextField();
        passwordField = new PasswordField();

        // Set initial state
        textField.setManaged(false);
        textField.setVisible(false);

        // Binds changing of style between textField & passwordField
        textField.styleProperty().bind(passwordField.styleProperty());

        // Bind the textField and passwordField text values bidirectionally.
        textField.textProperty().bindBidirectional(passwordField.textProperty());

        this.getChildren().addAll(passwordField, textField);
    }

    public ShowPasswordField(String text) {
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
