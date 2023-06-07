/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Zac
 */
public class WasteModel {
    
    private static final String URL = "jdbc:mysql://localhost/ewmsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";
    
    private Connection connection = null;
    private PreparedStatement insertWaste = null;
    
    public WasteModel(){
        
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            insertWaste = connection.prepareStatement("");
        }
        catch(SQLException e){
        e.printStackTrace();
        System.exit(1);
        }
    }
}
