/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet;

import cet.Cstomers.CustomersTable;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class CustomerpageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList<String> countrieslist = FXCollections.observableArrayList("Other","Afghanistan","Albania","Algeria","Andorra","Argentina", "Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh"
    ,"Belarus","Belgium","Benin","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina Faso","Burma","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Republic","Chad","Chile","China","Colombia","Comoros","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Côte d’Ivoire","Denmark","Djibouti","Ecuador","Egypt","Equatorial Guinea"
    ,"Estonia","Ethiopia","Fiji","Finland","France","Gabon","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Liberia","Libya","Lithuania","Luxembourg"
    ,"Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mexico","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Namibia","Nepal","Netherlands","New Zealand","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palestin","Panama","Papua New Guinea","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Romania","Russia","Rwanda","Réunion"
    ,"Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Somalia","South Africa","South Korea","Spain","Sri Lanka","Sudan","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tunisia","Turkey","Turkmenistan","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan",
    "Venezuela","Vietnam","Western Sahara","Yemen","Zambia","Zimbabwe");
    ObservableList<String> GenderList = FXCollections.observableArrayList("Male","Female");
    ObservableList<String> yearlist = FXCollections.observableArrayList("1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001");
    ObservableList<String> monthlist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");
    ObservableList<String> daylist = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    @FXML
    private Button trip;
    @FXML
    private javafx.scene.control.TableColumn<CustomersTable, String> CusPPID;
    @FXML
    private javafx.scene.control.TableColumn<CustomersTable, String> CusCountry;
    @FXML
    private TableView<CustomersTable> CusTable ;
    @FXML
    private javafx.scene.control.TableColumn<CustomersTable, String> CusName;//
    @FXML
    private javafx.scene.control.TableColumn<CustomersTable, String> CusPhone;//
    @FXML
    private javafx.scene.control.TableColumn<CustomersTable, String> CusGender;//
    @FXML
    private TableColumn<CustomersTable, String> CusDOB;
  
    
    @FXML
    private Button Cus;
    @FXML
    private Font x1;
    @FXML
    private Insets x2;
    @FXML
    private Button load;
    private ObservableList<CustomersTable>data ;
    @FXML
    private Font x4;
    @FXML
    private Insets x3;
    
    @FXML
    private TextField TFName;
    @FXML
    private ChoiceBox<String> TFGender;
    @FXML
    private TextField TFppncid;
    @FXML
    private TextField TFPhone;
    @FXML
    private ComboBox<String> TFCountry;
    @FXML
    private Label LabelEmpty;
    @FXML
    private Button AddButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Font x5;
    @FXML
    private TextField SearchField;
   
    
    @FXML
    private RadioButton RadioName;
    @FXML
    private RadioButton RadioPhone;
    private static  String ID = null;
    private static String Custom = null;
    private static String AppSat = null;
    @FXML
    private ComboBox<String> ChCusYear;
    @FXML
    private ComboBox<String> ChCusMo;
    @FXML
    private ComboBox<String> ChCusDy;
    @FXML
    private Insets x6;
    @FXML
    private MenuItem MenuItemClose;
    @FXML
    private MenuItem MenuItemAddCustomer;
    @FXML
    private MenuItem MenuItemAddTrip;
    @FXML
    private MenuItem MenuItemAddHiker;
    @FXML
    private MenuItem MenuItemConsultLeader;
    @FXML
    private MenuItem MenuItemAddLeader;
    
    public String getMyName() {
        return Custom;    
    }
    public String getMyID() {
        return ID;    
    }
    public String getMyAppSat() {
        return AppSat;    
    }
 
    
    @FXML
    private void ButtonAction(ActionEvent event) throws IOException  {
                Parent pageparent = FXMLLoader.load(getClass().getResource("Trippage.fxml"));
                Scene pagescene = new Scene(pageparent);
                Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appstage.setScene(pagescene);
                appstage.centerOnScreen();
                appstage.setTitle("CET Trips Managment");
                appstage.setMaximized(false);
                appstage.setMaximized(true);
                appstage.show();
                ID = null;
                Custom = null;
                AppSat = null;
    }
    
    @FXML
    private void ActivatField(ActionEvent event) throws IOException {
                Parent pageparent = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
                Scene pagescene = new Scene(pageparent);
                Stage appstage = new Stage();
                appstage.setScene(pagescene);
                appstage.setResizable(false);
                appstage.setTitle("Add Customers");
                appstage.show();
    }
    
    @FXML
    private void MouseClicked(MouseEvent event) {
            TFName.clear();
            TFGender.setDisable(true);
            TFPhone.clear();
            TFppncid.clear();
            TFCountry.setValue("");
            TFName.setEditable(false);
            TFGender.setDisable(true);
            TFppncid.setEditable(false);
            TFPhone.setEditable(false);
            TFCountry.setDisable(true);
            ChCusYear.setDisable(true);
            ChCusMo.setDisable(true);
            ChCusDy.setDisable(true);
            AddButton.setDisable(true);
            DeleteButton.setDisable(true);
            LabelEmpty.setText("");
            CustomersTable Customer = CusTable.getSelectionModel().getSelectedItem();
            TFName.setText(Customer.getFullName());
            TFGender.setValue(Customer.getGender());
            TFppncid.setText(Customer.getPpncid());
            TFPhone.setText(Customer.getPhone());
            TFCountry.setValue(Customer.getcont());
            TFGender.setItems(GenderList); 
            TFCountry.setItems(countrieslist);
            ChCusYear.setValue(Customer.getDateob().substring(0, 4));
            ChCusMo.setValue(Customer.getDateob().substring(5,7));
            ChCusDy.setValue(Customer.getDateob().substring(8,10));
                
            ID = Customer.getID();
            Custom = Customer.getFullName();
    }
    
    @FXML
    private void Getdata(ActionEvent event) {
            if (CusTable.getSelectionModel().isEmpty()){
                LabelEmpty.setText("Select Item First");
            }else{
                LabelEmpty.setText("");
                TFName.setEditable(true);
                TFGender.setDisable(false);
                TFppncid.setEditable(true);
                TFPhone.setEditable(true);
                TFCountry.setDisable(false);
                AddButton.setDisable(false);
                DeleteButton.setDisable(false);
                ChCusYear.setDisable(false);
                ChCusMo.setDisable(false);
                ChCusDy.setDisable(false);

                CustomersTable Customer = CusTable.getSelectionModel().getSelectedItem();
                TFName.setText(Customer.getFullName());
                TFGender.setValue(Customer.getGender());
                TFppncid.setText(Customer.getPpncid());
                TFPhone.setText(Customer.getPhone());
                TFCountry.setValue(Customer.getcont());
                TFGender.setItems(GenderList); 
                TFCountry.setItems(countrieslist);

                ChCusYear.setValue(Customer.getDateob().substring(0, 4));
                ChCusMo.setValue(Customer.getDateob().substring(5,7));
                ChCusDy.setValue(Customer.getDateob().substring(8,10));
                
                ID = Customer.getID();
                Custom = Customer.getFullName();
            }
        
    }
    
    @FXML
    private void LoadData(ActionEvent event) throws SQLException {
        TFName.clear();
        TFGender.setDisable(true);
        TFPhone.clear();
        TFppncid.clear();
        TFCountry.setValue("");
        TFName.setEditable(false);
        TFGender.setDisable(true);
        TFppncid.setEditable(false);
        TFPhone.setEditable(false);
        TFCountry.setDisable(true);
        ChCusYear.setDisable(true);
        ChCusMo.setDisable(true);
        ChCusDy.setDisable(true);
        AddButton.setDisable(true);
        DeleteButton.setDisable(true);
        LabelEmpty.setText("");
        
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
        }

        CusName.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
        CusGender.setCellValueFactory(new PropertyValueFactory<>("gender"));//
        CusPPID.setCellValueFactory(new PropertyValueFactory<>("ppd"));
        CusPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));//
        CusCountry.setCellValueFactory(new PropertyValueFactory<>("cont"));
        CusDOB.setCellValueFactory(new PropertyValueFactory<>("dateob"));
        CusTable.setItems(data);
    }
    
    @FXML
    private void SearchNameField(KeyEvent event) throws SQLException {
        auth cnx = new auth();
        if (RadioName.isSelected()){
            try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT * FROM customer where  fullname like '%"+ SearchField.getText().toUpperCase()+"%'"; //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
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

        CusName.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
        CusGender.setCellValueFactory(new PropertyValueFactory<>("gender"));//
        CusPPID.setCellValueFactory(new PropertyValueFactory<>("ppd"));
        CusPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));//
        CusCountry.setCellValueFactory(new PropertyValueFactory<>("cont"));
        CusDOB.setCellValueFactory(new PropertyValueFactory<>("dateob"));
        CusTable.setItems(data);
            }else{
            if (RadioPhone.isSelected()){
                try (Statement st = cnx.connect().createStatement()) {
                String query = "SELECT * FROM customer where  phonecus like '"+ SearchField.getText().toUpperCase()+"%'"; //idcus, fullname, gender, ppncid, phonecus, country, idvip, idleader
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
                CusName.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
                CusGender.setCellValueFactory(new PropertyValueFactory<>("gender"));//
                CusPPID.setCellValueFactory(new PropertyValueFactory<>("ppd"));
                CusPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));//
                CusCountry.setCellValueFactory(new PropertyValueFactory<>("cont"));
                CusDOB.setCellValueFactory(new PropertyValueFactory<>("dateob"));
                CusTable.setItems(data);
            }
        }
    }
    
    @FXML
    private void ShowDeletePanel(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("DeletePanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Delete Customer");
        appstage.show();
    }
    
    @FXML
    private void ConfirmEdit(ActionEvent event) throws SQLException {
        if(TFName.getText().isEmpty()||TFPhone.getText().isEmpty()){
            LabelEmpty.setText("Name and Phone N° are Required");
            }else{
                if (TFPhone.getText().length()!=11){
                    LabelEmpty.setText("Wrong Phone Number");
                    }else{
                        String Date1 = ChCusYear.getValue()+"-"+ChCusMo.getValue()+"-"+ChCusDy.getValue();
                        auth cnx = new auth();
                        try (Statement st = cnx.connect().createStatement()) {
                            String query = "UPDATE customer SET fullname='"+TFName.getText().toUpperCase()+"', gender='"+TFGender.getValue()+"', ppncid='"+TFppncid.getText()+"', phonecus='"+TFPhone.getText()+"', country='"+TFCountry.getValue()+"', dob='"+Date1+"' WHERE idcus="+getMyID();
                            System.out.println(query);
                            st.close();
                            LabelEmpty.setText("Customer Updated successfully");
                            TFName.clear();
                            TFGender.setDisable(true);
                            TFPhone.clear();
                            TFppncid.clear();
                            TFCountry.setValue("");
                            TFName.setEditable(false);
                            TFGender.setDisable(true);
                            TFppncid.setEditable(false);
                            TFPhone.setEditable(false);
                            TFCountry.setDisable(true);
                            AddButton.setDisable(true);
                            DeleteButton.setDisable(true);

                        }
                    }
                }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuItemClose.setOnAction(e -> Platform.exit());
        MenuItemClose.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        final ToggleGroup SearchRadiogroup = new ToggleGroup();
        RadioName.setToggleGroup(SearchRadiogroup);
        RadioPhone.setToggleGroup(SearchRadiogroup);
        RadioName.setSelected(true);
        ChCusYear.setItems(yearlist);
        ChCusMo.setItems(monthlist);
        ChCusDy.setItems(daylist);
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
            Logger.getLogger(CustomerpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CusName.setCellValueFactory(new PropertyValueFactory<>("fullName"));//
        CusGender.setCellValueFactory(new PropertyValueFactory<>("gender"));//
        CusPPID.setCellValueFactory(new PropertyValueFactory<>("ppd"));
        CusPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));//
        CusCountry.setCellValueFactory(new PropertyValueFactory<>("cont"));
        CusDOB.setCellValueFactory(new PropertyValueFactory<>("dateob"));
        CusTable.setItems(data);
    }    

    private void AddHiker(ContextMenuEvent event) throws IOException {
        CustomersTable Customer = CusTable.getSelectionModel().getSelectedItem();
        ID = Customer.getID();
        Custom = Customer.getFullName();
        AppSat = "CustomerStage";
        Parent pageparent = FXMLLoader.load(getClass().getResource("Goto/AddGoto.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Hiker");
        appstage.show();
    }

    @FXML
    private void MenuItemCustomerlunch(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Customers");
        appstage.show();
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
    private void MenuItemAddTrip(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("Trips/AddTripPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Trip");
        appstage.show();
    }

    @FXML
    private void MenuItemAddHiker(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("Goto/AddGoto.fxml"));
            Scene pagescene = new Scene(pageparent);
            Stage appstage = new Stage();
            appstage.setScene(pagescene);
            appstage.setResizable(false);
            appstage.setTitle("Add Hiker");
            appstage.show(); 
    }

    @FXML
    private void MenuItemConsultLeader(ActionEvent event) throws IOException {
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
    private void MenuItemAddLeader(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getResource("/cet/Leaders/AddLeaderPanel.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = new Stage();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Add Leader");
        appstage.show();
    }
    

}
