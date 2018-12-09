/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Leaders;

import cet.TrippageController;
import cet.auth;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class AssistantList4 implements Initializable {

    @FXML
    private TextField TFSearch;
    @FXML
    private RadioButton RBName;
    @FXML
    private RadioButton RBLevel;
    @FXML
    private TableColumn<LeaderTable, String> LeaderNameCol;
    @FXML
    private TableColumn<LeaderTable, String> LeaderLevelCol;
    @FXML
    private TableColumn<LeaderTable, String> LeaderPhoneCol;
    @FXML
    private Font x1;

    /**
     * Initializes the controller class.
     */
    private ObservableList<LeaderTable>data ;
    private ObservableList<LeaderTable>data1 ;
    @FXML
    private TableView<LeaderTable> LeaderTable;
    
    ToLeadController load = new ToLeadController();
    TrippageController trip = new TrippageController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ToggleGroup SearchRadiogroup = new ToggleGroup();
        RBName.setToggleGroup(SearchRadiogroup);
        RBLevel.setToggleGroup(SearchRadiogroup);
        RBName.setSelected(true);
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT leader.idleader, customer.fullname , customer.phonecus ,leader.level, leader.datejoin, leader.dateend, leader.service, leader.address, leader.email, leader.leadcomment, leader.cettalk, leader.opera, leader.languageskill, leader.cetgame, leader.cashcollector FROM leader INNER JOIN customer ON leader.idleader=customer.idleader where leader.statu = 'Active' ORDER BY customer.fullname ASC"; 
            ResultSet rs = st.executeQuery(query);
            data = FXCollections.observableArrayList();
            while (rs.next())
            {
                data.add(new LeaderTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15)
                ));  
                
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LeaderNameCol.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhoneCol.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevelCol.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderTable.setItems(data); 
    }    

    @FXML
    private void TFSearchName(KeyEvent event) {
        if (RBName.isSelected()){
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT leader.idleader, customer.fullname , customer.phonecus ,leader.level, leader.datejoin, leader.dateend, leader.service, leader.address, leader.email, leader.leadcomment, leader.cettalk, leader.opera, leader.languageskill, leader.cetgame, leader.cashcollector FROM leader INNER JOIN customer ON leader.idleader=customer.idleader where leader.statu = 'Active' and customer.fullname like '%"+TFSearch.getText().toUpperCase()+"%' ORDER BY customer.fullname ASC"; 
            ResultSet rs = st.executeQuery(query);
            data = FXCollections.observableArrayList();
            while (rs.next())
            {
                data.add(new LeaderTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15)
                ));  
                
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LeaderNameCol.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhoneCol.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevelCol.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderTable.setItems(data);
        }
        if (RBLevel.isSelected()){
            auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT leader.idleader, customer.fullname , customer.phonecus ,leader.level, leader.datejoin, leader.dateend, leader.service, leader.address, leader.email, leader.leadcomment, leader.cettalk, leader.opera, leader.languageskill, leader.cetgame, leader.cashcollector FROM leader INNER JOIN customer ON leader.idleader=customer.idleader where leader.statu = 'Active' and leader.level like '"+TFSearch.getText().toUpperCase()+"%' ORDER BY customer.fullname ASC"; 
            ResultSet rs = st.executeQuery(query);
            data1 = FXCollections.observableArrayList();
            while (rs.next())
            {
                data1.add(new LeaderTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15)
                ));  
                
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LeaderNameCol.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhoneCol.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevelCol.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderTable.setItems(data1);
    }
    }

    @FXML
    private void SelectPressed(ActionEvent event) throws SQLException, IOException {
        LeaderTable leader = LeaderTable.getSelectionModel().getSelectedItem();
        auth cnx = new auth();
            try (Statement st = cnx.connect().createStatement()) {
                String query = "UPDATE lead SET assistant4="+leader.getLeaderId()+" WHERE idtrip="+trip.getMyID();
                st.executeUpdate(query);
                st.close();
            }
            
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Leaders/ToLead.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Assign Leaders");
        appstage.show();
    }

    @FXML
    private void CancelPressed(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Leaders/ToLead.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Assign Leaders");
        appstage.show();
    }
    
}
