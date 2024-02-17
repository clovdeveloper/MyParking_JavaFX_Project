package com.clovdev.myparking.Controller;
import com.clovdev.myparking.Dao.db_Mysql;
import com.clovdev.myparking.Factory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField password;

    @FXML
    private Button loginBtn;


    @FXML
    private Button cancelBtn;

    @FXML
    private TextField username;


    void initialiserFiels(){
        username.setText("");
        password.setText("");
    }
    private void showAlert(String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    void seConnecter(ActionEvent event) {

        String usernamee = username.getText();
        String passwordd = password.getText();
        String requete ="select user_role.role from roles inner join(user_role inner join  user on user.username = user_role.user) on  user_role.role = roles.nom   where user.username='"+usernamee+"'and user.password='"+passwordd+"'";
        ResultSet res= db_Mysql.interrogerBD(requete);


        try {
            if(res.next())
            {
                if(res.getString("role").equals("ADMIN")){

                    Factory.showStage("admin");
                   Factory.closeStage(event);

                }

                else if(res.getString("role").equals("USER")){

                    Factory.showStage("user");
                    Factory.closeStage(event);



                }

            }
            else
            {
             showAlert("Password or Username Incorrect !!!!!!!!!!", Alert.AlertType.ERROR);
                password.setText("");
                username.setText("");
            }
        } catch (Exception ex) {
         showAlert(ex.getMessage(), Alert.AlertType.ERROR);

        }
    }

    @FXML
    void exit(ActionEvent event) {
      //  System.exit(0);
        Platform.exit();

    }

 /*   @FXML
    protected void onHelloButtonClick() {


        welcomeText.setText("Welcome to JavaFX Application!");
        Node node = new Circle(100, 200, 200);
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }
    }*/
}