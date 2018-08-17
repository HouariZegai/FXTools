package com.houarizegai.javafxtools.datetime;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class DateTimeController implements Initializable {

    @FXML
    private Label lblDate, lblTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initClock();
    }

    public void initClock() { // initialize Clock
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lblDate.setText(dateFormat.format(date));
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            lblTime.setText(dateFormat.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

}
