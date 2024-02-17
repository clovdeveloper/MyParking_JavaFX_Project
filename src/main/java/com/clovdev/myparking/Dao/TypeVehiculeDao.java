package com.clovdev.myparking.Dao;


import com.clovdev.myparking.models.TypeVehicule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeVehiculeDao {


    public static ObservableList<TypeVehicule> getTypeVehicules() throws SQLException {
        ObservableList<TypeVehicule> observableList = FXCollections.observableArrayList();



        ResultSet resultSet = db_Mysql.interrogerBD("select * from typevehicule ");
        if (resultSet != null) {

            while (true) {
                try {
                    if (!resultSet.next()) break;

                    observableList.addAll(new TypeVehicule( resultSet.getString("nom"),
                            resultSet.getDouble("prix")));
                    System.out.println("yesssssss typeeeeeee");
                } catch (SQLException e) {
                    //throw new RuntimeException(e);
                }

            }
            return observableList;
        }
        return null;


    }
    public static TypeVehicule getTypeVehiculeById(String nom){

        ResultSet result= db_Mysql.interrogerBD("select nom from typeVehicule where nom='"+nom+"'");

        if(result!=null) {
            try {
                if (result.next())
                    return new TypeVehicule(result.getString("nom"));
            } catch (SQLException ex) {

            }
        }
        return null;


    }
    public static void Loading_Type_Vehicule(ComboBox comboBox){

        List<TypeVehicule> typeVehiculeList =null;

        ResultSet result= db_Mysql.interrogerBD("select * from typeVehicule");

        comboBox.getItems().removeAll();

        if(result!=null)
        {
            typeVehiculeList=new ArrayList<>();
            try {
                while(result.next()) {
                   typeVehiculeList.add(new TypeVehicule(result.getString("nom"), result.getDouble("prix")));
                }
            } catch (SQLException ex) {

            }
            ObservableList<TypeVehicule> observableList = FXCollections.observableArrayList(typeVehiculeList);
            comboBox.setItems(observableList);
        }
    }


    public static String insererTypeVehicule(TypeVehicule typeVehicule) {
        String info;
        int i= db_Mysql.updateBD("insert into typevehicule (nom,prix) values('"+typeVehicule.getNom()+"'," +
                ""+typeVehicule.getPrix()+")");
        if(i>0){
            info="TypeVehicule  Ajouté !!!!!!";
        }else info="Echec d'Enregistrement !!!!!";
        return info;
    }
    public static String modifierTypeVehicule(TypeVehicule typeVehicule) {
        String info;
        int i= db_Mysql.updateBD("update typevehicule set nom="+typeVehicule.getNom()+"," +
                " prix="+typeVehicule.getPrix()+"where nom ='"+typeVehicule.getNom()+"'") ;

        if(i>0){
            info="Utilisateur Modifié !!!!!!";
        }else info="Echec de Modification !!!!!";
        return info;
    }

    public static String supprimerTypeVehicule(TypeVehicule typeVehicule) {
        String info;
        int i= db_Mysql.updateBD("delete from typevehicule where nom='"+typeVehicule.getNom()+"'") ;

        if(i>0){
            info="TypeVehicule Supprimé !!!!!!";
        }else info="Echec de Suppression !!!!!";
        return info;
    }

}
