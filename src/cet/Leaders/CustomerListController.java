/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Leaders;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import cet.Cstomers.CustomersTable ;
import cet.auth;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class CustomerListController implements Initializable {

    @FXML
    private TextField TFSearch;
    @FXML
    private RadioButton RBName;
    @FXML
    private RadioButton RBPhone;
    @FXML
    private TableView<CustomersTable> CusTable;
    @FXML
    private Font x1;
    @FXML
    private TableColumn<CustomersTable, String> CusNameCol;
    @FXML
    private TableColumn<CustomersTable, String> CusGenCol;
    @FXML
    private TableColumn<CustomersTable, String> CusCIDCol;
    @FXML
    private TableColumn<CustomersTable, String> CusPhoneCol;
    @FXML
    private TableColumn<CustomersTable, String> CusCountryCol;
    @FXML
    private TableColumn<CustomersTable, String> CusDOBCol;
    
    private ObservableList<CustomersTable>data ;
    private static  String ID = null;
    private static String Custom = null;
    
    public String getMyName() {
        return Custom;    
    }
    public String getMyID() {
        return ID;    
    }
    public void setMyname(String cusname) {
        this.Custom = cusname;
    }
    public void setMyID(String cusID) {
        this.ID = cusID;
    }
    /**
     * Initializes the controller class.
     */
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final ToggleGroup SearchRadiogroup = new ToggleGroup();
        RBName.setToggleGroup(SearchRadiogroup);
        RBPhone.setToggleGroup(SearchRadiogroup);
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT * FROM customer ORDER BY fullname ASC"; //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
            ResultSet rs = st.executeQuery(query);
            data = FXCollections.observableArrayList();
            while (rs.next())
            {
                data.add(new CustomersTable(
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
        } catch (SQLException ex) {
            Logger.getLogger(CustomerListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CusNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
        CusGenCol.setCellValueFactory(new PropertyValueFactory<>("gender"));//
        CusCIDCol.setCellValueFactory(new PropertyValueFactory<>("ppd"));
        CusPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));//
        CusCountryCol.setCellValueFactory(new PropertyValueFactory<>("cont"));
        CusDOBCol.setCellValueFactory(new PropertyValueFactory<>("dateob"));
        CusTable.setItems(data);
    }    

    @FXML
    private void TFSearchName(KeyEvent event) throws SQLException {
        auth cnx = new auth();
        if (RBName.isSelected()){
            try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT * FROM customer where  fullname like '%"+ TFSearch.getText().toUpperCase()+"%' ORDER BY fullname ASC"; //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
            ResultSet rs = st.executeQuery(query);
            data = FXCollections.observableArrayList();
            while (rs.next())
            {
                data.add(new CustomersTable(
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
        CusNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
        CusGenCol.setCellValueFactory(new PropertyValueFactory<>("gender"));//
        CusCIDCol.setCellValueFactory(new PropertyValueFactory<>("ppd"));
        CusPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));//
        CusCountryCol.setCellValueFactory(new PropertyValueFactory<>("cont"));
        CusDOBCol.setCellValueFactory(new PropertyValueFactory<>("dateob"));
        CusTable.setItems(data);
            }else{
            if (RBPhone.isSelected()){
                try (Statement st = cnx.connect().createStatement()) {
                String query = "SELECT * FROM customer where  phonecus like '"+ TFSearch.getText().toUpperCase()+"%' ORDER BY fullname ASC"; //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
                ResultSet rs = st.executeQuery(query);
                data = FXCollections.observableArrayList();
                while (rs.next())
                {
                    data.add(new CustomersTable(
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
                CusNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
                CusGenCol.setCellValueFactory(new PropertyValueFactory<>("gender"));//
                CusCIDCol.setCellValueFactory(new PropertyValueFactory<>("ppd"));
                CusPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));//
                CusCountryCol.setCellValueFactory(new PropertyValueFactory<>("cont"));
                CusDOBCol.setCellValueFactory(new PropertyValueFactory<>("dateob"));
                CusTable.setItems(data);
            }
        }
    }

    @FXML
    private void SelectPressed(ActionEvent event) throws IOException {
        if (CusTable.getSelectionModel().isEmpty()==false){
        CustomersTable Customer = CusTable.getSelectionModel().getSelectedItem();
        ID = Customer.getID();
        Custom = Customer.getFullName();
        
        Stage appstage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage1.close();
        
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/AddLeaderPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Leader");
        appstage.show();
        }
    }

    @FXML
    private void CancelPressed(ActionEvent event) throws IOException {
        Stage appstage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage1.close();
        
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/AddLeaderPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Leader");
        appstage.show();
    }
    
}
