/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet;

import cet.Goto.*;
import cet.Goto.TripListController;
import cet.Trips.TripTable;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class TrippageController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @FXML
    private Button Cus;
    @FXML
    private Font x1;
    @FXML
    private Insets x2;

    @FXML
    private TableColumn<TripTable, String> UpDate;
    @FXML
    private TableColumn<TripTable, String> UpPrice;
    @FXML
    private TableColumn<TripTable, String> OneName;
    @FXML
    private TableColumn<TripTable, String> OneDate;
    @FXML
    private TableColumn<TripTable, String> OnePrice;
    @FXML
    private TableColumn<TripTable, String> LongName;
    @FXML
    private TableColumn<TripTable, String> LongDate;
    @FXML
    private TableColumn<TripTable, String> LongPrice;
    @FXML
    private TableColumn<TripTable, String> FreeName;
    @FXML
    private TableColumn<TripTable, String> FreeDate;
    @FXML
    private TableColumn<TripTable, String> FreePrice;
    @FXML
    private TableColumn<TripTable, String> UpName1;
    @FXML
    private TableView<TripTable> UpTable;
    @FXML
    private TableView<TripTable> OneTable;
    @FXML
    private TableView<TripTable> LongTable;
    @FXML
    private TableView<TripTable> FreeTable;
    
    private ObservableList<TripTable>updata ;
    private ObservableList<TripTable>onedata ;
    private ObservableList<TripTable>longdata ;
    private ObservableList<TripTable>freedata ;
    
    
    @FXML
    private Font x5;
    @FXML
    private Insets x4;
    @FXML
    private TextField TFtripeName;
    @FXML
    private TextField TFTripPrice;
    @FXML
    private ComboBox<String> ChTripYear;
    @FXML
    private ComboBox<String> ChTripMo;
    @FXML
    private ComboBox<String> ChTripDy;
    @FXML
    private Button BTConfirmEdit;
    @FXML
    private Font x3;
    @FXML
    private Button BTDeleteTrip;
    
    ObservableList<String> yearlist = FXCollections.observableArrayList("2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    ObservableList<String> typelist = FXCollections.observableArrayList("One Day","Long Trip","Free Trip");
    ObservableList<String> PMlist = FXCollections.observableArrayList("Wechat","Alipay","Cash");
    ObservableList<String> MPlist = FXCollections.observableArrayList("LiangmaqiaoSubway station","South gate of UIBE","Weigongcun Subway station","South gate of BLCU");
    
    @FXML
    private Button LoadTrips;
    @FXML
    private Button AddTrip;
    @FXML
    private Button EditTrip;
    @FXML
    private Label TripLabel;    
    @FXML
    private ComboBox<String> ChTripType;
    
    private static String IDtrip = null;
    private static String TripName = null;
    private static String TripType = null;
    private static String TripPrice = null;
    private static String TripDate = null;
    private static String Tripshort = null;
    private static String AppSat = null;
    private static String GotoTripID = null;
    private static String GotoCusID = null;
    private static String GotoCusName = null;
    
    @FXML
    private Button LoadHikers;
    @FXML
    private Button AddHiker;
    @FXML
    private Button EditHiker;
    @FXML
    private Button BTConfirmHikEdit;
    @FXML
    private Button BTDeleteHike;
    @FXML
    private TableColumn<HikerTable, String> HikerName;
    @FXML
    private TableColumn<HikerTable, String> HikerPhone;
    @FXML
    private TableColumn<HikerTable, String> HikerMP;
    @FXML
    private TableColumn<HikerTable, String> HikerAmount;
    @FXML
    private TableColumn<HikerTable, String> HikerPM;
    @FXML
    private TableColumn<HikerTable,String> HikerPN;
    @FXML
    private TableView<HikerTable> HikersTable;
    private ObservableList<HikerTable>datahiker ;

    @FXML
    private Font x6;
    @FXML
    private Label LabelGoto;
    @FXML
    private Color x7;
    
    @FXML
    private TableColumn<TripTable, String> UpPN;
    @FXML
    private TableColumn<TripTable, String> OnePN;
    @FXML
    private TableColumn<TripTable, String> LongPN;
    @FXML
    private TableColumn<TripTable, String> FreePN;
    @FXML
    private ComboBox<String> HikerMeetP;
    @FXML
    private TextField Hikeramount;
    @FXML
    private ComboBox<String> Hikerpm;
    @FXML
    private TableColumn<?, ?> UpType;
    

    
    public String getMyTrip() {
        return TripName;    
    }
    public String getMyID() {
        return IDtrip;    
    }
    public String getTripType() {
        return TripType;    
    }
    public String getTripPrice() {
        return TripPrice;    
    }
    public String getTripDate() {
        return TripDate;    
    }
    public String getMyAppSat() {
        return AppSat;    
    }
    public String getShortname() {
        return Tripshort;    
    }
    public String getGotoTripID() {
        return GotoTripID;    
    }
    public String getGotoCusID() {
        return GotoCusID;    
    }
    public String getGotoCusName() {
        return GotoCusName;    
    }
    
    
    TripListController triplist1 = new TripListController();
    CustomerListController cuslist1 = new CustomerListController();
    
    @FXML
    private void ButtonAction(ActionEvent event) throws IOException, SQLException  {
                Parent pageparent = FXMLLoader.load(getClass().getResource("Customerpage.fxml"));
                Scene pagescene = new Scene(pageparent);
                Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appstage.setScene(pagescene);
                appstage.centerOnScreen();
                appstage.setMaximized(false);
                appstage.setMaximized(true);
                appstage.setTitle("CET Customers Managment");
                appstage.show();
                IDtrip = null;
                TripName = null;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        ChTripYear.setItems(yearlist);
        ChTripMo.setItems(monthlist);
        ChTripDy.setItems(daylist);
        ChTripType.setItems(typelist);
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT * FROM trips where statu = 'Active'";
            ResultSet rs = st.executeQuery(query);
            updata = FXCollections.observableArrayList();
            onedata = FXCollections.observableArrayList();
            longdata = FXCollections.observableArrayList();
            freedata = FXCollections.observableArrayList();
            while (rs.next())
            {
                if (rs.getString(3).equalsIgnoreCase("One Day")){
                    onedata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    )); 
                }
                if (rs.getString(3).equalsIgnoreCase("Long Trip")){
                    longdata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    )); 
                }
                if (rs.getString(3).equalsIgnoreCase("Free Trip")){
                    freedata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    )); 
                }
                String days = rs.getString(5).substring(8,10);
                String month = rs.getString(5).substring(5,7);
                String year = rs.getString(5).substring(0, 4);
                String DBdate = year+month+days ;
                if (Integer.parseInt((dateFormat.format(date)))< Integer.parseInt(DBdate)){
                    updata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    ));
                }  
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrippageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UpName1.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        UpDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        UpPrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        UpPN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        UpType.setCellValueFactory(new PropertyValueFactory<>("tripType"));
        UpTable.setItems(updata);
        
        OneName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        OneDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        OnePrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        OnePN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        OneTable.setItems(onedata);
        
        LongName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        LongDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        LongPrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        LongPN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        LongTable.setItems(longdata);
        
        FreeName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        FreeDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        FreePrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        FreePN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        FreeTable.setItems(freedata);
        
        

    }    

    @FXML
    private void UpMouseClicked(MouseEvent event) {
        OneTable.setDisable(false);
        LongTable.setDisable(false);
        FreeTable.setDisable(false);
        BTConfirmEdit.setDisable(true);
        BTDeleteTrip.setDisable(true);
        ChTripYear.setDisable(true);
        ChTripMo.setDisable(true);
        ChTripDy.setDisable(true);
        ChTripType.setDisable(true);
        TFTripPrice.setEditable(false);
        TFtripeName.setEditable(false);
        TripLabel.setText("");
        OneTable.getSelectionModel().clearSelection();
        LongTable.getSelectionModel().clearSelection();
        FreeTable.getSelectionModel().clearSelection();
        TripTable Trip1 = UpTable.getSelectionModel().getSelectedItem();
        TFtripeName.setText(Trip1.getTripeName());
        TFTripPrice.setText(Trip1.getTripPrice());
        String Year = Trip1.getTripDate().substring(0, 4);
        String Month = Trip1.getTripDate().substring(5, 7);
        String Day = Trip1.getTripDate().substring(8,10);
        ChTripYear.setValue(Year);
        ChTripMo.setValue(Month);
        ChTripDy.setValue(Day);
        ChTripType.setValue(Trip1.getTripeType());
        TripName = Trip1.getTripeName();
        IDtrip = Trip1.getTripID();
    }

    @FXML
    private void OneMouseClicked(MouseEvent event) {
        UpTable.getSelectionModel().clearSelection();
        LongTable.getSelectionModel().clearSelection();
        FreeTable.getSelectionModel().clearSelection();
        TripTable Trip2 = OneTable.getSelectionModel().getSelectedItem();
        TFtripeName.setText(Trip2.getTripeName());
        TFTripPrice.setText(Trip2.getTripPrice());
        String Year = Trip2.getTripDate().substring(0, 4);
        String Month = Trip2.getTripDate().substring(5, 7);
        String Day = Trip2.getTripDate().substring(8,10);
        ChTripYear.setValue(Year);
        ChTripMo.setValue(Month);
        ChTripDy.setValue(Day);
        ChTripType.setValue(Trip2.getTripeType());
    }

    @FXML
    private void LongMouseClicked(MouseEvent event) {
        OneTable.getSelectionModel().clearSelection();
        UpTable.getSelectionModel().clearSelection();
        FreeTable.getSelectionModel().clearSelection();
        TripTable Trip3 = LongTable.getSelectionModel().getSelectedItem();
        TFtripeName.setText(Trip3.getTripeName());
        TFTripPrice.setText(Trip3.getTripPrice());
        String Year = Trip3.getTripDate().substring(0, 4);
        String Month = Trip3.getTripDate().substring(5, 7);
        String Day = Trip3.getTripDate().substring(8,10);
        ChTripYear.setValue(Year);
        ChTripMo.setValue(Month);
        ChTripDy.setValue(Day);
        ChTripType.setValue(Trip3.getTripeType());
    }

    @FXML
    private void FreeMouseClicked(MouseEvent event) {
        OneTable.getSelectionModel().clearSelection();
        LongTable.getSelectionModel().clearSelection();
        UpTable.getSelectionModel().clearSelection();
        TripTable Trip4 = FreeTable.getSelectionModel().getSelectedItem();
        TFtripeName.setText(Trip4.getTripeName());
        TFTripPrice.setText(Trip4.getTripPrice());
        String Year = Trip4.getTripDate().substring(0, 4);
        String Month = Trip4.getTripDate().substring(5, 7);
        String Day = Trip4.getTripDate().substring(8,10);
        ChTripYear.setValue(Year);
        ChTripMo.setValue(Month);
        ChTripDy.setValue(Day);
        ChTripType.setValue(Trip4.getTripeType());
    }

    @FXML
    private void LoadTripTables(ActionEvent event) {
        OneTable.setDisable(false);
        LongTable.setDisable(false);
        FreeTable.setDisable(false);
        BTConfirmEdit.setDisable(true);
        BTDeleteTrip.setDisable(true);
        ChTripYear.setDisable(true);
        ChTripMo.setDisable(true);
        ChTripDy.setDisable(true);
        ChTripType.setDisable(true);
        TFTripPrice.setEditable(false);
        TFtripeName.setEditable(false);
        TripLabel.setText("");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        ChTripYear.setItems(yearlist);
        ChTripMo.setItems(monthlist);
        ChTripDy.setItems(daylist);
        ChTripType.setItems(typelist);
        
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT * FROM trips where statu = 'Active'";
            ResultSet rs = st.executeQuery(query);
            updata = FXCollections.observableArrayList();
            onedata = FXCollections.observableArrayList();
            longdata = FXCollections.observableArrayList();
            freedata = FXCollections.observableArrayList();
            while (rs.next())
            {
                if (rs.getString(3).equalsIgnoreCase("One Day")){
                    onedata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    )); 
                }
                if (rs.getString(3).equalsIgnoreCase("Long Trip")){
                    longdata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    )); 
                }
                if (rs.getString(3).equalsIgnoreCase("Free Trip")){
                    freedata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    )); 
                }
                String days = rs.getString(5).substring(8,10);
                String month = rs.getString(5).substring(5,7);
                String year = rs.getString(5).substring(0, 4);
                String DBdate = year+month+days ;
                if (Integer.parseInt((dateFormat.format(date)))< Integer.parseInt(DBdate)){
                    updata.add(new TripTable(
                        rs.getString("idtrip"),
                        rs.getString("tripname"),
                        rs.getString("triptype"),
                        rs.getString("price"),
                        rs.getString("tripdate"),
                        rs.getString("statu"),
                        rs.getString("shortname")
                    ));
                }  
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrippageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UpName1.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        UpDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        UpPrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        UpPN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        UpType.setCellValueFactory(new PropertyValueFactory<>("tripType"));
        UpTable.setItems(updata);
        
        OneName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        OneDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        OnePrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        OnePN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        OneTable.setItems(onedata);
        
        LongName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        LongDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        LongPrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        LongPN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        LongTable.setItems(longdata);
        
        FreeName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        FreeDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        FreePrice.setCellValueFactory(new PropertyValueFactory<>("tripPrice"));
        FreePN.setCellValueFactory(new PropertyValueFactory<>("shortname"));
        FreeTable.setItems(freedata);
    }

    @FXML
    private void AddTripPanel(ActionEvent event) throws IOException {
        TripDate = null;
        TripName = null;
        TripType = null;
        TripPrice = null;
        Tripshort = null;
        Parent pageparent = FXMLLoader.load(getClass().getResource("Trips/AddTripPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Trip");
        appstage.show();
    }
    
    private void lunch() throws IOException{
        Parent pageparent = FXMLLoader.load(getClass().getResource("Trips/AddTripPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Duplicate Trip");
        appstage.show();
    }
    
    @FXML
    private void DuplicateTrip(ActionEvent event) throws IOException {
        if (UpTable.getSelectionModel().isEmpty()==false){
            TripTable TripT = UpTable.getSelectionModel().getSelectedItem();
            TripName = TripT.getTripeName();
            TripDate = TripT.getTripDate();
            TripType = TripT.getTripeType();
            TripPrice = TripT.getTripPrice();
            Tripshort = TripT.getShortname();
            lunch();
        }else{
            if (OneTable.getSelectionModel().isEmpty()==false){
                TripTable TripT = OneTable.getSelectionModel().getSelectedItem();
                TripName = TripT.getTripeName();
                TripDate = TripT.getTripDate();
                TripType = TripT.getTripeType();
                TripPrice = TripT.getTripPrice();
                Tripshort = TripT.getShortname();
                lunch();
                }else{
                    if (LongTable.getSelectionModel().isEmpty()==false){
                        TripTable TripT = LongTable.getSelectionModel().getSelectedItem();
                        TripName = TripT.getTripeName();
                        TripDate = TripT.getTripDate();
                        TripType = TripT.getTripeType();
                        TripPrice = TripT.getTripPrice();
                        Tripshort = TripT.getShortname();
                        lunch();
                    }else{
                        if (FreeTable.getSelectionModel().isEmpty()==false){
                            TripTable TripT = FreeTable.getSelectionModel().getSelectedItem();
                            TripName = TripT.getTripeName();
                            TripDate = TripT.getTripDate();
                            TripType = TripT.getTripeType();
                            TripPrice = TripT.getTripPrice();
                            Tripshort = TripT.getShortname();
                            lunch();
                        }else{
                            TripLabel.setText("Select Trip First");
                        }
                        
                    }
            }
        }
    }

    @FXML
    private void EditTrip(ActionEvent event) {
        if (OneTable.getSelectionModel().isEmpty()==false||LongTable.getSelectionModel().isEmpty()==false||FreeTable.getSelectionModel().isEmpty()==false){
            TripLabel.setText("Old Trips Can't be Edited");
        }else{
            if (UpTable.getSelectionModel().isEmpty()){
                TripLabel.setText("Select A trip From Up Coming Column");
            }else{
                TripLabel.setText("");
                OneTable.setDisable(true);
                LongTable.setDisable(true);
                FreeTable.setDisable(true);
                TripTable TripT = UpTable.getSelectionModel().getSelectedItem();
                BTConfirmEdit.setDisable(false);
                BTDeleteTrip.setDisable(false);
                ChTripYear.setDisable(false);
                ChTripMo.setDisable(false);
                ChTripDy.setDisable(false);
                ChTripType.setDisable(false);
                TFTripPrice.setEditable(true);
                TFtripeName.setEditable(true);
                IDtrip = TripT.getTripID();
                TripName = TripT.getTripeName();
                
            }
        }
         
    }
    
    @FXML
    private void BTConfirmEdit(ActionEvent event) throws SQLException {
        if (TFtripeName.getText().isEmpty()||TFTripPrice.getText().isEmpty()){
            TripLabel.setText("All Fields are Required");
        }else{
            String Date1 = ChTripYear.getValue()+"-"+ChTripMo.getValue()+"-"+ChTripDy.getValue();
            auth cnx = new auth();
            try (Statement st = cnx.connect().createStatement()) {
                String query = "UPDATE trips SET tripname='"+TFtripeName.getText()+"', triptype='"+ChTripType.getValue()+"', price='"+TFTripPrice.getText()+"', tripdate ='"+Date1+"' WHERE idtrip="+getMyID();
                st.executeUpdate(query);
                st.close();
                TripLabel.setText("Trip Updated successfully");
            }
            BTConfirmEdit.setDisable(true);
            BTDeleteTrip.setDisable(true);
            ChTripYear.setDisable(true);
            ChTripMo.setDisable(true);
            ChTripDy.setDisable(true);
            ChTripType.setDisable(true);
            TFTripPrice.setEditable(false);
            TFtripeName.setEditable(false);
        }
    }

    @FXML
    private void BTDeletePanle(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("Trips/TripDeletePanle.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Delete Trip");
        appstage.show();
    }
    


    @FXML
    private void LoadHikers(ActionEvent event) throws IOException, SQLException {
        HikerMeetP.setDisable(true);
        HikerAmount.setEditable(false);
        Hikerpm.setDisable(true);
        BTConfirmHikEdit.setDisable(true);
        BTDeleteHike.setDisable(true);
            
        if (UpTable.getSelectionModel().isEmpty()==false){
            LabelGoto.setText("");
            TripTable TripHiker = UpTable.getSelectionModel().getSelectedItem();
            auth cnx = new auth();
            try (Statement st = cnx.connect().createStatement()) {
                
                String query = "SELECT goto.paymentnumber,goto.idcus,goto.idtrip,trips.tripname, customer.fullname, customer.phonecus, goto.meetp, goto.amount, goto.paymentm FROM goto INNER JOIN customer ON goto.idcus=customer.idcus INNER JOIN trips ON goto.idtrip=trips.idtrip where goto.idtrip="+TripHiker.getTripID()+"and goto.statu = 'Active' ORDER BY paymentnumber ASC"; //where goto.idtrip //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
                ResultSet rs = st.executeQuery(query);
                datahiker = FXCollections.observableArrayList();
                while (rs.next())
                {
                    datahiker.add(new HikerTable(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                    ));  

                }
                st.close();
                rs.close();
            }

            HikerPN.setCellValueFactory(new PropertyValueFactory<>("gotopayNum"));
            HikerName.setCellValueFactory(new PropertyValueFactory<>("gotocusName"));
            HikerPhone.setCellValueFactory(new PropertyValueFactory<>("gotocusPhone"));
            HikerMP.setCellValueFactory(new PropertyValueFactory<>("gotomeetP"));
            HikerAmount.setCellValueFactory(new PropertyValueFactory<>("gotoAmount"));
            HikerPM.setCellValueFactory(new PropertyValueFactory<>("gotoPaym"));
            HikersTable.setItems(datahiker);
        }else{
            if (OneTable.getSelectionModel().isEmpty()==false){
                LabelGoto.setText("");
                TripTable TripHiker = OneTable.getSelectionModel().getSelectedItem();
                auth cnx = new auth();
                try (Statement st = cnx.connect().createStatement()) {

                    String query = "SELECT goto.paymentnumber,goto.idcus,goto.idtrip,trips.tripname, customer.fullname, customer.phonecus, goto.meetp, goto.amount, goto.paymentm FROM goto INNER JOIN customer ON goto.idcus=customer.idcus INNER JOIN trips ON goto.idtrip=trips.idtrip where goto.idtrip="+TripHiker.getTripID()+"and goto.statu = 'Active' ORDER BY paymentnumber ASC"; //where goto.idtrip //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
                    ResultSet rs = st.executeQuery(query);
                    datahiker = FXCollections.observableArrayList();
                    while (rs.next())
                    {
                        datahiker.add(new HikerTable(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9)
                        ));  

                    }
                    st.close();
                    rs.close();
                }

                HikerPN.setCellValueFactory(new PropertyValueFactory<>("gotopayNum"));
                HikerName.setCellValueFactory(new PropertyValueFactory<>("gotocusName"));
                HikerPhone.setCellValueFactory(new PropertyValueFactory<>("gotocusPhone"));
                HikerMP.setCellValueFactory(new PropertyValueFactory<>("gotomeetP"));
                HikerAmount.setCellValueFactory(new PropertyValueFactory<>("gotoAmount"));
                HikerPM.setCellValueFactory(new PropertyValueFactory<>("gotoPaym"));
                HikersTable.setItems(datahiker);
            }else{
                 if (LongTable.getSelectionModel().isEmpty()==false){
                    LabelGoto.setText("");
                    TripTable TripHiker = LongTable.getSelectionModel().getSelectedItem();
                    auth cnx = new auth();
                    try (Statement st = cnx.connect().createStatement()) {

                        String query = "SELECT goto.paymentnumber,goto.idcus,goto.idtrip,trips.tripname, customer.fullname, customer.phonecus, goto.meetp, goto.amount, goto.paymentm FROM goto INNER JOIN customer ON goto.idcus=customer.idcus INNER JOIN trips ON goto.idtrip=trips.idtrip where goto.idtrip="+TripHiker.getTripID()+"and goto.statu = 'Active' ORDER BY paymentnumber ASC"; //where goto.idtrip //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
                        ResultSet rs = st.executeQuery(query);
                        datahiker = FXCollections.observableArrayList();
                        while (rs.next())
                        {
                            datahiker.add(new HikerTable(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9)
                            ));  

                        }
                        st.close();
                        rs.close();
                    }

                    HikerPN.setCellValueFactory(new PropertyValueFactory<>("gotopayNum"));
                    HikerName.setCellValueFactory(new PropertyValueFactory<>("gotocusName"));
                    HikerPhone.setCellValueFactory(new PropertyValueFactory<>("gotocusPhone"));
                    HikerMP.setCellValueFactory(new PropertyValueFactory<>("gotomeetP"));
                    HikerAmount.setCellValueFactory(new PropertyValueFactory<>("gotoAmount"));
                    HikerPM.setCellValueFactory(new PropertyValueFactory<>("gotoPaym"));
                    HikersTable.setItems(datahiker);
                 }else{
                     if (FreeTable.getSelectionModel().isEmpty()==false){
                        LabelGoto.setText("");
                        TripTable TripHiker = FreeTable.getSelectionModel().getSelectedItem();
                        auth cnx = new auth();
                        try (Statement st = cnx.connect().createStatement()) {

                            String query = "SELECT goto.paymentnumber,goto.idcus,goto.idtrip,trips.tripname, customer.fullname, customer.phonecus, goto.meetp, goto.amount, goto.paymentm FROM goto INNER JOIN customer ON goto.idcus=customer.idcus INNER JOIN trips ON goto.idtrip=trips.idtrip where goto.idtrip="+TripHiker.getTripID()+"and goto.statu = 'Active' ORDER BY paymentnumber ASC"; //where goto.idtrip //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
                            ResultSet rs = st.executeQuery(query);
                            datahiker = FXCollections.observableArrayList();
                            while (rs.next())
                            {
                                datahiker.add(new HikerTable(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8),
                                    rs.getString(9)
                                ));  

                            }
                            st.close();
                            rs.close();
                        }

                        HikerPN.setCellValueFactory(new PropertyValueFactory<>("gotopayNum"));
                        HikerName.setCellValueFactory(new PropertyValueFactory<>("gotocusName"));
                        HikerPhone.setCellValueFactory(new PropertyValueFactory<>("gotocusPhone"));
                        HikerMP.setCellValueFactory(new PropertyValueFactory<>("gotomeetP"));
                        HikerAmount.setCellValueFactory(new PropertyValueFactory<>("gotoAmount"));
                        HikerPM.setCellValueFactory(new PropertyValueFactory<>("gotoPaym"));
                        HikersTable.setItems(datahiker);
                     }else{
                         LabelGoto.setText("Select a Trip please");
                     }
                 }
            }
        }
        
    }

    @FXML
    private void AddHiker(ActionEvent event) throws IOException {
            cuslist1.setMyID(null);
            cuslist1.setMyname(null);
            triplist1.setMyID(null);
            triplist1.setMyName(null);
            triplist1.setTripPrice(null);
            Parent pageparent = FXMLLoader.load(getClass().getResource("Goto/AddGoto.fxml"));
            Scene pagescene = new Scene(pageparent);
            Stage appstage = new Stage();
            appstage.setScene(pagescene);
            appstage.setResizable(false);
            appstage.setTitle("Add Hiker");
            appstage.show();      
    }

    @FXML
    private void EditHiker(ActionEvent event) {
        if (HikersTable.getSelectionModel().isEmpty()){
            LabelGoto.setText("Select A trip From Hiker Table");
        }else{
            LabelGoto.setText("");
            HikerMeetP.setDisable(false);
            Hikeramount.setEditable(true);
            Hikerpm.setDisable(false);
            BTConfirmHikEdit.setDisable(false);
            BTDeleteHike.setDisable(false);
            HikerTable HikerT = HikersTable.getSelectionModel().getSelectedItem();
            GotoCusID = HikerT.getGotocusID();
            GotoTripID= HikerT.getGototripID();
        }
        
    }

    @FXML
    private void HikerMouseClicked(MouseEvent event) {
        HikerMeetP.setDisable(true);
        HikerAmount.setEditable(false);
        Hikerpm.setDisable(true);
        BTConfirmHikEdit.setDisable(true);
        BTDeleteHike.setDisable(true);
        HikerTable hikergoto = HikersTable.getSelectionModel().getSelectedItem();
        HikerMeetP.setValue(hikergoto.getGotomeetP());
        HikerMeetP.setItems(MPlist);
        Hikeramount.setText(hikergoto.getGotoAmount());
        Hikerpm.setValue(hikergoto.getGotoPaym());
        Hikerpm.setItems(PMlist);
        GotoCusID = hikergoto.getGotocusID();
        GotoTripID =hikergoto.getGototripID();
    }

    @FXML
    private void DeleteHiker(ActionEvent event) throws IOException {
            HikerTable hikergoto = HikersTable.getSelectionModel().getSelectedItem();
            GotoCusID = hikergoto.getGotocusID();
            GotoTripID = hikergoto.getGototripID();
            GotoCusName = hikergoto.getGotocusName();
            Parent pageparent = FXMLLoader.load(getClass().getResource("Goto/GotoDeletePanel.fxml"));
            Scene pagescene = new Scene(pageparent);
            Stage appstage = new Stage();
            appstage.setScene(pagescene);
            appstage.setResizable(false);
            appstage.setTitle("Delete hiker");
            appstage.show();
    }

    @FXML
    private void BTConfirmHikEdit(ActionEvent event) throws SQLException {
        if (Hikeramount.getText().isEmpty()){
            LabelGoto.setText("All Fields are Required");
        }else{
            auth cnx = new auth();
            try (Statement st = cnx.connect().createStatement()) {
                String query = "UPDATE goto SET  meetp='"+HikerMeetP.getValue()+"', amount="+Hikeramount.getText()+", paymentm='"+Hikerpm.getValue()+"' WHERE idcus ="+GotoCusID+" and idtrip ="+GotoTripID;
                st.executeUpdate(query);
                st.close();
                LabelGoto.setText("Hiker Updated successfully");
            }
            HikerMeetP.setDisable(true);
            Hikeramount.setEditable(false);
            Hikerpm.setDisable(true);
        }
    }

    @FXML
    private void leaderaction(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("Leaders/LeaderPage.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setTitle("CET Leaders Managment");
        appstage.setMaximized(false);
        appstage.setMaximized(true);
        appstage.show();
    }

    @FXML
    private void AssignLeaders(ContextMenuEvent event) throws IOException {
        TripTable TripLead = UpTable.getSelectionModel().getSelectedItem();
        IDtrip = TripLead.getTripID();
        TripName = TripLead.getTripeName();
        TripDate = TripLead.getTripDate();
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Leaders/ToLead.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Assign Leaders");
        appstage.show();
    }


    @FXML
    private void MenuItemCustomerlunch(ActionEvent event) {
    }

    @FXML
    private void ConsultLeaders(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Lead/Leadshow.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Leaders");
        appstage.show();
    }

    @FXML
    private void TripInformations(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("Trips/TripsInfo.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Trips Informations");
        appstage.show();
    }


    
}
