/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Goto;

import cet.CashCollector.CollectorListController;
import cet.auth;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class AddGotoController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField TFNameHiker;
    @FXML
    private ComboBox<String> ChAddHikerMP;
    @FXML
    private TextField TFHikerAmount;
    @FXML
    private ComboBox<String> ChAddHikerPM;
    @FXML
    private Font x2;
    
    private String CusId = null, Tripid = null;
    private String ColId = null;
    ObservableList<String> PMlist = FXCollections.observableArrayList("Wechat","Alipay","Cash");
    ObservableList<String> MPlist = FXCollections.observableArrayList("LiangmaqiaoSubway station","South gate of UIBE","Weigongcun Subway station","South gate of BLCU");
    @FXML
    private TextField TFNameTrip;
    /**
     * Initializes the controller class.
     */
    
    CustomerListController cus1 = new CustomerListController();
    TripListController trip1 = new TripListController();
    CollectorListController collector = new CollectorListController();
    @FXML
    private Label GotoLabel;
    @FXML
    private Label CollectorLabel;
    @FXML
    private TextField TFCollector;
    @FXML
    private Button BTselectCollector;
    private static String CashSelected = null;
    public String getCashSelected() {
        return CashSelected;    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChAddHikerPM.setItems(PMlist);
        ChAddHikerMP.setItems(MPlist);
        TFNameHiker.setText(cus1.getMyName());
        TFNameTrip.setText(trip1.getMyName());
        TFHikerAmount.setText(trip1.getTripPrice());
        
        CusId = cus1.getMyID();
        Tripid = trip1.getMyID();
        
        if(CashSelected!=null){
            TFCollector.setText(collector.getCollectorName());
            ColId=collector.getCollectorID();
            ChAddHikerPM.setValue("Cash");
            CollectorLabel.setVisible(true);
            TFCollector.setVisible(true);
            BTselectCollector.setVisible(true);
        }

    }    

    @FXML
    private void SelectCustomer(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Goto/CustomerList.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Select Customer");
        appstage.show();
 
    }

    @FXML
    private void AddHiker(ActionEvent event) throws IOException, SQLException {
        if((TFNameHiker.getText()==null)||(TFNameTrip.getText()==null)||(TFHikerAmount.getText()==null)||(ChAddHikerMP.getValue()==null)||(ChAddHikerPM.getValue()==null)){
            GotoLabel.setText("All Fields are Required");
        }else{
            auth cnx = new auth();
            int value = 0 ;
            try (Statement st = cnx.connect().createStatement()) {
                String query = "SELECT COUNT(idtrip) FROM goto where idtrip ="+Tripid;
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                    {
                    value = Integer.parseInt(rs.getString(1));
                    }
                String insertquery = "INSERT INTO goto(idcus, idtrip, meetp, amount, paymentm, statu, paymentnumber,cashcollector)VALUES "
                 + "('"+CusId+"', '"+Tripid+"','"+ChAddHikerMP.getValue()+"','"+TFHikerAmount.getText()+"','"+ChAddHikerPM.getValue()+"', 'Active', '"+trip1.getTripShort()+(value+1)+"',"+ColId+")";
                st.executeUpdate(insertquery);
                st.close();
                rs.close();
                GotoLabel.setText("Added successfully -> PN: " +trip1.getTripShort()+(value+1));
                TFNameHiker.clear();
                TFNameTrip.clear();
                TFHikerAmount.clear();
                ChAddHikerMP.setValue("");
                ChAddHikerPM.setValue("");
                CusId = null ;
                Tripid = null ;
                ColId = null ;
            }
            
            
        }
         
    }

    @FXML
    private void CancelAddHiker(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }

    @FXML
    private void SelectTrip(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Goto/TripList.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Select Trip");
        appstage.show();
    }

    @FXML
    private void CashSelected(ActionEvent event) {
        if(ChAddHikerPM.getValue().equals("Cash")){
            CollectorLabel.setVisible(true);
            TFCollector.setVisible(true);
            BTselectCollector.setVisible(true);
            TFCollector.setText(null);
        }else{
            CollectorLabel.setVisible(false);
            TFCollector.setVisible(false);
            BTselectCollector.setVisible(false);
            CashSelected = null;
            ColId = null ;
        }
    }

    @FXML
    private void selectCollector(ActionEvent event) throws IOException {
        CashSelected="1";
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/CashCollector/CollectorList.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.setResizable(false);
        appstage.setTitle("Select Cash Collector");
        appstage.show();
    }
    
}
