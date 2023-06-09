/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330 ,12195928
 *Campus: Townsville
 *File Description: customer object
 */
public class Customer {
    //variables are initialized
    private int customerID;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private int streetNum;
    private String streetName;
    private String suburb;
    private int tipCounter;

    //constructor and getters and setters
    public Customer(int customerID, String firstName, String lastName, String mobile, String email, int streetNum, String streetName, String suburb, int tipCounter) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.suburb = suburb;
        this.tipCounter = tipCounter;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getTipCounter() {
        return tipCounter;
    }

    public void setTipCounter(int tipCounter) {
        this.tipCounter = tipCounter;
    }

    //to string method
    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", firstName=" +
                firstName + ", lastName=" + lastName + ", mobile=" + mobile + 
                ", email=" + email + ", streetNum=" + streetNum + ", streetName=" + 
                streetName + ", suburb=" + suburb + ", tipCounter=" + tipCounter + '}';
    }
    
}
