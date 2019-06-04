package com.houarizegai.fxtools.internationalization;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MultiLangController implements Initializable {

    @FXML
    private Label lblUsername, lblPassword;

    ResourceBundle bundle;
    Locale locale;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void setLangAR() {
        loadLang("ar");
    }

    @FXML
    private void setLangEN() {
        loadLang("en");
    }

    @FXML
    private void setLangFR() {
        loadLang("fr");
    }

    private void loadLang(String lang) {
        locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("com.houarizegai.fxtools.internationalization.lang", locale);

        lblUsername.setText(toUTF(bundle.getString("username")));
        lblPassword.setText(toUTF(bundle.getString("password")));
    }

    private String toUTF(String val) {
        try {
            return new String(val.getBytes("ISO-8859-1"), "UTF-8");
        } catch(Exception ex) {

        }
        return null;
    }

}
