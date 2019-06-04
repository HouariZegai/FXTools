package com.houarizegai.fxtools.charts.piechart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class PieChartController implements Initializable {

    @FXML
    private PieChart pieChart;
    
    private ObservableList<PieChart.Data> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();

        // fill the pie chart by data
        data.add(new PieChart.Data("Java", 70.5));
        data.add(new PieChart.Data("C++", 45.5));
        data.add(new PieChart.Data("PHP", 30.5));
        data.add(new PieChart.Data("Python", 50.5));
        data.add(new PieChart.Data("C#", 60d));

        // set the data to the pie chart
        pieChart.setData(data);

    }

}
