/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Goto;

import cet.TrippageController;
import cet.auth;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class GotoDeletePanelController implements Initializable {

    @FXML
    private Font x2;
    @FXML
    private Label DeleteLabel;
    @FXML
    private ComboBox<String> ChDelete;
    @FXML
    private Font x1;
    ObservableList<String> chdelete = FXCollections.observableArrayList("Added by Mistake","CET Planing Mistake","Customer Matter","Missed Trip");
    
    TrippageController tripc = new TrippageController();
    @FXML
    private Font x3;
    @FXML
    private Label LabelErr;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button CancelBTN;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChDelete.setItems(chdelete);
        DeleteLabel.setText(tripc.getGotoCusName());
        System.out.println(ChDelete.getValue());
    }    


    @FXML
    private void DeleteConfirm1(ActionEvent event) throws SQLException {
        
        if(ChDelete.getValue()==null){
            LabelErr.setText("Please select Reason of Deleting");
        }else{
            auth cnx = new auth();
            try (Statement st = cnx.connect().createStatement()) {
            String query = "UPDATE goto SET  statu='"+ChDelete.getValue()+"' WHERE idcus ="+tripc.getGotoCusID()+" and idtrip ="+tripc.getGotoTripID();
            st.executeUpdate(query);
            st.close();
            }
            Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appstage.close();
        }
    }

    @FXML
    private void CancelDelete1(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }
    
}
