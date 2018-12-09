/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Goto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Amine
 */
public class HikerTable {
    private final SimpleStringProperty gotocusID;
    private final SimpleStringProperty gototripID;
    private final SimpleStringProperty gotomeetP;
    private final SimpleStringProperty gotoAmount;
    private final SimpleStringProperty gotoPaym;
    private final SimpleStringProperty gotocusPhone;
    private final SimpleStringProperty gotocusName;
    private final SimpleStringProperty gototripName;
    private final SimpleStringProperty gotopayNum;
    
    public HikerTable(String paymentN,String CusID, String TripID,String tripname1, String cusname1,String cusphone1, String MP,String Amount, String PM) {
        this.gotopayNum = new SimpleStringProperty(paymentN);
        this.gotocusID = new SimpleStringProperty(CusID);
        this.gototripID = new SimpleStringProperty(TripID);
        this.gototripName = new SimpleStringProperty(tripname1);
        this.gotocusName = new SimpleStringProperty(cusname1);
        this.gotocusPhone = new SimpleStringProperty(cusphone1);
        this.gotomeetP = new SimpleStringProperty(MP);
        this.gotoAmount = new SimpleStringProperty(Amount);
        this.gotoPaym = new SimpleStringProperty(PM);
        
        
    }
    public String getGotocusID() {
        return gotocusID.get();
    }
    public String getGototripID() {
        return gototripID.get();
    }
    public String getGotomeetP() {
        return gotomeetP.get();
    }
    public String getGotoAmount() {
        return gotoAmount.get();
    }
    public String getGotoPaym() {
        return gotoPaym.get();
    }
    public String getGotocusPhone() {
        return gotocusPhone.get();
    }
    public String getGotocusName() {
        return gotocusName.get();
    }
    public String getGototripName() {
        return gototripName.get();
    }
    public String getGotopayNum() {
        return gotopayNum.get();
    }
    
//    public StringProperty gotoCusIDProperty(){
//        return gotocusID;
//    }
//    public StringProperty gotoTripIDProperty(){
//        return gototripID;
//    }
//    
    
}