/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Trips;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Amine
 */
public class TripsInfoTable {
    private final SimpleStringProperty tripName;
    private final SimpleStringProperty tripDate;
    private final SimpleStringProperty numHikers;
    private final SimpleStringProperty numBLCU;
    private final SimpleStringProperty numUIBE;
    private final SimpleStringProperty numWeig;
    private final SimpleStringProperty numLiang;
    
    public TripsInfoTable(String ID, String TName, String TType,String TPrice, String TDate,String TStatu, String TShort) {
        this.tripName = new SimpleStringProperty(ID);
        this.tripDate = new SimpleStringProperty(TName);
        this.numHikers = new SimpleStringProperty(TType);
        this.numBLCU = new SimpleStringProperty(TPrice);
        this.numUIBE = new SimpleStringProperty(TDate);
        this.numWeig = new SimpleStringProperty(TStatu);
        this.numLiang = new SimpleStringProperty(TShort);
    }
    public String getTripName() {
        return tripName.get();
    }
    public String getTripDate() {
        return tripDate.get();
    }
    public String getNumHikers() {
        return numHikers.get();
    }
    public String getNumBLCU() {
        return numBLCU.get();
    }
    public String getNumUIBE() {
        return numUIBE.get();
    }
    public String getNumWeig() {
        return numWeig.get();
    }
    public String getNumLiang() {
        return numLiang.get();
    }
    
    
}
