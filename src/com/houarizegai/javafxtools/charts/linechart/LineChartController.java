package com.houarizegai.javafxtools.charts.linechart;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

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
        
        // Initialize series
        for (int i = 1; i <= 12; i++) {
            series1.getData().add(new XYChart.Data<>(getMonthString(i), 0.0));
            series2.getData().add(new XYChart.Data<>(getMonthString(i), 0.0));
            series3.getData().add(new XYChart.Data<>(getMonthString(i), 0.0));
        }

        // Populating the series with data
        for (int i = 1; i < 12; i++) {
            series1.getData().set(i, new XYChart.Data(getMonthString(i), i / 2));
            series2.getData().set(i, new XYChart.Data(getMonthString(i), i));
            series3.getData().set(i, new XYChart.Data(getMonthString(i), i * 2));
        }
        
        lineChart.getData().addAll(series1, series2, series3);
    }   
    
    private String getMonthString(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "";
    }
}
