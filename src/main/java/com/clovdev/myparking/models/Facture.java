package com.clovdev.myparking.models;

public class Facture {

    private int id;
    private int idFacture;

    private String plaque, nom, permis, identite, telephone;
    String localDateTime;
    private double prix;

    private TypeVehicule typeVehicule;

    public Facture(String plaque, String nom, String permis, String identite, String telephone) {
        this.plaque = plaque;
        this.nom = nom;
        this.permis = permis;
        this.identite = identite;
        this.telephone = telephone;


    }

    public Facture(int idFacture, String plaque, String nom, String permis, String identite, String telephone, String localDateTime, double prix, TypeVehicule typeVehicule) {
        this.idFacture = idFacture;
        this.plaque = plaque;
        this.nom = nom;
        this.permis = permis;
        this.identite = identite;
        this.telephone = telephone;
        this.localDateTime = localDateTime;
        this.prix = prix;
        this.typeVehicule = typeVehicule;
    }

    public Facture(int id, int idFacture, String plaque, String nom, String permis, String identite, String telephone, String localDateTime, double prix, TypeVehicule typeVehicule) {
        this.id = id;
        this.idFacture = idFacture;
        this.plaque = plaque;
        this.nom = nom;
        this.permis = permis;
        this.identite = identite;
        this.telephone = telephone;
        this.localDateTime = localDateTime;
        this.prix = prix;
        this.typeVehicule = typeVehicule;
    }

    public Facture() {
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }
}