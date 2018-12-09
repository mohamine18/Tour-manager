/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Lead;

import cet.Leaders.ToLeadController;
import cet.auth;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class LeadshowController implements Initializable {

    @FXML
    private TextField TFSearch;
    @FXML
    private TableColumn<LeadTable, String> TripNameCol;
    @FXML
    private TableColumn<LeadTable, String> TripDateCol;
    @FXML
    private TableColumn<LeadTable, String> LeaderNameCol;
    @FXML
    private TableColumn<LeadTable, String> AssistantOneCol;
    @FXML
    private TableColumn<LeadTable, String> AssistantTwoCol;
    @FXML
    private TableColumn<LeadTable, String> AssistantThreeCol;
    @FXML
    private TableColumn<LeadTable, String> AssistantFourCol;

    /**
     * Initializes the controller class.
     */
    private ObservableList<LeadTable>data ;
    private ObservableList<LeadTable>data1 ;
    
    @FXML
    private TableView<LeadTable> LeadTable;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT t.tripname, t.tripdate, c.fullname , s1.fullname , s2.fullname, s3.fullname, s4.fullname FROM lead LEFT JOIN trips t ON (lead.idtrip=t.idtrip) LEFT JOIN customer c ON (lead.leader=c.idleader) LEFT JOIN customer s1 ON (lead.assistant1=s1.idleader) LEFT JOIN customer s2 ON (lead.assistant2=s2.idleader) LEFT JOIN customer s3 ON (lead.assistant3=s3.idleader) LEFT JOIN customer s4 ON (lead.assistant4=s4.idleader) "; 
            data = FXCollections.observableArrayList();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                data.add(new LeadTable(
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
        }catch (SQLException ex) {
            Logger.getLogger(ToLeadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TripNameCol.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        TripDateCol.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        LeaderNameCol.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        AssistantOneCol.setCellValueFactory(new PropertyValueFactory<>("assistant1Name"));
        AssistantTwoCol.setCellValueFactory(new PropertyValueFactory<>("assistant2Name"));
        AssistantThreeCol.setCellValueFactory(new PropertyValueFactory<>("assistant3Name"));
        AssistantFourCol.setCellValueFactory(new PropertyValueFactory<>("assistant4Name"));
        LeadTable.setItems(data);
    }    


    @FXML
    private void TFsearchField(KeyEvent event) {
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT t.tripname, t.tripdate, c.fullname , s1.fullname , s2.fullname, s3.fullname, s4.fullname FROM lead LEFT JOIN trips t ON (lead.idtrip=t.idtrip) LEFT JOIN customer c ON (lead.leader=c.idleader) LEFT JOIN customer s1 ON (lead.assistant1=s1.idleader) LEFT JOIN customer s2 ON (lead.assistant2=s2.idleader) LEFT JOIN customer s3 ON (lead.assistant3=s3.idleader) LEFT JOIN customer s4 ON (lead.assistant4=s4.idleader) where t.tripname like '%"+TFSearch.getText()+"%' "; 
            data1 = FXCollections.observableArrayList();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                data1.add(new LeadTable(
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
        }catch (SQLException ex) {
            Logger.getLogger(ToLeadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TripNameCol.setCellValueFactory(new PropertyValueFactory<>("tripName"));
        TripDateCol.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        LeaderNameCol.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        AssistantOneCol.setCellValueFactory(new PropertyValueFactory<>("assistant1Name"));
        AssistantTwoCol.setCellValueFactory(new PropertyValueFactory<>("assistant2Name"));
        AssistantThreeCol.setCellValueFactory(new PropertyValueFactory<>("assistant3Name"));
        AssistantFourCol.setCellValueFactory(new PropertyValueFactory<>("assistant4Name"));
        LeadTable.setItems(data1);
    }
    
}
