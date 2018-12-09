/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Trips;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Amine
 */
public class TripTable {
    private final SimpleStringProperty tripID;
    private final SimpleStringProperty tripName;
    private final SimpleStringProperty tripType;
    private final SimpleStringProperty tripPrice;
    private final SimpleStringProperty tripDate;
    private final SimpleStringProperty statu;
    private final SimpleStringProperty shortname;
    
    public TripTable(String ID, String TName, String TType,String TPrice, String TDate,String TStatu, String TShort) {
        this.tripID = new SimpleStringProperty(ID);
        this.tripName = new SimpleStringProperty(TName);
        this.tripType = new SimpleStringProperty(TType);
        this.tripPrice = new SimpleStringProperty(TPrice);
        this.tripDate = new SimpleStringProperty(TDate);
        this.statu = new SimpleStringProperty(TStatu);
        this.shortname = new SimpleStringProperty(TShort);
    }
    
    public String getTripID() {
        return tripID.get();
    }
    public String getTripeName() {
        return tripName.get();
    }
    public String getTripeType() {
        return tripType.get();
    }
    public String getTripPrice() {
        return tripPrice.get();
    }
    public String getTripDate() {
        return tripDate.get();
    }
    public String getStatu() {
        return statu.get();
    } 
    public String getShortname() {
        return shortname.get();
    } 
    
    
    public void setTripName(String TName){
        tripName.set(TName);
    }
    public void setTripID(String ID){
        tripID.set(ID);
    }
    public void setTripType(String TType){
        tripType.set(TType);
    }
    public void setTripPrice(String TPrice){
        tripPrice.set(TPrice);
    }
    public void setTripDate(String TDate){
        tripDate.set(TDate);
    }
    public void setTripStatu(String TStatu){
        statu.set(TStatu);
    }
    public void setTripShort(String TShort){
        shortname.set(TShort);
    }
    
    
    
    public StringProperty tripNameProperty(){
        return tripName;
    }
    public StringProperty tripIDProperty(){
        return tripID;
    }
    public StringProperty tripPriceProperty(){
        return tripPrice;
    }
    public StringProperty tripDateProperty(){
        return tripDate;
    }
    public StringProperty tripTypeProperty(){
        return tripType;
    }
    public StringProperty tripStatuProperty(){
        return statu;
    }
    public StringProperty tripShortProperty(){
        return shortname;
    }
}

