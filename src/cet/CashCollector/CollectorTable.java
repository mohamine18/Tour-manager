/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.CashCollector;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Amine
 */
public class CollectorTable {
     private final SimpleStringProperty cashCollectorID;
    private final SimpleStringProperty cashCollectorName;
    private final SimpleStringProperty cashCollectorAddress;
    private final SimpleStringProperty cashCollectorPhone;
    
    public CollectorTable(String id,String name, String address,String phone) {
        this.cashCollectorID = new SimpleStringProperty(id);
        this.cashCollectorName = new SimpleStringProperty(name);
        this.cashCollectorAddress = new SimpleStringProperty(address);
        this.cashCollectorPhone = new SimpleStringProperty(phone);  
    }
    public String getCashCollectorID() {
        return cashCollectorID.get();
    }
    public String getCashCollectorName() {
        return cashCollectorName.get();
    }
    public String getCashCollectorAdress() {
        return cashCollectorAddress.get();
    }
    public String getCashCollectorPhone() {
        return cashCollectorPhone.get();
    }
}
