/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


/**
 *
 * @author Amine
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label err;
    @FXML
    private ImageView img;
    @FXML
    private Insets x1;
    @FXML
    private Button login;
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        String name = username.getText();
        String pass = password.getText();
        if (name.equals("") || pass.equals("")){
            err.setText("Type your username and password");
        }else {
            auth cnx = new auth();
            String au = cnx.auth(name,pass);
            if (au.equals("Connected")){
                Parent pageparent = FXMLLoader.load(getClass().getResource("Customerpage.fxml"));
                Scene pagescene = new Scene(pageparent);
                Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appstage.setScene(pagescene);
                appstage.centerOnScreen();
                appstage.setTitle("CET Customers Managment");
                appstage.setResizable(true);
                appstage.show();
            }else {
                err.setText(au);
            }
            
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void showcustomer(KeyEvent event) throws SQLException, IOException {
        String name = username.getText();
        String pass = password.getText();
        if (name.equals("") || pass.equals("")){
            err.setText("Type your username and password");
        }else {
            auth cnx = new auth();
            String au = cnx.auth(name,pass);
            if (au.equals("Connected")){
                Parent pageparent = FXMLLoader.load(getClass().getResource("Customerpage.fxml"));
                Scene pagescene = new Scene(pageparent);
                Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appstage.setScene(pagescene);
                appstage.setResizable(true);
                appstage.setMaximized(false);
                appstage.setMaximized(true);
                appstage.setTitle("CET Customers Managment");
                appstage.show();
            }else {
                err.setText(au);
            }
            
        }
    }

}






