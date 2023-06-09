/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330 ,12195928
 *Campus: Townsville
 *File Description: model for the waste details
 */
public class WasteModel {
    //variables for the connection are initialized
    private static final String URL = "jdbc:mysql://localhost/ewmsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";
    //connection and prepared statements are initialized
    private Connection connection = null;
    private PreparedStatement insertWaste = null;
    
    public WasteModel(){
        //connects to the database and uses prepared statements
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            insertWaste = connection.prepareStatement("INSERT INTO wastedetails"
                    + "( wasteType, itemDetails, itemQuantity, customerID)"
                    + "values (?,?,?,?)");
        }
        catch(SQLException e){
        e.printStackTrace();
        System.exit(1);
        }
    }
    //adds waste details to the database
    public int addWaste(String wasteType, String itemDetails, String itemQuantity, int customerID){
        int result = 0;
        
        try{
            //gets text from textfields
            insertWaste.setString(1, wasteType);
            insertWaste.setString(2, itemDetails);
            insertWaste.setString(3, itemQuantity);
            insertWaste.setInt(4, customerID);
            
            
            result = insertWaste.executeUpdate();//executes the prepared statement
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
