package com.houarizegai.fxtools.tables.model1;

import com.jfoenix.controls.JFXCheckBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class Employee {
    private JFXCheckBox selectCheck;
    private int id;
    private String name;
    private Label statusLbl;
    private HBox actionContainer;
    private FontAwesomeIconView deleteIcon, editIcon;
    private Hyperlink url;

    private TableView containerTable;

    public Employee(TableView containerTable, int id, String name, boolean isSuccess, String url) {
        this.id = id;
        this.name = name;
        this.containerTable = containerTable;
        this.url = new Hyperlink(url);

        selectCheck = new JFXCheckBox();
        selectCheck.getStyleClass().add("check-select");

        initActions();
        setStatus(isSuccess);
    }

    public JFXCheckBox getSelectCheck() {
        return selectCheck;
    }

    public void setSelectCheck(JFXCheckBox selectCheck) {
        this.selectCheck = selectCheck;
    }

    private void setStatus(boolean isSuccess) {
        statusLbl = new Label();
        statusLbl.getStyleClass().add("lbl");
        if(isSuccess) {
            statusLbl.setText("Success");
            statusLbl.getStyleClass().add("lbl-success");
        } else {
            statusLbl.setText("Failed");
            statusLbl.getStyleClass().add("lbl-failed");
        }
    }

    private void initActions() {
        deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
        deleteIcon.getStyleClass().addAll("icon-action", "icon-action-trash");
        deleteIcon.setOnMouseClicked(e -> {
            System.out.println(id + " - was clicked!");
            containerTable.getItems().remove(this);
        });

        editIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
        editIcon.getStyleClass().addAll("icon-action", "icon-action-edit");
        editIcon.setOnMouseClicked(e -> {
            System.out.println(id + " - edit icon was clicked!");
        });

        actionContainer = new HBox(20);
        actionContainer.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        actionContainer.getChildren().addAll(editIcon, deleteIcon);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Label getStatusLbl() {
        return statusLbl;
    }

    public HBox getActionContainer() {
        return actionContainer;
    }

    public Hyperlink getUrl() {
        return url;
    }
}
