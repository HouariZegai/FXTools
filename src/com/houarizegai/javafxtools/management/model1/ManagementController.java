package com.houarizegai.javafxtools.management.model1;

import com.houarizegai.javafxtools.management.model1.dao.EmployeeDao;
import com.houarizegai.javafxtools.management.model1.dao.EmployeeVo;
import com.houarizegai.javafxtools.management.model1.dao.EmployeeVoBuilder;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Duration;

public class ManagementController implements Initializable {

    /* Table Part */
    @FXML
    private JFXTreeTableView tableEmployees;
    
    private JFXTreeTableColumn<Employee, String> colName, colJob, colAge, colGender;

    /* Search Part */
    @FXML
    private JFXComboBox<String> comboSearch;
    @FXML
    private JFXTextField fieldSearch;

    /* Management Part */
    @FXML
    private JFXTextField fieldName, fieldJob, fieldAge;
    @FXML
    private JFXComboBox<String> fieldGender;

    /* View Part */
    @FXML
    private Label lblName, lblJob, lblAge, lblGender;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldGender.getItems().addAll("Male", "Female");
        comboSearch.getItems().addAll("Name", "Job", "Age", "Gender");
        
        initSearch(); // Initialize search
        initTable(); // Initialize table
        loadTable(); // Load data to table from database
        
    }
    
    private void initTable() {
        colName = new JFXTreeTableColumn<>("NAME");
        colName.setPrefWidth(200);
        colName.setCellValueFactory((TreeTableColumn.CellDataFeatures<Employee, String> param) -> param.getValue().getValue().getName());

        colJob = new JFXTreeTableColumn<>("JOB");
        colJob.setPrefWidth(200);
        colJob.setCellValueFactory((TreeTableColumn.CellDataFeatures<Employee, String> param) -> param.getValue().getValue().getJob());

        colAge = new JFXTreeTableColumn<>("AGE");
        colAge.setPrefWidth(200);
        colAge.setCellValueFactory((TreeTableColumn.CellDataFeatures<Employee, String> param) -> param.getValue().getValue().getAge());

        colGender = new JFXTreeTableColumn<>("GENDER");
        colGender.setPrefWidth(200);
        colGender.setCellValueFactory((TreeTableColumn.CellDataFeatures<Employee, String> param) -> param.getValue().getValue().getGender());
        
        tableEmployees.getColumns().addAll(colName, colJob, colAge, colGender);
        tableEmployees.setShowRoot(false);
        
        tableEmployees.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                int index = tableEmployees.getSelectionModel().getSelectedIndex(); // selected index
                lblName.setText(colName.getCellData(index));
                lblJob.setText(colJob.getCellData(index));
                lblAge.setText(colAge.getCellData(index));
                lblGender.setText(colGender.getCellData(index));
                fieldName.setText(colName.getCellData(index));
                fieldJob.setText(colJob.getCellData(index));
                fieldAge.setText(colAge.getCellData(index));
                fieldGender.getSelectionModel().select(colGender.getCellData(index));
            }
        });
    }

    private void loadTable() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        
        List<EmployeeVo> employeesDao = new EmployeeDao().getEmployees();
        if(employeesDao == null) {
            return;
        }
        
        for(EmployeeVo emp : employeesDao) {
            employees.add(new Employee(emp.getName().substring(0, 1).toUpperCase() + emp.getName().substring(1), 
                    emp.getJob().substring(0, 1).toUpperCase() + emp.getJob().substring(1), 
                    emp.getAge(), emp.getGender()));
        }
        
        final TreeItem<Employee> treeItem = new RecursiveTreeItem<>(employees, RecursiveTreeObject::getChildren);
        try {
            tableEmployees.setRoot(treeItem);
        } catch (Exception ex) {
            System.out.println("Error catched !");
        }
    }
    
    private void initSearch() {
        fieldSearch.textProperty().addListener(e -> {
            filterTable();
        });
        comboSearch.setOnAction(e -> {
            filterTable();
        });
    }

    private void filterTable() {
        tableEmployees.setPredicate(new Predicate<TreeItem<Employee>>() {
                @Override
                public boolean test(TreeItem<Employee> employee) {
                    switch (comboSearch.getSelectionModel().getSelectedIndex()) {
                        case 0:
                            return employee.getValue().getName().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase());
                        case 1:
                            return employee.getValue().getJob().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase());
                        case 2:
                            return employee.getValue().getAge().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase());
                        case 3:
                            return employee.getValue().getGender().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase());
                        default:
                            return employee.getValue().getName().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase())
                                    || employee.getValue().getJob().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase())
                                    || employee.getValue().getAge().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase())
                                    || employee.getValue().getGender().getValue().toLowerCase().contains(fieldSearch.getText().toLowerCase());
                    }
                }
            });
    }
    
    @FXML
    private void onAdd() {
        if(fieldName.getText().isEmpty() || !fieldName.getText().trim().matches("[a-zA-Z ]{4,}")) {
            return;
        }
        if(fieldJob.getText().isEmpty() || !fieldJob.getText().trim().matches("[a-zA-Z ]{2,}")) {
            return;
        }
        if(fieldAge.getText().isEmpty() || !fieldAge.getText().matches("[0-9]+") || 
                Integer.parseInt(fieldAge.getText()) < 1 || Integer.parseInt(fieldAge.getText()) > 150) {
            return;
        }
        if(fieldGender.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        
        new EmployeeDao().addEmployee(new EmployeeVoBuilder()
                .setName(fieldName.getText().toLowerCase())
                .setJob(fieldJob.getText().toLowerCase())
                .setAge(Integer.parseInt(fieldAge.getText()))
                .setGender(fieldGender.getSelectionModel().getSelectedIndex() == 0)
                .getEmployeeVo());
        
        lblName.setText(null);
        lblJob.setText(null);
        lblAge.setText(null);
        lblGender.setText(null);
        fieldName.setText(null);
        fieldJob.setText(null);
        fieldAge.setText(null);
        fieldGender.getSelectionModel().clearSelection();
        loadTable();
    }

    @FXML
    private void onDelete() {
        new EmployeeDao().deleteEmployee(new EmployeeVoBuilder()
        .setName(lblName.getText())
        .setJob(lblJob.getText())
        .setAge(Integer.parseInt(lblAge.getText()))
        .setGender(lblGender.getText().equalsIgnoreCase("Male"))
        .getEmployeeVo());
        
        lblName.setText(null);
        lblJob.setText(null);
        lblAge.setText(null);
        lblGender.setText(null);
        fieldName.setText(null);
        fieldJob.setText(null);
        fieldAge.setText(null);
        fieldGender.getSelectionModel().clearSelection();
        loadTable();
    }

    @FXML
    private void onEdit() {
        if(fieldName.getText().isEmpty() || !fieldName.getText().matches("[a-zA-Z]{4,}")) {
            return;
        }
        if(fieldJob.getText().isEmpty() || !fieldJob.getText().matches("[a-zA-Z]{2,}")) {
            return;
        }
        if(fieldAge.getText().isEmpty() || !fieldAge.getText().matches("[0-9]+") || 
                Integer.parseInt(fieldAge.getText()) < 1 || Integer.parseInt(fieldAge.getText()) > 150) {
            return;
        }
        if(fieldGender.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        
        EmployeeVo oldEmployee = new EmployeeVoBuilder()
                .setName(lblName.getText().toLowerCase())
                .setJob(lblJob.getText().toLowerCase())
                .setAge(Integer.parseInt(lblAge.getText()))
                .setGender(lblGender.getText().equalsIgnoreCase("Male"))
                .getEmployeeVo();
        
        EmployeeVo newEmployee = new EmployeeVoBuilder()
                .setName(fieldName.getText().trim().toLowerCase())
                .setJob(fieldJob.getText().trim().toLowerCase())
                .setAge(Integer.parseInt(fieldAge.getText()))
                .setGender(fieldGender.getSelectionModel().getSelectedIndex() == 0)
                .getEmployeeVo();
        
        new EmployeeDao().editEmployee(oldEmployee, newEmployee);
        
        lblName.setText(null);
        lblJob.setText(null);
        lblAge.setText(null);
        lblGender.setText(null);
        fieldName.setText(null);
        fieldJob.setText(null);
        fieldAge.setText(null);
        fieldGender.getSelectionModel().clearSelection();
        
        loadTable();
    }

    @FXML
    private void onClear() {
        fieldName.setText(lblName.getText());
        fieldJob.setText(lblJob.getText());
        fieldAge.setText(lblAge.getText());
        fieldGender.getSelectionModel().select(lblGender.getText());
    }
}
