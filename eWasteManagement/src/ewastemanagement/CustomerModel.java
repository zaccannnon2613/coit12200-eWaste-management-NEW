/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

import static java.awt.SystemColor.window;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330,12195928
 *Campus: Townsville
 *File Description: manages the search for customer
 */
public class CustomerModel {

    //variables for the connection are initialized
    private static final String URL = "jdbc:mysql://localhost/ewmsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";

    //connection and prepared statements are initliazed
    private Connection connection = null;
    private PreparedStatement selectByName = null;
    private PreparedStatement selectByAddress = null;
    private PreparedStatement selectByMobile = null;
    private PreparedStatement insertNewCustomer = null;
    private PreparedStatement updateCustomer = null;
    private PreparedStatement selectByID = null;

    public CustomerModel() {
        //connects to the database and uses the prepared statements
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectByName = connection.prepareStatement("SELECT * FROM customer WHERE fName = ?");
            selectByAddress = connection.prepareStatement("SELECT * FROM customer where strNo = ? and strName = ?");
            selectByMobile = connection.prepareStatement("SELECT * FROM customer WHERE mobile = ?");
            insertNewCustomer = connection.prepareStatement("INSERT INTO customer"
                    + "( fName, lName, mobile, email, strNo, strName, suburb, tipsCounter)"
                    + "values (?,?,?,?,?,?,?,?)");
            updateCustomer = connection.prepareStatement("UPDATE customer"
                    + "SET mobile = ?, email = ?"
                    + "Where customerID = ?");
            selectByID = connection.prepareStatement("SELECT * FROM customer WHERE customerID = ?");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //add customer to the database
    public int addCustomer(String firstName, String lastName, String mobile,
            String email, int streetNum, String streetName, String suburb, int tipCounter) {
        int result = 0;

        try {
            //gets text from the textfields
            insertNewCustomer.setString(1, firstName);
            insertNewCustomer.setString(2, lastName);
            insertNewCustomer.setString(3, mobile);
            insertNewCustomer.setString(4, email);
            insertNewCustomer.setInt(5, streetNum);
            insertNewCustomer.setString(6, streetName);
            insertNewCustomer.setString(7, suburb);
            insertNewCustomer.setInt(8, tipCounter);

            result = insertNewCustomer.executeUpdate();//adds text to database
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //gets the customer name from the database
    public List<Customer> getCustomerByName(String name) {
        List<Customer> result = null;
        ResultSet rs = null;

        try {
            selectByName.setString(1, name);
            rs = selectByName.executeQuery();
            result = new ArrayList<Customer>();
            //loops through the database
            while (rs.next()) {
                result.add(new Customer(rs.getInt("customerID"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getInt("strNo"),
                        rs.getString("strName"),
                        rs.getString("suburb"),
                        rs.getInt("tipsCounter")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();//closes connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    //gets customer from address
    public List<Customer> getCustomerByAddress(String strNo, String strName) {
        List<Customer> result = null;
        ResultSet rs = null;

        try {
            //sets the strNo and strName into the prepared statement
            selectByAddress.setString(1, strNo);
            selectByAddress.setString(2, strName);
            rs = selectByAddress.executeQuery();//execu8tes prepared statement
            result = new ArrayList<Customer>();

            while (rs.next()) {
                result.add(new Customer(rs.getInt("customerID"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getInt("strNo"),
                        rs.getString("strName"),
                        rs.getString("suburb"),
                        rs.getInt("tipsCounter")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();//closes connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public List<Customer> getCustomerByMobile(String mobile) {
        List<Customer> result = null;
        ResultSet rs = null;

        try {
            selectByMobile.setString(1, mobile);
            rs = selectByMobile.executeQuery();
            result = new ArrayList<Customer>();

            while (rs.next()) {
                result.add(new Customer(rs.getInt("customerID"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getInt("strNo"),
                        rs.getString("strName"),
                        rs.getString("suburb"),
                        rs.getInt("tipsCounter")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();//closes connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public int updateCustomer(int customerID, String email, String mobile) {
        int result = 0;
        ResultSet rs = null;

        try {
            selectByID.setString(1, mobile);
            selectByID.setString(2, email);
            selectByID.setInt(3, customerID);
            rs = selectByID.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int tripCounter(int tipsCounter) {
        
        if (tipsCounter == 0) {
            displayAlert();
            
        } else {

        }
        return 0;
    }

    //makes and displays an alert

    public void displayAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("Cannot Book, no trips left");
        alert.show();
        System.exit(1);
    }
}
