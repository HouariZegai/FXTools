package com.houarizegai.fxtools.charts.barchart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class BarChartController implements Initializable {
    
    @FXML
    private BarChart barChart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadBarChar();
    }   
    
    private void loadBarChar() {

        XYChart.Series xyJava = new XYChart.Series();
        XYChart.Series xyC = new XYChart.Series();
        XYChart.Series xyJS = new XYChart.Series();
        
        xyJava.setName("Java");
        xyC.setName("C");
        xyJS.setName("JS");

        // insert the data to the series (bars)

        xyJava.getData().addAll(
                new XYChart.Data<>("September", 20),
                new XYChart.Data<>("October", 20),
                new XYChart.Data<>("November", 15));

        xyC.getData().addAll(
                new XYChart.Data<>("September", 50),
                new XYChart.Data<>("October", 10),
                new XYChart.Data<>("November", 10));

        xyJS.getData().addAll(
                new XYChart.Data<>("September", 30),
                new XYChart.Data<>("October", 80),
                new XYChart.Data<>("November", 20));

        // add the series to the chart
        barChart.getData().addAll(xyJava, xyC, xyJS);
        
    }
    
    
    
}
