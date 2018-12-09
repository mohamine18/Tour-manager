/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Leaders;

import cet.auth;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class LeaderDeletePanelController implements Initializable {

    @FXML
    private Font x2;
    @FXML
    private Label DeleteLabel;
    @FXML
    private Font x1;

    /**
     * Initializes the controller class.
     */
    LeaderPageController leaderc =new LeaderPageController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DeleteLabel.setText(leaderc.getNameLeader());
    }    

    @FXML
    private void DeleteConfirm(ActionEvent event) throws SQLException {
        auth cnx = new auth();
        try (Statement st = cnx.connect().createStatement()) {
        String query = "UPDATE leader SET statu='Deactivate' WHERE idleader="+leaderc.getLeaderID();
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
