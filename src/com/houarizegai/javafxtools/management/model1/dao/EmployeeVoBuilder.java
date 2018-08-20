package com.houarizegai.javafxtools.management.model1.dao;

// Builder Design Pattern
public class EmployeeVoBuilder {
    private String name;
    private String job;
    private int age;
    private boolean gender;

    public EmployeeVoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeVoBuilder setJob(String job) {
        this.job = job;
        return this;
    }

    public EmployeeVoBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public EmployeeVoBuilder setGender(boolean gender) {
        this.gender = gender;
        return this;
    }
    
    public EmployeeVo getEmployeeVo() {
        return new EmployeeVo(name, job, age, gender);
    }
}
