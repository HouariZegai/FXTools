package com.houarizegai.javafxtools.reports.java_object_datasource;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class JasperReportDemo {

    public static void main(String[] args) {
		new JasperReportDemo().openReport();
    }

    private void openReport() {
    	try {
	    	String path = "src\\com\\houarizegai\\javafxtools\\reports\\java_object_datasource\\FactureClient.jrxml";
	    	JasperReport jr = JasperCompileManager.compileReport(path);

            Map clientInfo = new HashMap<>();
            clientInfo.put("numClient", "C12000");
            clientInfo.put("nomClient", "Mohammed");
            clientInfo.put("numFac", "F101");

            Map params = new HashMap();
            params.put("client_datasource", clientInfo);
            params.put("produit_datasource", getDataOfReport());

	    	JasperPrint jp = JasperFillManager.fillReport(jr, params, new JREmptyDataSource());
	    	JasperViewer.viewReport(jp, false);
    	} catch(JRException jre) {
			jre.printStackTrace();
    	}
    }

    private List getDataOfReport() {
    	List<Produit> produits = new LinkedList<>();
    	produits.add(new Produit("P1", "Stylo", "10.00", 10));
    	produits.add(new Produit("P2", "Cahier", "150.00", 15));
    	produits.add(new Produit("P3", "Regle", "100.00", 8));
    	produits.add(new Produit("P4", "Sizou", "30.00", 5));

//    	HashMap<String, String> clientData = new HashMap<>();
//    	clientData.put("numClient", "C12000");
//    	clientData.put("nomClient", "Mohammed");
//    	clientData.put("numFac", "F101");
//
//
//        HashMap<String, Object> produit1 = new HashMap<>();
//        produit1.put("produit", "p1");
//        produit1.put("reference", "stylo");
//        produit1.put("prixU", 10.0);
//        produit1.put("qt", 10);
//
//        HashMap<String, Object> produit2 = new HashMap<>();
//        produit2.put("produit", "p1");
//        produit2.put("reference", "stylo");
//        produit2.put("prixU", 10.0);
//        produit2.put("qt", 10);
//
//        HashMap<String, Object> produit3 = new HashMap<>();
//        produit3.put("produit", "p1");
//        produit3.put("reference", "stylo");
//        produit3.put("prixU", 10.0);
//        produit3.put("qt", 10);
//
//    	List<Object> dataSource = new LinkedList<>();
//		dataSource.add(clientData);
//		dataSource.add(produit1);
//		dataSource.add(produit2);
//		dataSource.add(produit3);

    	return produits;
	}

}
