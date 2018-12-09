/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Trips;

import cet.auth;
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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class TripsInfoController implements Initializable {

    @FXML
    private ComboBox<String> FromYear;
    @FXML
    private ComboBox<String> FromMonth;
    @FXML
    private ComboBox<String> FromDay;
    @FXML
    private ComboBox<String> ToYear;
    @FXML
    private ComboBox<String> ToMonth;
    @FXML
    private ComboBox<String> ToDay;
    @FXML
    private TableColumn<TripsInfoTable, String> TripName;
    @FXML
    private TableColumn<TripsInfoTable, String> TripDate;
    @FXML
    private TableColumn<TripsInfoTable, String> Hikers;
    @FXML
    private TableColumn<TripsInfoTable, String> BLCU;
    @FXML
    private TableColumn<TripsInfoTable, String> UIBE;
    @FXML
    private TableColumn<TripsInfoTable, String> Weig;
    @FXML
    private TableColumn<TripsInfoTable, String> Liang;
    private ObservableList<TripsInfoTable>datahiker ;
    @FXML
    private TableView<TripsInfoTable> TripInfoTable;
    ObservableList<String> yearlist = FXCollections.observableArrayList("2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        FromYear.setValue(dateFormat.format(date).substring(0, 4));
        FromYear.setItems(yearlist);
        FromMonth.setValue(dateFormat.format(date).substring(4, 6));
        FromMonth.setItems(monthlist);
        ToYear.setValue(dateFormat.format(date).substring(0, 4));
        ToYear.setItems(yearlist);
        ToMonth.setValue(dateFormat.format(date).substring(4, 6));
        ToMonth.setItems(monthlist);
        FromDay.setItems(daylist);
        ToDay.setItems(daylist);
        
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {

            String query = "SELECT trips.tripname, trips.tripdate, COUNT(goto.idtrip) AS Hikers," +
                            "       sum(case when meetp  = 'South gate of UIBE' then 1 else 0 end) as UIBE," +
                            "       sum(case when  meetp  = 'South gate of BLCU' then 1 else 0 end) as BLCU," +
                            "       sum(case when  meetp  = 'Weigongcun Subway station' then 1 else 0 end) as Weigongcun," +
                            "       sum(case when  meetp  = 'LiangmaqiaoSubway station' then 1 else 0 end) as Liangmaqiao" +
                            " from goto" +
                            " LEFT JOIN trips ON goto.idtrip = trips.idtrip" +
                            " where goto.statu = 'Active'" +
                            " group by trips.tripname, trips.tripdate";
            ResultSet rs = st.executeQuery(query);
            datahiker = FXCollections.observableArrayList();
            while (rs.next())
            {
                datahiker.add(new TripsInfoTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                ));  

            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TripsInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TripName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        TripDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        Hikers.setCellValueFactory(new PropertyValueFactory<>("numHikers"));
        BLCU.setCellValueFactory(new PropertyValueFactory<>("numBLCU"));
        UIBE.setCellValueFactory(new PropertyValueFactory<>("numUIBE"));
        Weig.setCellValueFactory(new PropertyValueFactory<>("numWeig"));
        Liang.setCellValueFactory(new PropertyValueFactory<>("numLiang"));
        TripInfoTable.setItems(datahiker);
    }    

    @FXML
    private void SelectDate(ActionEvent event) {
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String FromDate = FromYear.getValue()+"-"+FromMonth.getValue()+"-"+FromDay.getValue();
            String ToDate = ToYear.getValue()+"-"+ToMonth.getValue()+"-"+ToDay.getValue();
            String query = "SELECT trips.tripname, trips.tripdate, COUNT(goto.idtrip) AS Hikers," +
                            "       sum(case when meetp  = 'South gate of UIBE' then 1 else 0 end) as UIBE," +
                            "       sum(case when  meetp  = 'South gate of BLCU' then 1 else 0 end) as BLCU," +
                            "       sum(case when  meetp  = 'Weigongcun Subway station' then 1 else 0 end) as Weigongcun," +
                            "       sum(case when  meetp  = 'LiangmaqiaoSubway station' then 1 else 0 end) as Liangmaqiao" +
                            " from goto" +
                            " LEFT JOIN trips ON goto.idtrip = trips.idtrip" +
                            " where goto.statu = 'Active' and trips.tripdate between '"+FromDate+"' and '"+ToDate+"' group by trips.tripname, trips.tripdate";
            ResultSet rs = st.executeQuery(query);
            datahiker = FXCollections.observableArrayList();
            while (rs.next())
            {
                datahiker.add(new TripsInfoTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                ));  

            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TripsInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TripName.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        TripDate.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        Hikers.setCellValueFactory(new PropertyValueFactory<>("numHikers"));
        BLCU.setCellValueFactory(new PropertyValueFactory<>("numBLCU"));
        UIBE.setCellValueFactory(new PropertyValueFactory<>("numUIBE"));
        Weig.setCellValueFactory(new PropertyValueFactory<>("numWeig"));
        Liang.setCellValueFactory(new PropertyValueFactory<>("numLiang"));
        TripInfoTable.setItems(datahiker);
    }
    
}
