/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Trips;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class TripDeletePanleController implements Initializable {

    @FXML
    private Label DeleteLabel;
    @FXML
    private Font x1;
    @FXML
    private Font x2;
    
    TrippageController tripc = new TrippageController();
    @FXML
    private ChoiceBox<String> ChDelete;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DeleteLabel.setText(tripc.getMyTrip());
    }    

    @FXML
    private void DeleteConfirm(ActionEvent event) throws SQLException {
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
        String query = "UPDATE trips SET statu='Deactivate' WHERE idtrip="+tripc.getMyID();
        st.executeUpdate(query);
        st.close();
        }
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }

    @FXML
    private void CancelDelete(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }
    
}
