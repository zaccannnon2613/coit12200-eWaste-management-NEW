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
public class BookingModel {
    
    private static final String URL = "jdbc:mysql://localhost/ewmsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";
    
    private Connection connection = null;
    private PreparedStatement selectByName = null;
    private PreparedStatement selectByAddress = null;
    private PreparedStatement selectByID = null;
    private PreparedStatement insertBooking = null;
    private PreparedStatement updateBooking = null;
    
    public BookingModel(){
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectByName = connection.prepareStatement("");
            selectByAddress = connection.prepareStatement("");
            selectByID = connection.prepareStatement("");
            insertBooking = connection.prepareStatement("INSERT INTO bookings "
            + "( bookingDate, timeOfPickup, requestDate, strNo, strName, suburb, notes, customerID, wasterID)"
            + "values (?,?,?,?,?,?,?,?,?)");
            updateBooking = connection.prepareStatement("");
         }
         catch (SQLException e){
             e.printStackTrace();
             System.exit(1);
         }
    }
    public int addBooking(String bookingDate, String timeOfPickup, String requestDate,
            int strNo, String streetName, String suburb, String notes, int customerID, int wasteID){
        int result = 0;
        
        try{
            insertBooking.setString(1, bookingDate);
            insertBooking.setString(2, timeOfPickup);
            insertBooking.setString(3, requestDate);
            insertBooking.setInt(4, strNo);
            insertBooking.setString(5, streetName);
            insertBooking.setString(6, suburb);
            insertBooking.setString(7, notes);
            insertBooking.setInt(8, customerID);
            insertBooking.setInt(9, wasteID);
            
            result = insertBooking.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
