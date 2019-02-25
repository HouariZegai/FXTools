package com.houarizegai.javafxtools.crud.model1;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends RecursiveTreeObject<Employee>{
    
    private final StringProperty name;
    private final StringProperty job;
    private final StringProperty age;
    private final StringProperty gender;
    
    public Employee(String name, String job, int age, boolean isMale) {
        this.name = new SimpleStringProperty(name);
        this.job = new SimpleStringProperty(job);
        this.age = new SimpleStringProperty(String.valueOf(age));
        this.gender = new SimpleStringProperty(isMale? "Male" : "Female");
    }
    
    public StringProperty getName() {
        return name;
    }
    
    public StringProperty getJob() {
        return job;
    }
    
    public StringProperty getAge() {
        return age;
    }
    
    public StringProperty getGender() {
        return gender;
    }
    
}
