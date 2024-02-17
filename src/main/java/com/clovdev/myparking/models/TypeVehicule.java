package com.clovdev.myparking.models;

public class TypeVehicule {
    private String nom;
    private double prix;

    public TypeVehicule(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }
    public TypeVehicule(String nom) {
        this.nom = nom;
        this.prix =0;
    }

    @Override
    public String toString() {
        if(this.prix == 0)
            return nom;
        return "" + nom + ",  prix=" + prix ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
