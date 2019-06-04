package com.houarizegai.javafxtools.charts.linechart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class LineChartController implements Initializable {

    @FXML
    private LineChart<String, Double> lineChart;
    
    XYChart.Series series1, series2, series3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //defining a series
        series1 = new XYChart.Series();
        series1.setName("Time Active in 2018");
        
        series2 = new XYChart.Series();
        series2.setName("Time Active in 2017");
        
        series3 = new XYChart.Series();
        series3.setName("Time Active in 2016");

        // Populating the series with data
        for (int i = 1; i <= 12; i++) {
            series1.getData().add(new XYChart.Data("" + i, i / 2));
            series2.getData().add(new XYChart.Data("" + i, i));
            series3.getData().add(new XYChart.Data("" + i, i * 2));
        }

        // Add the series (lines) to the chart
        lineChart.getData().addAll(series1, series2, series3);
    }
}
