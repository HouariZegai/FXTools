package com.houarizegai.javafxtools.management.model1.dao;

public class EmployeeVo {
    private String name;
    private String job;
    private int age;
    private boolean gender;

    public EmployeeVo() {
        
    }
    
    public EmployeeVo(String name, String job, int age, boolean gender) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
}
