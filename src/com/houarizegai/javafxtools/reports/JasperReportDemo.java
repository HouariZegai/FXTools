package com.houarizegai.javafxtools.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JasperReportDemo {
    public static void main(String[] args) {
		openReport();
    }

    public static void openReport() {
    	try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/gestioncommercialdb", "root", "");

	    	String path = "src\\com\\houarizegai\\javafxtools\\reports\\Blank_A4.jrxml";
	    	JasperReport jr = JasperCompileManager.compileReport(path);
	    	JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
	    	JasperViewer.viewReport(jp, false);

	    	con.close();
    	} catch(JRException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
    	}

    }
}
