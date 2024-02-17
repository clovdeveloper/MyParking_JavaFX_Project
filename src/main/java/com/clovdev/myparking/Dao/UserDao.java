package com.clovdev.myparking.Dao;


import com.clovdev.myparking.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao{


    List<User> userList;
    public static String insererDansBD(User user) {
        String info;
        int i= db_Mysql.updateBD("insert into user (username,password,role) values('"+user.getUsername()+"'," +
                "'"+user.getPassword()+"','"+user.getRole()+"')");
        if(i>0){
            info="Utilisateur Ajouté !!!!!!";
        }else info="Echec d'Enregistrement !!!!!";
        return info;
    }
    public static String modifierUtilisateur(User user) {
        String info;
        int i= db_Mysql.updateBD("update user set password='"+user.getPassword()+"' , role='"+user.getRole()+"'where username ='"+user.getUsername()+"'") ;


        if(i>0){
            info="Utilisateur Modifié !!!!!!";
        }else info="Echec de Modification !!!!!";
        return info;
    }

    public static String supprimerUtilisateur(User user) {
        String info;
        int i= db_Mysql.updateBD("delete from user where username='"+user.getUsername()+"'") ;

        if(i>0){
            info="Utilisateur Supprimé !!!!!!";
        }else info="Echec de Suppression !!!!!";
        return info;
    }

    public static ObservableList<User> getUsers() throws SQLException {
        ObservableList<User> observableList = FXCollections.observableArrayList();



        ResultSet resultSet = db_Mysql .interrogerBD("select * from user ");
        if (resultSet != null) {

            while (true) {
                try {
                    if (!resultSet.next()) break;

                    observableList.addAll(new User( resultSet.getString("username"),
                            resultSet.getString("password"), resultSet.getString("role")));
                    System.out.println("yessssssssssssssssssssssssssssss");
                } catch (SQLException e) {
                    //throw new RuntimeException(e);
                }

            }
            return observableList;
        }
        return null;


    }
    }
