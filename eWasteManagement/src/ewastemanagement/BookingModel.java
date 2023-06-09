/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330,12195928
 *Campus: Townsville
 *File Description: model for booking
 */
public class BookingModel {

    //variables for the connection are initialized
    private static final String URL = "jdbc:mysql://localhost/ewmsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";

    //connection and prepared statements are initliazed
    private Connection connection = null;
    private PreparedStatement selectByName = null;
    private PreparedStatement selectByAddress = null;
    private PreparedStatement selectByMobile = null;
    private PreparedStatement insertBooking = null;

    public BookingModel() {

        //connects to the database and uses the prepared statements
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectByName = connection.prepareStatement("Select * from customer"
                    + "left join bookings"
                    + "on customer.customerID = bookings.customerID"
                    + "and customer.fName = ?");
            selectByAddress = connection.prepareStatement("Select * from customer"
                    + "left join bookings"
                    + "on customer.customerID = bookings.customerID"
                    + "and customer.strNo = ? and customer.strName = ?");
            selectByMobile = connection.prepareStatement("Select * from customer"
                    + "left join bookings"
                    + "on customer.customerID = bookings.customerID"
                    + "and customer.mobile = ?");
            insertBooking = connection.prepareStatement("INSERT INTO bookings "
                    + "( bookingDate, timeOfPickup, requestDate, strNo, strName, suburb, notes, customerID, wasteID)"
                    + "values (?,?,?,?,?,?,?,?,?)");

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //adds into the database
    public int addBooking(String bookingDate, String timeOfPickup, String requestDate,
            int strNo, String streetName, String notes,String suburb, int customerID, int wasteID) {
        int result = 0;

        try {//gets the varaibles and inputs it into set positions
            insertBooking.setString(1, bookingDate);
            insertBooking.setString(2, timeOfPickup);
            insertBooking.setString(3, requestDate);
            insertBooking.setInt(4, strNo);
            insertBooking.setString(5, streetName);
            insertBooking.setString(6, notes);
            insertBooking.setString(7, suburb);
            insertBooking.setInt(8, customerID);
            insertBooking.setInt(9, wasteID);

            result = insertBooking.executeUpdate();//executes the prepared statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //gets the details from the database
    public List<Booking> getDetailsByName(String name) {
        List<Booking> result = null;
        ResultSet rs = null;

        try {
            //uses the name to search
            selectByName.setString(1, name);
            rs = selectByName.executeQuery();
            result = new ArrayList<Booking>();
            //loops through the database
            while (rs.next()) {//gets the information from the database
                result.add(new Booking(rs.getInt("bookingID"),
                        rs.getString("bookingDate"),
                        rs.getString("timeOfPickup"),
                        rs.getString("requestDate"),
                        rs.getInt("StrNo"),
                        rs.getString("strName"),
                        rs.getString("notes"),
                        rs.getString("suburb"),
                        rs.getInt("customerID"),
                        rs.getInt("wasteID")));
            }
        }
            catch(SQLException e){
            e.printStackTrace();
        }
            finally{
            try{
                rs.close();//closes connection
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
            return result;
        }
     //gets the details from the database
    public List<Booking> getDetailsByMobile(String mobile) {
        List<Booking> result = null;
        ResultSet rs = null;

        try {
            selectByMobile.setString(1, mobile);
            rs = selectByMobile.executeQuery();
            result = new ArrayList<Booking>();
            //loops through the database
            while (rs.next()) {//gets the information from the database
                result.add(new Booking(rs.getInt("bookingID"),
                        rs.getString("bookingDate"),
                        rs.getString("timeOfPickup"),
                        rs.getString("requestDate"),
                        rs.getInt("StrNo"),
                        rs.getString("strName"),
                        rs.getString("notes"),
                        rs.getString("suburb"),
                        rs.getInt("customerID"),
                        rs.getInt("wasteID")));
            }
        }
            catch(SQLException e){
            e.printStackTrace();
        }
            finally{
            try{
                rs.close();//closes connection
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
            return result;
        }
     //gets the details from the database
    public List<Booking> getDetailsByAddress(String strName, int strNo) {
        List<Booking> result = null;
        ResultSet rs = null;

        try {
            selectByAddress.setInt(1, strNo);
            selectByAddress.setString(2, strName);
            rs = selectByAddress.executeQuery();
            result = new ArrayList<Booking>();
            //loops through the database
            while (rs.next()) {//gets the information from the database
                result.add(new Booking(rs.getInt("bookingID"),
                        rs.getString("bookingDate"),
                        rs.getString("timeOfPickup"),
                        rs.getString("requestDate"),
                        rs.getInt("StrNo"),
                        rs.getString("strName"),
                        rs.getString("notes"),
                        rs.getString("suburb"),
                        rs.getInt("customerID"),
                        rs.getInt("wasteID")));
            }
        }
            catch(SQLException e){
            e.printStackTrace();
        }
            finally{
            try{
                rs.close();//closes connection
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
            return result;
        }
    }
