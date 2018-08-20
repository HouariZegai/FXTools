package com.houarizegai.javafxtools.management.model1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    // DB Infos
    private final static String HOST_NAME = "127.0.0.1";
    private final static String PORT_NUMBER = "3306";
    private final static String DB_NAME = "employees_db";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    private static Connection con = null;
    
    public Connection getConnection() {
        if(con != null) { // Already connected 
            return con;
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 
            con = DriverManager.getConnection("jdbc:mysql://" + HOST_NAME + ((PORT_NUMBER.isEmpty()) ? "" : ":" + PORT_NUMBER) + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found Error !");
            return null;
        } finally {
            if (con == null) {
                System.out.println("Connection Failed !");
            }
        }
        System.out.println("Connected !");
        return con;
    }

}
