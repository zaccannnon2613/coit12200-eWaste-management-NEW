/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330,12195928
 *Campus: Townsville
 *File Description: booking object
 */
public class Booking {
    //variables are initialized
    private int bookingID;
    private String bookingDate;
    private String timeOfPickup;
    private String requestDate;
    private int strNo;
    private String strName;
    private String notes;
    private String suburb;
    private int customerID;
    private int wasteID;

    //constructor and getters and setters
    public Booking(int bookingID, String bookingDate, String timeOfPickup, String requestDate, int strNo, String strName, String notes, String suburb, int customerID, int wasteID) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.timeOfPickup = timeOfPickup;
        this.requestDate = requestDate;
        this.strNo = strNo;
        this.strName = strName;
        this.notes = notes;
        this.suburb = suburb;
        this.customerID = customerID;
        this.wasteID = wasteID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeOfPickup() {
        return timeOfPickup;
    }

    public void setTimeOfPickup(String timeOfPickup) {
        this.timeOfPickup = timeOfPickup;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    
    public int getStrNo(){
        return strNo;
    }
    public void setStrNo(int strNo){
        this.strNo = strNo;
    }
    
    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getWasteID() {
        return wasteID;
    }

    public void setWasteID(int wasteID) {
        this.wasteID = wasteID;
    }

    //to string method
    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", bookingDate=" + 
                bookingDate + ", timeOfPickup=" + timeOfPickup + 
                ", requestDate=" + requestDate + ", street number=" + strNo +
                ", street name=" + strName + ", notes=" + notes + ", suburb=" +suburb + ", customerID=" + 
                customerID + ", wasteID=" + wasteID + '}';
    }
    
}
