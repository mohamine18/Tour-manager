/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Cstomers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Amine
 */
public class CustomersTable {
    
    private final SimpleStringProperty iDcus1;
    private final SimpleStringProperty fullName;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty ppd;
    private final SimpleStringProperty cont;
    private final SimpleStringProperty iDvip;
    private final SimpleStringProperty iDleader;
    private final SimpleStringProperty dateob;
 
    public CustomersTable(String ID, String FName, String Gend,String ppncid1, String Phone1,String count1,String IDvip1,String IDleader1,String dob) {
        this.iDcus1 = new SimpleStringProperty(ID);
        this.fullName = new SimpleStringProperty(FName);
        this.gender = new SimpleStringProperty(Gend);
        this.ppd = new SimpleStringProperty(ppncid1);
        this.phone = new SimpleStringProperty(Phone1);
        this.cont = new SimpleStringProperty(count1);
        this.iDvip = new SimpleStringProperty(IDvip1);
        this.iDleader = new SimpleStringProperty(IDleader1);
        this.dateob = new SimpleStringProperty(dob);
    
    }


    // Get Methodes
    public String getID() {
        return iDcus1.get();
    } 
    public String getFullName() {
        return fullName.get();
    }
    public String getPhone() {
        return phone.get();
    }
    public String getGender() {
        return gender.get();
    }
    public String getPpncid() {
        return ppd.get();
    }
    public String getcont() {
        return cont.get();
    }
    public String getIDvip() {
        return iDvip.get();
    }
    public String getIDleader() {
        return iDleader.get();
    }
    public String getDateob() {
        return dateob.get();
    }

    
    // Set Methodes
    public void setID(String ID) {
        iDcus1.set(ID);
    }
    public void setFullName(String fName) {
        fullName.set(fName);
    }
    public void setPhone(String Phone1) {
        phone.set(Phone1);
    }
    public void setGender(String Gend) {
        gender.set(Gend);
    }
    public void setPPNCID(String ppcd) {
        ppd.set(ppcd);
    }
    public void setcont(String country) {
        cont.set(country);
    }
    public void setIDvip(String IDvip1) {
        iDvip.set(IDvip1);
    }
    public void setIDleader(String IDleader1) {
        iDleader.set(IDleader1);
    }
    public void setDateob(String dob) {
        iDleader.set(dob);
    }
    
    
    public StringProperty fullNameProperty(){
        return fullName;
    }
    public StringProperty iDProperty(){
        return iDcus1;
    }
    public StringProperty phoneProperty(){
        return phone;
    }
    public StringProperty genderProperty(){
        return gender;
    }
    public StringProperty ppdProperty(){
        return ppd;
    }
    public StringProperty contProperty(){
        return cont;
    }
    public StringProperty iDleaderProperty(){
        return iDleader;
    }
    public StringProperty iDvipProperty(){
        return iDvip;
    }
    public StringProperty dateofbProperty(){
        return dateob;
    }
}
