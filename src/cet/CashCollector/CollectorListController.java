/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.CashCollector;

import cet.Cstomers.CustomersTable;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class CollectorListController implements Initializable {

    @FXML
    private TableColumn<CollectorTable, String> NameCol;
    @FXML
    private TableColumn<CollectorTable, String> AdressCol;
    @FXML
    private TableColumn<CollectorTable, String> PhoneCol;
    @FXML
    private Button BTSelect;
    @FXML
    private Button BTcancel;
    private ObservableList<CollectorTable>data ;
    @FXML
    private TableView<CollectorTable> ColloctorTable;
    
    private static String CollectorID = null;
    private static String CollectorName = null;
    public String getCollectorID() {
        return CollectorID;    
    }
    public String getCollectorName() {
        return CollectorName;    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auth cnx = new auth();
            try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT leader.idleader, customer.fullname , customer.phonecus ,leader.level, leader.datejoin, leader.dateend, leader.service, leader.address, leader.email, leader.leadcomment, leader.cettalk, leader.opera, leader.languageskill, leader.cetgame FROM leader INNER JOIN customer ON leader.idleader=customer.idleader where leader.statu = 'Active' and leader.cashcollector ='Yes' ORDER BY customer.fullname ASC"; //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
            ResultSet rs = st.executeQuery(query);
            data = FXCollections.observableArrayList();
            while (rs.next())
            {
                data.add(new CollectorTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                ));  
                
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CollectorListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        NameCol.setCellValueFactory(new PropertyValueFactory<>("cashCollectorName"));//
        AdressCol.setCellValueFactory(new PropertyValueFactory<>("cashCollectorAddress"));//
        PhoneCol.setCellValueFactory(new PropertyValueFactory<>("cashCollectorPhone"));
        ColloctorTable.setItems(data);
    }    

    @FXML
    private void Select(ActionEvent event) throws IOException {
        if(ColloctorTable.getSelectionModel().isEmpty()==false){
            CollectorTable collector= ColloctorTable.getSelectionModel().getSelectedItem();
            CollectorID = collector.getCashCollectorID();
            CollectorName = collector.getCashCollectorName();
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

    @FXML
    private void Cancel(ActionEvent event) throws IOException {
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
