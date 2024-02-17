package com.clovdev.myparking.Controller;

import com.clovdev.myparking.Dao.FactureDao;
import com.clovdev.myparking.Dao.TypeVehiculeDao;
import com.clovdev.myparking.Dao.UserDao;
import com.clovdev.myparking.models.Facture;
import com.clovdev.myparking.Dao.FactureSortieDao;
import com.clovdev.myparking.models.TypeVehicule;
import com.clovdev.myparking.models.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;


public class UserController implements Initializable {


   /* @FXML
    private ComboBox role;
*/
   /* @FXML
    private Button submit;
*/


  /*  @FXML
    private Button supprimerbtn;
*/


   /* @FXML
    private TableColumn passwordTable1;
*/


   /* @FXML
    private TableColumn roleTable1;
*/


 /*   @FXML

    private TableColumn usernameTable1;

    @FXML
    private PasswordField password;

    @FXML
    private Button modifybtn;

    @FXML
    private TableColumn passwordTable;

    @FXML
    private TableColumn roleTable;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn usernameTable;
*/



  /*  @FXML
    private TextField username;
*/

    // *****************************************************CODE CONCERNANT UN UTILISATEUR SEULEMENT******************************************************************
 /*   private User selectedUser=null;




    @FXML
    private void modifyUser(){

        if(selectedUser!=null){
            selectedUser.setRole(role.getSelectionModel().getSelectedItem().toString());
            String info = UserDao.modifierUtilisateur(selectedUser);
            chargerUserTable();
            showAlert(info, Alert.AlertType.INFORMATION);


        }

    }
    @FXML
    private void supprimerUser(){

        if(selectedUser!=null){
            String info = UserDao.supprimerUtilisateur(selectedUser);
            chargerUserTable();
            showAlert(info, Alert.AlertType.INFORMATION);

        }

    }
*/


   /* @FXML
    public void enregisterUser(){

      String info=  UserDao.insererDansBD(new User(username.getText(),password.getText(),role.getSelectionModel().getSelectedItem().toString()));
      chargerUserTable();
       initialiser();
       showAlert(info, Alert.AlertType.INFORMATION);
    }

    private void initialiser(){
        username.setText("");
        password.setText("");
        role.getSelectionModel().clearSelection();
    }

    @FXML
    private void selectUser(){

        int s = tableUsers.getSelectionModel().getSelectedIndex();
        if(s-1< -1)
            return;
        selectedUser=tableUsers.getSelectionModel().getSelectedItem();
        username.setText(selectedUser.getUsername());
        password.setText(selectedUser.getPassword());
        role.getSelectionModel().clearSelection();




    }


    private void chargeRoles(){
        ObservableList<String> observableList = FXCollections.observableArrayList(List.of("ADMIN","USER"));
        role.setItems(observableList);

    }

    private void chargerUserTable(){


        roleTable.setCellValueFactory(new PropertyValueFactory<>("role"));
        usernameTable.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordTable.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            tableUsers.setItems(UserDao.getUsers());
        } catch (SQLException e) {
           showAlert(e.getMessage(), Alert.AlertType.ERROR);
        }
    }*/
//*****************************************************************************************************************************************************************************

 //  ********************************************************************* //CODE CONCERNANT TYPE DE VEHICULE*****************************************************************


//  ***************************************************************************************************************************************************************************


    @FXML
    private TableView<TypeVehicule> tableTypeVehicule;
    @FXML
    private TextField prix;

    @FXML
    private TextField type;
@FXML
private Button submitTypeVehiculeBtn;
@FXML
private Button supprimerbtnTypeVehicule;
@FXML
private Button modifybtnTypeVehicule;
    @FXML
    TableColumn typevehiculeTypeCol;
    @FXML
    TableColumn typeVehiculePrixCol;


    private TypeVehicule selectedTypeVehicule;
    private void showAlert(String message,Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }
    @FXML
    private void modifyTypeVehicule(){

        if(selectedTypeVehicule!=null){

            String info = TypeVehiculeDao.modifierTypeVehicule(selectedTypeVehicule);
            chargerTypeVehiculeTable();
            showAlert(info, Alert.AlertType.INFORMATION);

        }

    }
    @FXML
    private void supprimerTypeVehicule(){

        if(selectedTypeVehicule!=null){
            String info = TypeVehiculeDao.supprimerTypeVehicule(selectedTypeVehicule);
           chargerTypeVehiculeTable();
            showAlert(info, Alert.AlertType.INFORMATION);

        }

    }



    @FXML
    public void enregisterTypeVehicule(){

        String info=  TypeVehiculeDao.insererTypeVehicule(new TypeVehicule(type.getText(),Double.valueOf(prix.getText())));
       chargerTypeVehiculeTable();
        loadTypeVehiculeCombobox();

     initialiserTypeVehiculeFiels();
        showAlert(info, Alert.AlertType.INFORMATION);
    }

    private void initialiserTypeVehiculeFiels(){
        type.setText("");
        prix.setText("");

    }

    @FXML
    private void selectType(){

        int s = tableTypeVehicule.getSelectionModel().getSelectedIndex();
        if(s-1< -1)
            return;
        selectedTypeVehicule=  tableTypeVehicule.getSelectionModel().getSelectedItem();
        type.setText(selectedTypeVehicule.getNom());
        prix.setText(String.valueOf(selectedTypeVehicule.getPrix()));




    }

    private void chargerTypeVehiculeTable(){

        typeVehiculePrixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        typevehiculeTypeCol.setCellValueFactory(new PropertyValueFactory<>("nom"));


        try {
            tableTypeVehicule.setItems(TypeVehiculeDao.getTypeVehicules());

        } catch (Exception e) {
          showAlert(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    //*********************************************************************  CONCERNANT FACTURE ************************************************************************


    @FXML
    ComboBox<TypeVehicule> factureTypeVehiculeCombobox;
    @FXML
    TextField facturePlaque;
    @FXML
    TextField facturePermis;
    @FXML
    TextField factureNomEtPrenom;
    @FXML
    TextField factureIdentite;
    @FXML
    TextField factureTelephone;
    @FXML
   TextField facturePrix;

    private TypeVehicule selectedTypeVehiculeOnFacture =null;


    @FXML
    TableColumn factureidCol;
    @FXML
    TableColumn factureIdFactureCol;
    @FXML
    TableColumn factureplaqueCol;
    @FXML
    TableColumn factureNomPrenomCol;
    @FXML
    TableColumn facturePremisCol ;
    @FXML
    TableColumn factureIdentiteCol ;
    @FXML
    TableColumn factureTelephoneCol ;
    @FXML
    TableColumn factureLocalTimeCol;
    @FXML
    TableColumn factureTypeVehiculeCol;
    @FXML
    TableColumn facturePrixCol;






    @FXML
    TableView TableFacture;
    @FXML
    TextField factureSearch;

    @FXML
    private void selectTypeVehiculeOnFacture(){


        selectedTypeVehicule = factureTypeVehiculeCombobox.getSelectionModel().getSelectedItem();
        facturePrix.setText((int)selectedTypeVehicule.getPrix()+"");


    }



    private void addComboItemSelectedListener(){
            factureTypeVehiculeCombobox.valueProperty().addListener(new ChangeListener<TypeVehicule>() {
            @Override
            public void changed(ObservableValue<? extends TypeVehicule> observableValue, TypeVehicule typeVehicule, TypeVehicule t1) {
                selectTypeVehiculeOnFacture();
            }
        });

    }
    private void loadTypeVehiculeCombobox(){
        TypeVehiculeDao.Loading_Type_Vehicule(factureTypeVehiculeCombobox);
    }

    @FXML
    private void saveFacture(){
        String date;
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy   HH:mm");
        date=localDateTime.format(formatter);

        int idfacture = (int) (Math.random()*(2100000000-100000+1)+100000);
       String info = FactureDao.insererDansBD(new Facture(idfacture,facturePlaque.getText(),factureNomEtPrenom.getText(), facturePermis.getText(), factureIdentite.getText()
               , factureTelephone.getText(), date, Double.valueOf(facturePrix.getText()), selectedTypeVehicule));
        chargerTableFacture("");
        initializeFacture();
       showAlert(info, Alert.AlertType.INFORMATION);
    }

    private void chargerTableFacture(String keyWord){

         factureidCol.setCellValueFactory(new PropertyValueFactory<>("id"));
         factureIdFactureCol.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
       factureplaqueCol.setCellValueFactory(new PropertyValueFactory<>("plaque"));
       factureNomPrenomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
       facturePremisCol.setCellValueFactory(new PropertyValueFactory<>("permis")) ;
     factureIdentiteCol.setCellValueFactory(new PropertyValueFactory<>("identite")) ;
        factureTelephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone")) ;
      factureLocalTimeCol.setCellValueFactory(new PropertyValueFactory<>("localDateTime"));
     factureTypeVehiculeCol.setCellValueFactory(new PropertyValueFactory<>("typeVehicule"));
      facturePrixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));



        try {
            TableFacture.setItems(FactureDao.getFacturesByMotCle(keyWord));

        } catch (Exception e) {
            showAlert(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void searchFactureByKeyWord(){
        String keyword = factureSearch.getText().trim();
        chargerTableFacture(keyword);




    }

    private Facture selectedFacture=null;
    @FXML
    private void selectFacture(){


        int s = TableFacture.getSelectionModel().getSelectedIndex();
        if(s-1< -1)
            return;
        selectedFacture= (Facture) TableFacture.getSelectionModel().getSelectedItem();


    }

    private void initializeFacture(){

        facturePrix.setText("");
        factureTypeVehiculeCombobox.getSelectionModel().clearSelection();
        factureplaqueCol.setText("");
        factureNomPrenomCol.setText("");
        facturePremisCol.setText("");
        factureIdentiteCol.setText("");
        factureTelephoneCol.setText("");



    }
    Facture factureLoaded=null;
    @FXML
    private void initializeFactureByKeyPressedPlaque(){

        factureLoaded = FactureDao.getFactureByPlaque(facturePlaque.getText());

        if(factureLoaded!=null){

            factureTypeVehiculeCombobox.getSelectionModel().clearSelection();

          factureNomEtPrenom.setText(factureLoaded.getNom());
          facturePermis.setText(factureLoaded.getPermis());
           factureIdentite.setText(factureLoaded.getIdentite());
         factureTelephone.setText(factureLoaded.getTelephone());
          // JRDesignViewer jrDesignViewer;


        }



    }



    //*********************************************************************  CONCERNANT FACTURE SORTIE ************************************************************************




    @FXML
    TableColumn factureidCol1;
    @FXML
    TableColumn factureIdFactureCol1;
    @FXML
    TableColumn factureplaqueCol1;
    @FXML
    TableColumn factureNomPrenomCol1;
    @FXML
    TableColumn facturePremisCol1 ;
    @FXML
    TableColumn factureIdentiteCol1 ;
    @FXML
    TableColumn factureTelephoneCol1 ;
    @FXML
    TableColumn factureLocalTimeCol1;
    @FXML
    TableColumn factureTypeVehiculeCol1;
    @FXML
    TableColumn facturePrixCol1;






    @FXML
    TableView TableFacture1;
    @FXML
    TextField factureSearch1;



    @FXML
    private void saveFactureSortie(){

        if(selectedFacture!=null){
            String date;
            LocalDateTime localDateTime=LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm");
            date=localDateTime.format(formatter);


            String info = FactureSortieDao.insererDansBD(new Facture(selectedFacture.getIdFacture(),selectedFacture.getPlaque(),selectedFacture.getNom(),
                    selectedFacture.getPermis(), selectedFacture.getIdentite()
                    , selectedFacture.getTelephone(), date, selectedFacture.getPrix(), selectedFacture.getTypeVehicule()));
            chargerTableFacture("");
            chargerTableFactureSortie("");

            showAlert(info, Alert.AlertType.INFORMATION);
        }
        else showAlert("Veuillez d'abord selectionnez la facture   !", Alert.AlertType.ERROR);

    }

    private void chargerTableFactureSortie(String keyWord){

        factureidCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        factureIdFactureCol1.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        factureplaqueCol1.setCellValueFactory(new PropertyValueFactory<>("plaque"));
        factureNomPrenomCol1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        facturePremisCol1.setCellValueFactory(new PropertyValueFactory<>("permis")) ;
        factureIdentiteCol1.setCellValueFactory(new PropertyValueFactory<>("identite")) ;
        factureTelephoneCol1.setCellValueFactory(new PropertyValueFactory<>("telephone")) ;
        factureLocalTimeCol1.setCellValueFactory(new PropertyValueFactory<>("localDateTime"));
        factureTypeVehiculeCol1.setCellValueFactory(new PropertyValueFactory<>("typeVehicule"));
        facturePrixCol1.setCellValueFactory(new PropertyValueFactory<>("prix"));



        try {
            TableFacture1.setItems(FactureSortieDao.getFacturesByMotCle(keyWord));

        } catch (Exception e) {
            showAlert(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void searchFactureByKeyWord1(){
        String keyword = factureSearch1.getText().trim();
        chargerTableFactureSortie(keyword);

    }








 /*   private void printFacture(){

        JasperDesign jasperDesign = JRXmlLoader.load("");

    }
*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addComboItemSelectedListener();
        chargerTableFacture("");
        loadTypeVehiculeCombobox();
        chargerTypeVehiculeTable();
        chargerTableFactureSortie("");
    /*    chargeRoles();
        chargerUserTable();*/


    }
}
