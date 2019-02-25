package com.houarizegai.javafxtools.crud.model1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    
    public List<EmployeeVo> getEmployees() {
        Connection con = new ConnectDB().getConnection();
        if(con == null) {
            return null;
        }
        
        List<EmployeeVo> employees = new ArrayList<>();
        
        String sql = "SELECT name, job, age, gender FROM employees";
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                employees.add(new EmployeeVoBuilder()
                        .setName(rs.getString("name"))
                        .setJob(rs.getString("job"))
                        .setAge(rs.getInt("age"))
                        .setGender(rs.getBoolean("gender"))
                        .getEmployeeVo());
            }
            
        } catch(SQLException se) {
            System.out.println("SQLException(getEmplyees): " + se.getMessage());
        }
        
        return employees;
    }
    
    public int addEmployee(EmployeeVo employee) {
        Connection con = new ConnectDB().getConnection();
        if(con == null) {
            return -1; // Connection failed !
        }
        
        List<EmployeeVo> employees = new ArrayList<>();
        
        String sql = "INSERT INTO employees (name, job, age, gender) VALUES(?, ?, ?, ?);";
        PreparedStatement prest = null;
        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, employee.getName());
            prest.setString(2, employee.getJob());
            prest.setInt(3, employee.getAge());
            prest.setBoolean(4, employee.getGender());
            prest.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("SQLException(addEmplyees): " + se.getMessage());
            return 1;
        }

        return 0;
    }
    
    public int deleteEmployee(EmployeeVo employee) {
        Connection con = new ConnectDB().getConnection();
        if(con == null) {
            return -1; // Connection failed !
        }
        
        List<EmployeeVo> employees = new ArrayList<>();
        
        String sql = "DELETE FROM employees WHERE name=? AND job=? AND age=? AND gender=?;";
        PreparedStatement prest = null;
        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, employee.getName());
            prest.setString(2, employee.getJob());
            prest.setInt(3, employee.getAge());
            prest.setBoolean(4, employee.getGender());
            prest.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("SQLException(deleteEmplyees): " + se.getMessage());
            return 1;
        }

        return 0;
    }
    
    public int editEmployee(EmployeeVo oldEmployee, EmployeeVo newEmployee) {
        Connection con = new ConnectDB().getConnection();
        if(con == null) {
            return -1; // Connection failed !
        }
        
        List<EmployeeVo> employees = new ArrayList<>();
        
        String sql = "UPDATE employees SET name=?, job=?, age=?, gender=? WHERE name=? AND job=? AND age=? AND gender=?;";
        PreparedStatement prest = null;
        try {
            prest = con.prepareStatement(sql);
            prest.setString(1, newEmployee.getName());
            prest.setString(2, newEmployee.getJob());
            prest.setInt(3, newEmployee.getAge());
            prest.setBoolean(4, newEmployee.getGender());
            prest.setString(5, oldEmployee.getName());
            prest.setString(6, oldEmployee.getJob());
            prest.setInt(7, oldEmployee.getAge());
            prest.setBoolean(8, oldEmployee.getGender());
            prest.executeUpdate();
            
        } catch(SQLException se) {
            System.out.println("SQLException(editEmplyees): " + se.getMessage());
            return 1;
        }

        return 0;
    }
    
}
