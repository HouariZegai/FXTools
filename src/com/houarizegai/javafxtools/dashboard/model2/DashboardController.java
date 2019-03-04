package com.houarizegai.javafxtools.dashboard.model2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private LineChart<String, Double> lineChart;
    XYChart.Series series1, series2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //defining a series
        series1 = new XYChart.Series();
        series2 = new XYChart.Series();

        series1.setName("X series");
        series2.setName("Y series");

        /* Initialize series */
        for(int i = 0; i < 15; i++) {
            series1.getData().add(new XYChart.Data<>(i + ".10", 10 * i % 30));
            series2.getData().add(new XYChart.Data<>(i + ".10", 5 * i % 30));
        }


        lineChart.getData().addAll(series1, series2);
    }
}
