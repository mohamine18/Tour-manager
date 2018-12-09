/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Goto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;
import cet.Trips.TripTable;
import cet.auth;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class TripListController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Button BTSelect;
    @FXML
    private Button BTCancel;
    @FXML
    private TableColumn<TripTable, String> TripNameCol;
    @FXML
    private TableColumn<TripTable, String> TripDateCol;
    @FXML
    private TableView<TripTable> TripTable;
    
    private ObservableList<TripTable> data ;
    private static  String IDtrip = null;
    private static String Tripname = null;
    private static String TripPrice = null;
    private static String TripShort = null;
    public String getMyName() {
        return Tripname;    
    }
    public String getMyID() {
        return IDtrip;    
    }
    public String getTripPrice() {
        return TripPrice;    
    }
    public String getTripShort() {
        return TripShort;    
    }
    public void setMyID(String ID1) {
        this.IDtrip = ID1;
    }
    public void setTripPrice(String tripprice) {
        this.TripPrice = tripprice;
    }
    public void setMyName(String tripname) {
        this.Tripname = tripname;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT * FROM trips where statu = 'Active'"; //idtrip, tripname, triptype, price, tripdate
            ResultSet rs = st.executeQuery(query);
            data = FXCollections.observableArrayList();
            while (rs.next())
            {
                String days = rs.getString(5).substring(8,10);
                String month = rs.getString(5).substring(5,7);
                String year = rs.getString(5).substring(0, 4);
                String DBdate = year+month+days ;
                if (Integer.parseInt((dateFormat.format(date)))< Integer.parseInt(DBdate)){
                data.add(new TripTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                ));
                }  
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TripNameCol.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        TripDateCol.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        TripTable.setItems(data);
    }    

    @FXML
    private void SelectPressed(ActionEvent event) throws IOException {
        if (TripTable.getSelectionModel().isEmpty()==false){
        TripTable Trips = TripTable.getSelectionModel().getSelectedItem();
        IDtrip = Trips.getTripID();
        Tripname = Trips.getTripeName();
        TripPrice = Trips.getTripPrice();
        TripShort = Trips.getShortname();
       Stage appstage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage2.close();
        
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Goto/AddGoto.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Hiker");
        appstage.show();
        }
    }

    @FXML
    private void CancelPressed(ActionEvent event) throws IOException {
        Stage appstage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage1.close();
        
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Goto/AddGoto.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Hiker");
        appstage.show();
    }
    
}
