/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Leaders;

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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class LeaderPageController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Insets x2;
    @FXML
    private TextField SearchField;
    @FXML
    private RadioButton RadioName;
    @FXML
    private TableView<LeaderTable> LeaderTable;
    @FXML
    private TableColumn<LeaderTable, String> LeaderName;
    @FXML
    private TableColumn<LeaderTable, String> LeaderAddress;
    @FXML
    private TableColumn<LeaderTable, String> LeaderLevel;
    @FXML
    private TableColumn<LeaderTable, String> LeaderOfferDate;
    @FXML
    private TableColumn<LeaderTable, String> LeaderEndDate;
    @FXML
    private TableColumn<LeaderTable, String> LeaderCETGame;
    @FXML
    private TableColumn<LeaderTable, String> LeaderCETTalk;
    @FXML
    private TableColumn<LeaderTable, String> LeaderCETService;
    @FXML
    private TableColumn<LeaderTable, String> LeaderCETLanguage;
    @FXML
    private TableColumn<LeaderTable, String> LeaderCETOpera;
    @FXML
    private Button CusPage;
    @FXML
    private Button TripPage;
    @FXML
    private Label LabelEmpty;
    @FXML
    private Font x4;
    @FXML
    private Insets x3;
    @FXML
    private Font x5;
    @FXML
    private TableColumn<LeaderTable, String> LeaderPhone;
    private ObservableList<LeaderTable>data ;
    private ObservableList<LeaderTable>data1 ;
    @FXML
    private Button loadLeader;
    @FXML
    private Button BTAddLeader;
    @FXML
    private Button BTEditLeader;
    @FXML
    private Insets x9;
    @FXML
    private TextField TFAddress;
    @FXML
    private Insets x8;
    @FXML
    private TextField TFEmail;
    @FXML
    private ComboBox<String> ComLevel;
    @FXML
    private ComboBox<String> ComDJYear;
    @FXML
    private ComboBox<String> ComDJMonth;
    @FXML
    private Insets x6;
    @FXML
    private ComboBox<String> ComDJDay;
    @FXML
    private ComboBox<String> ComEDYear;
    @FXML
    private ComboBox<String> ComEDMonth;
    @FXML
    private ComboBox<String> ComEDDay;
    @FXML
    private ComboBox<String> ComAbiliti;
    @FXML
    private Insets x7;
    @FXML
    private ComboBox<String> ComOpera;
    @FXML
    private ComboBox<String> ComTalk;
    @FXML
    private ComboBox<String> ComGame;
    @FXML
    private ComboBox<String> ComLanguage;
    @FXML
    private TextArea TFComment;
    @FXML
    private Button BTConfirmEdit;
    @FXML
    private Button BTDelete;
    
    private static String IDLeader = null;
    private static String NameLeader = null;
    @FXML
    private RadioButton RadioLevel;
    @FXML
    private TableColumn<LeaderTable, String> LeaderCollector;
    @FXML
    private ComboBox<String> GomCash;
    
    public String getLeaderID() {
        return IDLeader;    
    }
    public String getNameLeader() {
        return NameLeader;    
    }

    
    ObservableList<String> yearlist = FXCollections.observableArrayList("2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    ObservableList<String> levellist = FXCollections.observableArrayList("01","02","03","04","05");
    ObservableList<String> CashCollector = FXCollections.observableArrayList("Yes","No");
    ObservableList<String> namelevellist = FXCollections.observableArrayList("Senior leader","Intermediate leader","Junior leader","Internship leader","Rookie leader");
    CustomerListController cus1 = new CustomerListController();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ToggleGroup SearchRadiogroup = new ToggleGroup();
        RadioName.setToggleGroup(SearchRadiogroup);
        RadioLevel.setToggleGroup(SearchRadiogroup);
        RadioName.setSelected(true);
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
        LeaderName.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhone.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevel.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderOfferDate.setCellValueFactory(new PropertyValueFactory<>("leaderDateJoin"));
        LeaderEndDate.setCellValueFactory(new PropertyValueFactory<>("leaderEndDate"));  
        LeaderAddress.setCellValueFactory(new PropertyValueFactory<>("leaderAdress"));
        LeaderCETService.setCellValueFactory(new PropertyValueFactory<>("leaderService"));
        LeaderCETGame.setCellValueFactory(new PropertyValueFactory<>("leaderCetGame"));
        LeaderCETLanguage.setCellValueFactory(new PropertyValueFactory<>("leaderCetLang"));
        LeaderCETOpera.setCellValueFactory(new PropertyValueFactory<>("leaderCetOpra"));
        LeaderCETTalk.setCellValueFactory(new PropertyValueFactory<>("leaderCetTalk"));
        LeaderCollector.setCellValueFactory(new PropertyValueFactory<>("leaderCashCol"));
        LeaderTable.setItems(data);
        
        
    }    

    @FXML
    private void CusAction(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Customerpage.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.setTitle("CET Customers Managment");
        appstage.setMaximized(false);
        appstage.setMaximized(true);
        appstage.show();
    }

    @FXML
    private void TripAction(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Trippage.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.setTitle("CET Trips Managment");
        appstage.setMaximized(false);
        appstage.setMaximized(true);
        appstage.show();
    }

    @FXML
    private void MouseClicked(MouseEvent event) {
        TFAddress.clear();
        TFEmail.clear();
        ComLevel.setValue("");
        ComDJYear.setValue("");
        ComDJMonth.setValue("");
        ComDJDay.setValue("");
        ComEDYear.setValue("");
        ComEDMonth.setValue("");
        ComEDDay.setValue("");
        ComAbiliti.setValue("");
        ComOpera.setValue("");
        ComTalk.setValue("");
        ComGame.setValue("");
        ComLanguage.setValue("");
        TFComment.clear();
        TFAddress.setEditable(false);
        TFEmail.setEditable(false);
        ComLevel.setDisable(true);
        ComDJYear.setDisable(true);
        ComDJMonth.setDisable(true);
        ComDJDay.setDisable(true);
        ComEDYear.setDisable(true);
        ComEDMonth.setDisable(true);
        ComEDDay.setDisable(true);
        ComAbiliti.setDisable(true);
        ComOpera.setDisable(true);
        ComTalk.setDisable(true);
        ComGame.setDisable(true);
        ComLanguage.setDisable(true);
        GomCash.setDisable(true);
        TFComment.setEditable(false);
        BTConfirmEdit.setDisable(true);
        BTDelete.setDisable(true);
        LeaderTable leaderdata = LeaderTable.getSelectionModel().getSelectedItem();
        TFAddress.setText(leaderdata.getLeaderAdress());
        TFEmail.setText(leaderdata.getLeaderEmail());
        ComLevel.setValue(leaderdata.getLeaderLevel());
        ComDJYear.setValue(leaderdata.getLeaderDateJoin().substring(0,4));
        ComDJMonth.setValue(leaderdata.getLeaderDateJoin().substring(5,7));
        ComDJDay.setValue(leaderdata.getLeaderDateJoin().substring(8,10));
        ComEDYear.setValue(leaderdata.getLeaderEndDate().substring(0,4));
        ComEDMonth.setValue(leaderdata.getLeaderEndDate().substring(5,7));
        ComEDDay.setValue(leaderdata.getLeaderEndDate().substring(8,10));
        ComAbiliti.setValue(leaderdata.getLeaderService());
        ComOpera.setValue(leaderdata.getLeaderCetOpra());
        ComTalk.setValue(leaderdata.getLeaderCetTalk());
        ComGame.setValue(leaderdata.getLeaderCetGame());
        ComLanguage.setValue(leaderdata.getLeaderCetLang());
        GomCash.setValue(leaderdata.getLeaderCashCol());
        TFComment.setText(leaderdata.getLeaderComment());
        IDLeader = leaderdata.getLeaderId();
        NameLeader = leaderdata.getLeaderName();
        
    }

    @FXML
    private void LoadLeader(ActionEvent event) {
        LabelEmpty.setText("");
        TFAddress.clear();
        TFEmail.clear();
        ComLevel.setValue("");
        ComDJYear.setValue("");
        ComDJMonth.setValue("");
        ComDJDay.setValue("");
        ComEDYear.setValue("");
        ComEDMonth.setValue("");
        ComEDDay.setValue("");
        ComAbiliti.setValue("");
        ComOpera.setValue("");
        ComTalk.setValue("");
        ComGame.setValue("");
        ComLanguage.setValue("");
        TFComment.clear();
        TFAddress.setEditable(false);
        TFEmail.setEditable(false);
        ComLevel.setDisable(true);
        ComDJYear.setDisable(true);
        ComDJMonth.setDisable(true);
        ComDJDay.setDisable(true);
        ComEDYear.setDisable(true);
        ComEDMonth.setDisable(true);
        ComEDDay.setDisable(true);
        ComAbiliti.setDisable(true);
        ComOpera.setDisable(true);
        ComTalk.setDisable(true);
        ComGame.setDisable(true);
        GomCash.setDisable(true);
        ComLanguage.setDisable(true);
        TFComment.setEditable(false);
        BTConfirmEdit.setDisable(true);
        BTDelete.setDisable(true);
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
        LeaderName.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhone.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevel.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderOfferDate.setCellValueFactory(new PropertyValueFactory<>("leaderDateJoin"));
        LeaderEndDate.setCellValueFactory(new PropertyValueFactory<>("leaderEndDate"));  
        LeaderAddress.setCellValueFactory(new PropertyValueFactory<>("leaderAdress"));
        LeaderCETService.setCellValueFactory(new PropertyValueFactory<>("leaderService"));
        LeaderCETGame.setCellValueFactory(new PropertyValueFactory<>("leaderCetGame"));
        LeaderCETLanguage.setCellValueFactory(new PropertyValueFactory<>("leaderCetLang"));
        LeaderCETOpera.setCellValueFactory(new PropertyValueFactory<>("leaderCetOpra"));
        LeaderCETTalk.setCellValueFactory(new PropertyValueFactory<>("leaderCetTalk"));
        LeaderCollector.setCellValueFactory(new PropertyValueFactory<>("leaderCashCol"));
        LeaderTable.setItems(data);
    }

    @FXML
    private void EditLLeader(ActionEvent event) {
        if(LeaderTable.getSelectionModel().isEmpty()){
            LabelEmpty.setText("Please Select Leader");
        }else{
            LeaderTable LeaderT = LeaderTable.getSelectionModel().getSelectedItem();
            LabelEmpty.setText("");
            TFAddress.setEditable(true);
            TFEmail.setEditable(true);
            ComLevel.setDisable(false);
            ComLevel.setItems(namelevellist);
            ComDJYear.setDisable(false);
            ComDJYear.setItems(yearlist);
            ComDJMonth.setDisable(false);
            ComDJMonth.setItems(monthlist);
            ComDJDay.setDisable(false);
            ComDJDay.setItems(daylist);
            ComEDYear.setDisable(false);
            ComEDYear.setItems(yearlist);
            ComEDMonth.setDisable(false);
            ComEDMonth.setItems(monthlist);
            ComEDDay.setDisable(false);
            ComEDDay.setItems(daylist);
            ComAbiliti.setDisable(false);
            ComAbiliti.setItems(levellist);
            ComOpera.setDisable(false);
            ComOpera.setItems(levellist);
            ComTalk.setDisable(false);
            ComTalk.setItems(levellist);
            ComGame.setDisable(false);
            ComGame.setItems(levellist);
            ComLanguage.setDisable(false);
            ComLanguage.setItems(levellist);
            GomCash.setDisable(false);
            GomCash.setItems(CashCollector);
            TFComment.setEditable(true);
            BTConfirmEdit.setDisable(false);
            BTDelete.setDisable(false);
            IDLeader = LeaderT.getLeaderId();
            NameLeader = LeaderT.getLeaderName();
        }
    }

    @FXML
    private void DeletePanel(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Leaders/LeaderDeletePanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Delete Leader");
        appstage.show();
    }

    @FXML
    private void LeaderConfirmEdit(ActionEvent event) throws SQLException {
        String joindate =ComDJYear.getValue()+"-"+ComDJMonth.getValue()+"-"+ComDJDay.getValue();
        String endDate =ComEDYear.getValue()+"-"+ComEDMonth.getValue()+"-"+ComEDDay.getValue();
 
        auth cnx = new auth();
        try (Statement stt = cnx.connect().createStatement()) {
            String query = "UPDATE leader SET level='"+ComLevel.getValue()+"', datejoin='"+joindate+"', dateend='"+endDate+"', service='"+ComAbiliti.getValue()+"', address='"+TFAddress.getText()+"', email='"+TFEmail.getText()+"', leadcomment='"+TFComment.getText()+"', cettalk='"+ComTalk.getValue()+"', opera='"+ComOpera.getValue()+"', languageskill='"+ComLanguage.getValue()+"', cetgame='"+ComGame.getValue()+"', cashcollector='"+GomCash.getValue()+"' WHERE idleader ="+IDLeader;
            stt.executeUpdate(query);
            stt.close();
           
            LabelEmpty.setText("Leader Updated successfully");
        }
        TFAddress.clear();
        TFEmail.clear();
        ComLevel.setValue("");
        ComDJYear.setValue("");
        ComDJMonth.setValue("");
        ComDJDay.setValue("");
        ComEDYear.setValue("");
        ComEDMonth.setValue("");
        ComEDDay.setValue("");
        ComAbiliti.setValue("");
        ComOpera.setValue("");
        ComTalk.setValue("");
        ComGame.setValue("");
        ComLanguage.setValue("");
        TFComment.clear();
        TFAddress.setEditable(false);
        TFEmail.setEditable(false);
        ComLevel.setDisable(true);
        ComDJYear.setDisable(true);
        ComDJMonth.setDisable(true);
        ComDJDay.setDisable(true);
        ComEDYear.setDisable(true);
        ComEDMonth.setDisable(true);
        ComEDDay.setDisable(true);
        ComAbiliti.setDisable(true);
        ComOpera.setDisable(true);
        ComTalk.setDisable(true);
        ComGame.setDisable(true);
        GomCash.setDisable(true);
        ComLanguage.setDisable(true);
        TFComment.setEditable(false);
        BTConfirmEdit.setDisable(true);
        BTDelete.setDisable(true);
    }

    @FXML
    private void AddLeader(ActionEvent event) throws IOException {
        cus1.setMyname(null);
        cus1.setMyID(null);
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Leaders/AddLeaderPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Leader");
        appstage.show();
    }

    @FXML
    private void TFSearchLeader(KeyEvent event) {
        if (RadioName.isSelected()){
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT leader.idleader, customer.fullname , customer.phonecus ,leader.level, leader.datejoin, leader.dateend, leader.service, leader.address, leader.email, leader.leadcomment, leader.cettalk, leader.opera, leader.languageskill, leader.cetgame, leader.cashcollector FROM leader INNER JOIN customer ON leader.idleader=customer.idleader where leader.statu = 'Active' and customer.fullname like '%"+SearchField.getText().toUpperCase()+"%' ORDER BY customer.fullname ASC"; 
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
        LeaderName.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhone.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevel.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderOfferDate.setCellValueFactory(new PropertyValueFactory<>("leaderDateJoin"));
        LeaderEndDate.setCellValueFactory(new PropertyValueFactory<>("leaderEndDate"));  
        LeaderAddress.setCellValueFactory(new PropertyValueFactory<>("leaderAdress"));
        LeaderCETService.setCellValueFactory(new PropertyValueFactory<>("leaderService"));
        LeaderCETGame.setCellValueFactory(new PropertyValueFactory<>("leaderCetGame"));
        LeaderCETLanguage.setCellValueFactory(new PropertyValueFactory<>("leaderCetLang"));
        LeaderCETOpera.setCellValueFactory(new PropertyValueFactory<>("leaderCetOpra"));
        LeaderCETTalk.setCellValueFactory(new PropertyValueFactory<>("leaderCetTalk"));
        LeaderCollector.setCellValueFactory(new PropertyValueFactory<>("leaderCashCol"));
        LeaderTable.setItems(data);
        }
        if (RadioLevel.isSelected()){
            auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT leader.idleader, customer.fullname , customer.phonecus ,leader.level, leader.datejoin, leader.dateend, leader.service, leader.address, leader.email, leader.leadcomment, leader.cettalk, leader.opera, leader.languageskill, leader.cetgame, leader.cashcollector FROM leader INNER JOIN customer ON leader.idleader=customer.idleader where leader.statu = 'Active' and leader.level like '"+SearchField.getText().toUpperCase()+"%' ORDER BY customer.fullname ASC"; 
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
        LeaderName.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        LeaderPhone.setCellValueFactory(new PropertyValueFactory<>("leaderPhone"));
        LeaderLevel.setCellValueFactory(new PropertyValueFactory<>("leaderLevel"));
        LeaderOfferDate.setCellValueFactory(new PropertyValueFactory<>("leaderDateJoin"));
        LeaderEndDate.setCellValueFactory(new PropertyValueFactory<>("leaderEndDate"));  
        LeaderAddress.setCellValueFactory(new PropertyValueFactory<>("leaderAdress"));
        LeaderCETService.setCellValueFactory(new PropertyValueFactory<>("leaderService"));
        LeaderCETGame.setCellValueFactory(new PropertyValueFactory<>("leaderCetGame"));
        LeaderCETLanguage.setCellValueFactory(new PropertyValueFactory<>("leaderCetLang"));
        LeaderCETOpera.setCellValueFactory(new PropertyValueFactory<>("leaderCetOpra"));
        LeaderCETTalk.setCellValueFactory(new PropertyValueFactory<>("leaderCetTalk"));
        LeaderCollector.setCellValueFactory(new PropertyValueFactory<>("leaderCashCol"));
        LeaderTable.setItems(data1);
        }
    }

    @FXML
    private void MenuItemCustomerlunch(ActionEvent event) {
    }

    
}
