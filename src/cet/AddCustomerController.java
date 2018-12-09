/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class AddCustomerController implements Initializable {
    ObservableList<String> countrieslist = FXCollections.observableArrayList("Other","Afghanistan","Albania","Algeria","Andorra","Argentina", "Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh"
    ,"Belarus","Belgium","Benin","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina Faso","Burma","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Republic","Chad","Chile","China","Colombia","Comoros","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Côte d’Ivoire","Denmark","Djibouti","Ecuador","Egypt","Equatorial Guinea"
    ,"Estonia","Ethiopia","Fiji","Finland","France","Gabon","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Liberia","Libya","Lithuania","Luxembourg"
    ,"Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mexico","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Namibia","Nepal","Netherlands","New Zealand","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palestin","Panama","Papua New Guinea","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Romania","Russia","Rwanda","Réunion"
    ,"Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Somalia","South Africa","South Korea","Spain","Sri Lanka","Sudan","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tunisia","Turkey","Turkmenistan","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan",
    "Venezuela","Vietnam","Western Sahara","Yemen","Zambia","Zimbabwe");
    ObservableList<String> GenderList = FXCollections.observableArrayList("Male","Female");
    ObservableList<String> yearlist = FXCollections.observableArrayList("1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
 
    @FXML
    private Font x1;
    @FXML
    private TextField AddTFName;
    @FXML
    private TextField AddIDNum;
    @FXML
    private ChoiceBox ChBoxGender;
    @FXML
    private TextField AddPhoneNum;
    @FXML
    private ComboBox ComBoxCountry;
    @FXML
    private Button AddButton;
    @FXML
    private Font x2;
    @FXML
    private Button CancelButton;
    @FXML
    private Label LabelErr;
    ResultSet rs1;
    @FXML
    private ComboBox<String> ChBoxDy;
    @FXML
    private ComboBox<String> ChBoxYear;
    @FXML
    private ComboBox<String> ChBoxMo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChBoxGender.setValue("Male");
        ChBoxGender.setItems(GenderList);
        ComBoxCountry.setValue("China");
        ComBoxCountry.setItems(countrieslist);
        ChBoxDy.setItems(daylist);
        ChBoxMo.setItems(monthlist);
        ChBoxYear.setItems(yearlist);
    }    

    @FXML
    private void CloseStage(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }

    @FXML
    private void AddCustomer(ActionEvent event) throws SQLException {
        if(AddTFName.getText().isEmpty()||AddPhoneNum.getText().isEmpty()){
            LabelErr.setText("Name and Phone N° are Required");
            }else{
                if (AddPhoneNum.getText().length()<11){
                    LabelErr.setText("Wrong Phone Number");
                    }else{
                        String Date1 = ChBoxYear.getValue()+"-"+ChBoxMo.getValue()+"-"+ChBoxDy.getValue();
                        auth cnx = new auth();
                        int value = 0 ;
                        try (Statement st = cnx.connect().createStatement()) {
                            String query = "SELECT idcus FROM customer ORDER BY idcus DESC LIMIT 1";
                            ResultSet rs = st.executeQuery(query);
                            while (rs.next())
                                {
                                value = Integer.parseInt(rs.getString(1));
                                }
                            rs.close();
                            String insertquery = "INSERT INTO customer(idcus, fullname, gender, ppncid, phonecus, country,dob) VALUES ("+(value+1)+",'"+AddTFName.getText().toUpperCase()+"','"+ChBoxGender.getValue()+"','"+AddIDNum.getText()+"','"+AddPhoneNum.getText()+"','"+ComBoxCountry.getValue()+"','"+Date1+"')";
                            st.executeUpdate(insertquery);
                            st.close();
                            LabelErr.setText("Customer Added successfully");
                            AddTFName.clear();
                            AddIDNum.clear();
                            AddPhoneNum.clear();
                            ChBoxYear.setValue(null);
                            ChBoxMo.setValue(null);
                            ChBoxDy.setValue(null);
                            ChBoxGender.setValue("Male");
                            ComBoxCountry.setValue("China");
                        }
                    }
                }
   }       
    
    
}
