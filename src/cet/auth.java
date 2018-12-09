/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

/**
 *
 * @author Amine
 */
public class auth {
    
    // Database Connection 
    
    private  String url = null;
    private final String user = "postgres";
    private final String password = "1991";
    
    public  void FileReader(){
        try {
            String fileName = "C:\\CET\\Temp.txt";
            String line = null;
            FileReader fileReader =  new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                url = line;
            } 
            bufferedReader.close();  
            }catch(FileNotFoundException ex){
                System.out.println("Unable to open file 'temp.txt'"); 
                ex.printStackTrace();
                }catch(IOException ex) {
                    System.out.println("Error reading file 'temp.txt'");                  
                    ex.printStackTrace();
            }
    }

    public Connection connect() {
            FileReader();
            Connection cnx = null;
            try {
                cnx = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            return cnx;   
        }
    
    //User Auth
    
    
    String msg =null;
    public String auth (String username,String pass) throws SQLException{
        Statement st = connect().createStatement();
        String query = "SELECT username, userpw FROM cetuser where username ='"+username+"'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
            {
                String firstName = rs.getString("username");
                String userpass = rs.getString("userpw");   
                if (username.equalsIgnoreCase(firstName)){
                    if (pass.equals(userpass)){
                        msg = "Connected";
                    }else { 
                        msg = "Password incorrect";
                    }
                }else {
                    msg = "Username incorrect";
                }
            
            }
        st.close();
        return msg; 
    }

    
    
}
