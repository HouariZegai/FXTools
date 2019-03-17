package com.houarizegai.javafxtools.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JasperReportDemo {
	private static Connection con;

    public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/gestioncommercialdb", "root", "");
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		//openReport();
		openReportWithQuery();

		try {
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
    }

    public static void openReport() {
    	try {
	    	String path = "src\\com\\houarizegai\\javafxtools\\reports\\AccountReport.jrxml";
	    	JasperReport jr = JasperCompileManager.compileReport(path);
	    	JasperPrint jp = JasperFillManager.fillReport(jr, null, JasperReportDemo.con);
	    	JasperViewer.viewReport(jp, false);
    	} catch(JRException jre) {
			jre.printStackTrace();
    	}

    }

	public static void openReportWithQuery() {
		try {
			String path = "src\\com\\houarizegai\\javafxtools\\reports\\AccountReport.jrxml";
			JasperDesign jd = JRXmlLoader.load(path); // Load design of report (jrxml file)

			String sql = "SELECT * FROM login WHERE NomUtilisateur = 'Houari';";
			JRDesignQuery designQuery = new JRDesignQuery();
			designQuery.setText(sql);

			jd.setQuery(designQuery);

			JasperReport jr = JasperCompileManager.compileReport(jd);
			JasperPrint jp = JasperFillManager.fillReport(jr, null, JasperReportDemo.con);
			JasperViewer.viewReport(jp, false);

		} catch(JRException jre) {
			jre.printStackTrace();
		}

	}
}
