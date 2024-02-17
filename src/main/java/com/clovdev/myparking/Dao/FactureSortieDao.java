package com.clovdev.myparking.Dao;

import com.clovdev.myparking.Dao.TypeVehiculeDao;
import com.clovdev.myparking.Dao.db_Mysql;
import com.clovdev.myparking.models.Facture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FactureSortieDao {

   private List<Facture> factureList = null;


    public static String insererDansBD(Facture facture) {
        String info;

      /*  int i= db_Mysql.updateBD("START TRANSACTION; \n"+" insert into facturesortie (idFacture,plaque, nomClient," +
                " permis, identite, telephone,localDateTime,prix,typeVehicule) values" +
                "("+facture.getIdFacture()+"," +
                "'"+facture.getPlaque()+"','"+facture.getNom()+"','"+facture.getPermis()+"','"+facture.getIdentite()+"','"+facture.getTelephone()+"'," +
                "'"+ facture.getLocalDateTime() +"',"+facture.getPrix()+",'"+facture.getTypeVehicule().getNom()+"');\n"+
                " delete  from facture where idFacture ="+facture.getIdFacture()+";\n"+"COMMIT TRANSACTION;");*/


        int i= db_Mysql.updateBD(" insert into facturesortie (idFacture,plaque, nomClient," +
                " permis, identite, telephone,localDateTime,prix,typeVehicule) values" +
                "("+facture.getIdFacture()+"," +
                "'"+facture.getPlaque()+"','"+facture.getNom()+"','"+facture.getPermis()+"','"+facture.getIdentite()+"','"+facture.getTelephone()+"'," +
                "'"+ facture.getLocalDateTime() +"',"+facture.getPrix()+",'"+facture.getTypeVehicule().getNom()+"')");
        if(i>0){
            db_Mysql.updateBD("delete from facture where idFacture ="+facture.getIdFacture()+"");
            info="FACTURE SORTIE !!!!!!";
        }else info="ECHEC  !!!!!";
        return info;
    }




    public static ObservableList<Facture> getFacturesByMotCle(String idfacture) throws SQLException {
        ObservableList<Facture> observableList = FXCollections.observableArrayList();




        ResultSet resultSet = db_Mysql.interrogerBD("select * from facturesortie where idFacture like '%"+idfacture+"%'");
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


