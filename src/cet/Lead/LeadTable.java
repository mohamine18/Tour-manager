/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Lead;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author amine
 */
public class LeadTable {
    private final SimpleStringProperty tripName;
    private final SimpleStringProperty tripDate;
    private final SimpleStringProperty leaderName;
    private final SimpleStringProperty assistant1Name;
    private final SimpleStringProperty assistant2Name;
    private final SimpleStringProperty assistant3Name;
    private final SimpleStringProperty assistant4Name;

    
    public LeadTable(String tripName1,String tripDate1, String LeaderName1, String Assistant1Name1,String Assistant2Name2, String Assistant3Name3,String Assistant4Name4) {
        this.tripName = new SimpleStringProperty(tripName1);
        this.tripDate = new SimpleStringProperty(tripDate1);
        this.leaderName = new SimpleStringProperty(LeaderName1);
        this.assistant1Name = new SimpleStringProperty(Assistant1Name1);
        this.assistant2Name = new SimpleStringProperty(Assistant2Name2);
        this.assistant3Name = new SimpleStringProperty(Assistant3Name3);
        this.assistant4Name = new SimpleStringProperty(Assistant4Name4);
    }
    
    public String getTripName() {
        return tripName.get();
    }
    public String getTripDate() {
        return tripDate.get();
    }
    public String getLeaderName() {
        return leaderName.get();
    }    
    public String getAssistant1Name() {
        return assistant1Name.get();
    }    
    public String getAssistant2Name() {
        return assistant2Name.get();
    }    
    public String getAssistant3Name() {
        return assistant3Name.get();
    }    
    public String getAssistant4Name() {
        return assistant4Name.get();
    }
    
}
