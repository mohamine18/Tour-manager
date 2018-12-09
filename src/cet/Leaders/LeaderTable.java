/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet.Leaders;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Amine
 */
public class LeaderTable {
    
    private final SimpleStringProperty leaderId;
    private final SimpleStringProperty leaderName;
    private final SimpleStringProperty leaderPhone;
    private final SimpleStringProperty leaderLevel;
    private final SimpleStringProperty leaderDateJoin;
    private final SimpleStringProperty leaderEndDate;
    private final SimpleStringProperty leaderService;
    private final SimpleStringProperty leaderAdress;
    private final SimpleStringProperty leaderEmail;
    private final SimpleStringProperty leaderComment;
    private final SimpleStringProperty leaderCetTalk;
    private final SimpleStringProperty leaderCetGame;
    private final SimpleStringProperty leaderCetLang;
    private final SimpleStringProperty leaderCetOpra;
    private final SimpleStringProperty leaderCashCol;
    
    public LeaderTable(String ID, String LName, String LPhone,String LLevel, String LDateJoin,String LEndDate, String LService, String LAdress, String LEmail, String LComment,String LCettalk,String LCetgame,String LCetlang,String LCetopra, String LcashSol) {
        this.leaderId = new SimpleStringProperty(ID);
        this.leaderName = new SimpleStringProperty(LName);
        this.leaderPhone = new SimpleStringProperty(LPhone);
        this.leaderLevel = new SimpleStringProperty(LLevel);
        this.leaderDateJoin = new SimpleStringProperty(LDateJoin);
        this.leaderEndDate = new SimpleStringProperty(LEndDate);
        this.leaderService = new SimpleStringProperty(LService);
        this.leaderAdress = new SimpleStringProperty(LAdress);
        this.leaderEmail = new SimpleStringProperty(LEmail);
        this.leaderComment = new SimpleStringProperty(LComment);
        this.leaderCetTalk = new SimpleStringProperty(LCettalk);
        this.leaderCetGame = new SimpleStringProperty(LCetgame);
        this.leaderCetLang = new SimpleStringProperty(LCetlang);
        this.leaderCetOpra = new SimpleStringProperty(LCetopra);
        this.leaderCashCol = new SimpleStringProperty(LcashSol);
    }
    
    public String getLeaderId() {
        return leaderId.get();
    }
    public String getLeaderName() {
        return leaderName.get();
    }
    public String getLeaderPhone() {
        return leaderPhone.get();
    }
    public String getLeaderLevel() {
        return leaderLevel.get();
    }
    public String getLeaderDateJoin() {
        return leaderDateJoin.get();
    }
    public String getLeaderEndDate() {
        return leaderEndDate.get();
    }
    public String getLeaderService() {
        return leaderService.get();
    }
    public String getLeaderAdress() {
        return leaderAdress.get();
    }
    public String getLeaderEmail() {
        return leaderEmail.get();
    }
    public String getLeaderComment() {
        return leaderComment.get();
    }
    public String getLeaderCetTalk() {
        return leaderCetTalk.get();
    }
    public String getLeaderCetGame() {
        return leaderCetGame.get();
    }
    public String getLeaderCetLang() {
        return leaderCetLang.get();
    }
    public String getLeaderCetOpra() {
        return leaderCetOpra.get();
    }
    public String getLeaderCashCol() {
        return leaderCashCol.get();
    }
}