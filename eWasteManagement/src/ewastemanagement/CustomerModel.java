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

/**
 *
 * @author Zac
 */
public class CustomerModel {
    
    private static final String URL = "jdbc:mysql://localhost/ewmsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";
    
    private Connection connection = null;
    private PreparedStatement selectByName = null;
    private PreparedStatement selectByMobile = null;
    private PreparedStatement insertNewCustomer = null;
    private PreparedStatement updateCustomer = null;
    
    public CustomerModel(){
        
         try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            selectByName = connection.prepareStatement("SELECT * FROM customer WHERE fName = ?");
            selectByMobile = connection.prepareStatement("SELECT * FROM customer WHERE mobile = ?");
            insertNewCustomer = connection.prepareStatement("INSERT INTO customer"
            + "( fName, lName, mobile, email, strNo, strName, suburb, tipsCounter)"
            + "values (?,?,?,?,?,?,?,?)");
            //updateCustomer = connection.prepareStatement("");
         }
         catch (SQLException e){
             e.printStackTrace();
             System.exit(1);
         }
    }
    public int addCustomer(String firstName, String lastName, String mobile,
            String email, int streetNum, String streetName, String suburb, int tipCounter){
        int result = 0;
        
        try{
            insertNewCustomer.setString(1, firstName);
            insertNewCustomer.setString(2, lastName);
            insertNewCustomer.setString(3, mobile);
            insertNewCustomer.setString(4, email);
            insertNewCustomer.setInt(5, streetNum);
            insertNewCustomer.setString(6, streetName);
            insertNewCustomer.setString(7, suburb);
            insertNewCustomer.setInt(8, tipCounter);
            
            result = insertNewCustomer.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Customer> getCustomerByName(String name){
        List<Customer> result = null;
        ResultSet rs = null;
        
        try{
            selectByName.setString(1, name);
            rs = selectByName.executeQuery();
            result = new ArrayList<Customer>();
            
            while (rs.next()){
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
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                rs.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    public List<Customer> getCustomerByMobile(String mobile){
        List<Customer> result = null;
        ResultSet rs = null;
        
        try{
            selectByMobile.setString(1, mobile);
            rs = selectByMobile.executeQuery();
            result = new ArrayList<Customer>();
            
            while (rs.next()){
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
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                rs.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
