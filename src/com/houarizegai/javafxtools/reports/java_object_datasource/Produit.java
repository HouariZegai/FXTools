package com.houarizegai.javafxtools.reports.java_object_datasource;

public class Produit {
    private String produit;
    private String reference;
    private String prixU;
    private int qt;

    public Produit() {
    }

    public Produit(String produit, String reference, String prixU, int qt) {
        this.produit = produit;
        this.reference = reference;
        this.prixU = prixU;
        this.qt = qt;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPrixU() {
        return prixU;
    }

    public void setPrixU(String prixU) {
        this.prixU = prixU;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }
}
