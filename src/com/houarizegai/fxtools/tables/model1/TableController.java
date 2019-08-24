package com.houarizegai.fxtools.tables.model1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, ?> colSelect, colId, colName, colStatus, colActions, colUrl;

    public static TableView<Employee> staticTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        staticTable = table;
        initTable();
        loadTable();
    }

    private void initTable() {
        for(TableColumn column: table.getColumns())
            column.setStyle("-fx-alignment: center");

        colSelect.setCellValueFactory(new PropertyValueFactory<>("selectCheck"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("statusLbl"));
        colActions.setCellValueFactory(new PropertyValueFactory<>("actionContainer"));
        colUrl.setCellValueFactory(new PropertyValueFactory<>("url"));
    }

    private void loadTable() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        employees.add(new Employee(table, 1, "Houari", true, "https://houarizegai.github.io"));
        employees.add(new Employee(table, 2, "Moh", false, "http://houarizegai.me"));
        employees.add(new Employee(table, 3, "Fatima", true, "https://www.fb.com"));

        table.getItems().addAll(employees);
    }

}
