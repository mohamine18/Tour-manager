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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */



public class ToLeadController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField TFNameTrip;

    /**
     * Initializes the controller class.
     */
    
    private ObservableList<String>data ;
    
    @FXML
    private TextArea Leadersnams;
    
    
    TrippageController trip = new TrippageController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TFNameTrip.setText(trip.getMyTrip()+ " -> "+ trip.getTripDate());
        auth cnx = new auth();
        String current=null;
        String current1=null;
        String current2=null;
        String current3=null;
        String current4=null;
        try (Statement st = cnx.connect().createStatement()) {
            String query = "SELECT c.fullname , s1.fullname , s2.fullname, s3.fullname, s4.fullname FROM lead LEFT JOIN customer c ON (lead.leader=c.idleader) LEFT JOIN customer s1 ON (lead.assistant1=s1.idleader) LEFT JOIN customer s2 ON (lead.assistant2=s2.idleader) LEFT JOIN customer s3 ON (lead.assistant3=s3.idleader) LEFT JOIN customer s4 ON (lead.assistant4=s4.idleader) where lead.idtrip ="+trip.getMyID(); 
            ResultSet rs = st.executeQuery(query);
            int i = 1;
            while (rs.next())
            {
                current = rs.getString(1);
                current1 = rs.getString(2); 
                current2 = rs.getString(3); 
                current3 = rs.getString(4); 
                current4 = rs.getString(5); 
            }
            st.close();
            rs.close();
        }   catch (SQLException ex) {
            Logger.getLogger(ToLeadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Leadersnams.setText("Leader:  "+current+"\n\nAssistant 1:  "+current1+"\n\nAssistant 2:  "+current2+"\n\nAssistant 3:  "+current3+"\n\nAssistant 4:  "+current4+"\n");
      
    }

    @FXML
    private void SelectLeader(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/LeaderList.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Select Leader");
        appstage.show();
    }

    @FXML
    private void SelectAssistant1(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/AssistantList1.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Select Assistant");
        appstage.show();
    }

    @FXML
    private void SelectAssistant2(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/AssistantList2.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Select Leader");
        appstage.show();
    }

    @FXML
    private void SelectAssistant3(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/AssistantList3.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Select Leader");
        appstage.show();
    }

    @FXML
    private void SelectAssistant4(ActionEvent event) throws IOException {
        Parent pageparent = FXMLLoader.load(getClass().getClassLoader().getResource("cet/Leaders/AssistantList4.fxml"));
        Scene pagescene = new Scene(pageparent);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(pagescene);
        appstage.centerOnScreen();
        appstage.setResizable(false);
        appstage.setTitle("Select Leader");
        appstage.show();
    }

    @FXML
    private void ConfirmEdit(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }

    @FXML
    private void CancelPanel(ActionEvent event) {
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.close();
    }

    
}
