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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class AddLeaderPanelController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField TFLeaderName;
    @FXML
    private Button BTSelectLeader;
    @FXML
    private ComboBox<String> ComDJDy;
    @FXML
    private ComboBox<String> ComDJYear;
    @FXML
    private ComboBox<String> ComDJMo;
    @FXML
    private ComboBox<String> ComEDYear;
    @FXML
    private ComboBox<String> ComEDMo;
    @FXML
    private ComboBox<String> ComEDDy;
    @FXML
    private ChoiceBox<String> ComLevel;
    @FXML
    private TextField TFAddress;
    @FXML
    private TextField TFEmail;
    @FXML
    private ComboBox<String> ComAbi;
    @FXML
    private ComboBox<String> ComTalk;
    @FXML
    private ComboBox<String> ComOpra;
    @FXML
    private ComboBox<String> ComGame;
    @FXML
    private ComboBox<String> ComLang;
    @FXML
    private Button AddButton;
    @FXML
    private Font x2;
    @FXML
    private Button CancelButton;
    @FXML
    private Label LabelErr;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<String> yearlist = FXCollections.observableArrayList("2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    ObservableList<String> levellist = FXCollections.observableArrayList("01","02","03","04","05");
    ObservableList<String> namelevellist = FXCollections.observableArrayList("Senior leader","Intermediate leader","Junior leader","Internship leader","Rookie leader");
    
    CustomerListController cus1 = new CustomerListController();
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = new Date();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TFLeaderName.setText(cus1.getMyName());
        ComDJDy.setValue(dateFormat.format(date).substring(6,8));
        ComDJDy.setItems(daylist);
        ComDJMo.setValue(dateFormat.format(date).substring(4,6));
        ComDJMo.setItems(monthlist);
        ComDJYear.setValue(dateFormat.format(date).substring(0,4));
        ComDJYear.setItems(yearlist);
        ComEDDy.setItems(daylist);
        ComEDMo.setItems(monthlist);
        ComEDYear.setItems(yearlist);
        ComLevel.setItems(namelevellist);
        ComAbi.setItems(levellist);
        ComOpra.setItems(levellist);
        ComLang.setItems(levellist);
        ComTalk.setItems(levellist);
        ComGame.setItems(levellist);
    }    

    @FXML
    private void SelectLeader(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/CustomerList.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Select Customer");
        appstage.show();
    }

    @FXML
    private void AddLeader(ActionEvent event) throws SQLException {
        if(TFLeaderName.getText()==null){
            LabelErr.setText("Please Select Leader");
        }else{
            String Datejoin = ComDJYear.getValue()+"-"+ComDJMo.getValue()+"-"+ComDJDy.getValue();
            String EndDate = ComEDYear.getValue()+"-"+ComEDMo.getValue()+"-"+ComEDDy.getValue();
            auth cnx = new auth();
            int value = 0 ;
            try (Statement st = cnx.connect().createStatement()) {
                String query = "SELECT idleader FROM leader ORDER BY idleader DESC LIMIT 1";
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                    {
                    value = Integer.parseInt(rs.getString(1));
                    }
                String insertquery = "INSERT INTO leader(idleader, level, datejoin, dateend, service, address, email, cettalk, opera, languageskill, cetgame, statu)VALUES "
                            + "("+(value+1)+", '"+ComLevel.getValue()+"', '"+Datejoin+"', '"+EndDate+"', '"+ComAbi.getValue()+"', '"+TFAddress.getText()+"', '"+TFEmail.getText()+"', '"+ComTalk.getValue()+"', '"+ComOpra.getValue()+"', '"+ComLang.getValue()+"', '"+ComGame.getValue()+"', 'Active');";
                st.executeUpdate(insertquery);
                String updatecusquery ="UPDATE customer SET  idleader="+(value+1)+" WHERE idcus ="+cus1.getMyID();
                st.executeUpdate(updatecusquery);  
                st.close();
                rs.close();
                LabelErr.setText("Leader Added successfully");
                TFLeaderName.setText(null);
                ComDJDy.setValue(dateFormat.format(date).substring(6,8));
                ComDJMo.setValue(dateFormat.format(date).substring(4,6));
                ComDJYear.setValue(dateFormat.format(date).substring(0,4));
                ComEDDy.setValue(null);
                ComEDMo.setValue(null);
                ComEDYear.setValue(null);
                ComLevel.setValue(null);
                TFAddress.setText(null);
                TFEmail.setText(null);
                ComAbi.setValue(null);
                ComTalk.setValue(null);
                ComGame.setValue(null);
                ComOpra.setValue(null);
                ComLang.setValue(null);
                
            }
            
        }
    }

    @FXML
    private void CloseStage(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }
    
}
