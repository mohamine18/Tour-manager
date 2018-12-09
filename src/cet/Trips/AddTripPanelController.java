/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Trips;

import cet.TrippageController;
import cet.auth;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
public class AddTripPanelController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField TFAddTripName;
    @FXML
    private ComboBox<String> ChAddTripType;
    @FXML
    private TextField TFAddTripPrice;
    @FXML
    private ComboBox<String> ChAddTripYear;
    @FXML
    private ComboBox<String> ChAddTripMo;
    @FXML
    private ComboBox<String> ChAddTripDy;
    @FXML
    private Button AddButton;
    @FXML
    private Font x2;
    @FXML
    private Button CancelButton;
    
    ObservableList<String> yearlist = FXCollections.observableArrayList("2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    ObservableList<String> typelist = FXCollections.observableArrayList("One Day","Long Trip","Free Trip");
    /**
     * Initializes the controller class.
     */
    String Dy, Mo,Year = null;
    TrippageController trip = new TrippageController();
    @FXML
    private Label AddTripLabel;
    @FXML
    private TextField TFAddTripPN ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (trip.getTripDate() != null){
//            Dy = trip.getTripDate().substring(8, 10);
            Mo = trip.getTripDate().substring(5, 7);
            Year = trip.getTripDate().substring(0, 4);
        }
        ChAddTripDy.setValue(Dy);
        ChAddTripDy.setItems(daylist);
        
        ChAddTripMo.setValue(Mo);
        ChAddTripMo.setItems(monthlist);
        
        ChAddTripYear.setValue(Year);
        ChAddTripYear.setItems(yearlist);
        
        ChAddTripType.setValue(trip.getTripType());
        ChAddTripType.setItems(typelist);
        
        TFAddTripName.setText(trip.getMyTrip());
        TFAddTripPrice.setText(trip.getTripPrice());
        TFAddTripPN.setText(trip.getShortname());
    }    

    @FXML
    private void AddBTClicked(ActionEvent event) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date1 = new Date();
        String DBdate = ChAddTripYear.getValue()+ChAddTripMo.getValue()+ChAddTripDy.getValue();
        if (TFAddTripName.getText().isEmpty()||TFAddTripPrice.getText().isEmpty()||ChAddTripYear.getValue()==null||ChAddTripMo.getValue()==null||ChAddTripDy.getValue()==null||ChAddTripType.getValue()==null||TFAddTripPN.getText().isEmpty()){
            AddTripLabel.setText("All Fields are Required");
        }else{
            if(Integer.parseInt((dateFormat.format(date1))) >= Integer.parseInt(DBdate)){
                AddTripLabel.setText("You can't create trip in past time");
            }else{
                auth cnx = new auth();
                int value = 0 ;
                try (Statement st = cnx.connect().createStatement()) {
                    String query = "SELECT idtrip FROM trips ORDER BY idtrip DESC LIMIT 1";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next())
                        {
                        value = Integer.parseInt(rs.getString(1));
                        }
                    String date = ChAddTripYear.getValue()+"-"+ChAddTripMo.getValue()+"-"+ChAddTripDy.getValue();
                    String insertquery = "INSERT INTO trips (idtrip, tripname, triptype, price, tripdate, statu, shortname) VALUES ("+(value+1)+",'"+TFAddTripName.getText()+"','"+ChAddTripType.getValue()+"','"+TFAddTripPrice.getText()+"','"+date+"','Active','"+TFAddTripPN.getText()+"')";
                    st.executeUpdate(insertquery);
                    String insertleadquery = "INSERT INTO lead(idtrip)VALUES ("+(value+1)+")";
                    st.executeUpdate(insertleadquery);
                    st.close();
                    rs.close();
                }
                AddTripLabel.setText("Trip Added successfully");
                TFAddTripName.clear();
                TFAddTripPrice.clear();
                TFAddTripPN.clear();
                ChAddTripDy.setValue(null);
                ChAddTripMo.setValue(null);
                ChAddTripYear.setValue(null);
                ChAddTripType.setValue(null);
            }
                        
       }
    }

    @FXML
    private void CancelBTClicked(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }
    
}
