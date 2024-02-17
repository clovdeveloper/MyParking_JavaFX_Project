package com.clovdev.myparking.Dao;

import com.clovdev.myparking.models.Facture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FactureDao {

   private List<Facture> factureList = null;


    public static String insererDansBD(Facture facture) {
        String info;

        int i= db_Mysql.updateBD("insert into facture (idFacture,plaque, nomClient, permis, identite, telephone,localDateTime,prix,typeVehicule) values" +
                "("+facture.getIdFacture()+"," +
                "'"+facture.getPlaque()+"','"+facture.getNom()+"','"+facture.getPermis()+"','"+facture.getIdentite()+"','"+facture.getTelephone()+"'," +
                "'"+ facture.getLocalDateTime() +"',"+facture.getPrix()+",'"+facture.getTypeVehicule().getNom()+"')");
        if(i>0){
            info="Facture Ajouté !!!!!!";
        }else info="Echec d'Enregistrement !!!!!";
        return info;
    }

    public static Facture getFactureByPlaque(String plaque){
        Facture facture=null;
        ResultSet res = db_Mysql.interrogerBD("select plaque,nomclient,permis,identite,telephone from facture where plaque ='"+plaque+"'");
       if (res!=null){
           while (true){
               try {
                   if (!res.next()) break;
                   facture=new Facture(res.getString("plaque"), res.getString("nomclient"),
                           res.getString("permis"),res.getString("identite"),res.getString("telephone"));
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }

           }
       }
        return facture;
    }

   /* public static ObservableList<Facture> getFactures() throws SQLException {
        ObservableList<Facture> observableList = FXCollections.observableArrayList();




        ResultSet resultSet = db_Mysql.interrogerBD("select * from facture ");
        if(resultSet!=null){
            while (true){
                try {
                    if (!resultSet.next()) break;

                    Facture facture = new Facture(resultSet.getInt("id"),resultSet.getInt("idFacture"),resultSet.getString("plaque"),
                            resultSet.getString("nomClient"),resultSet.getString("permis"),resultSet.getString("identite"),resultSet.getString("telephone")
                            ,resultSet.getString("localDateTime"),resultSet.getDouble("prix"),
                            TypeVehiculeDao.getTypeVehiculeById(resultSet.getString("typeVehicule")));

                    observableList.addAll(facture);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            return observableList;
        }


     return null;
    }*/
    public static ObservableList<Facture> getFacturesByMotCle(String idfacture) throws SQLException {
        ObservableList<Facture> observableList = FXCollections.observableArrayList();




        ResultSet resultSet = db_Mysql.interrogerBD("select * from facture where idFacture like '%"+idfacture+"%'");
        if(resultSet!=null){
            while (true){
                try {
                    if (!resultSet.next()) break;

                    Facture facture = new Facture(resultSet.getInt("id"),resultSet.getInt("idFacture"),resultSet.getString("plaque"),
                            resultSet.getString("nomClient"),resultSet.getString("permis"),resultSet.getString("identite"),resultSet.getString("telephone")
                            ,resultSet.getString("localDateTime"),resultSet.getDouble("prix"),
                            TypeVehiculeDao.getTypeVehiculeById(resultSet.getString("typeVehicule")));

                    observableList.addAll(facture);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            return observableList;
        }


        return null;
    }
}


