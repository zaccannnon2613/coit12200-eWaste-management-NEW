/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

/**
 *
 * @author Zac
 */
public class Booking {
    private int bookingID;
    private String bookingDate;
    private String timeOfPickup;
    private String requestDate;
    private String locationDetails;
    private String notes;
    private int customerID;
    private int wasteID;

    public Booking(int bookingID, String bookingDate, String timeOfPickup, String requestDate, String locationDetails, String notes, int customerID, int wasteID) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.timeOfPickup = timeOfPickup;
        this.requestDate = requestDate;
        this.locationDetails = locationDetails;
        this.notes = notes;
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

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", bookingDate=" + 
                bookingDate + ", timeOfPickup=" + timeOfPickup + 
                ", requestDate=" + requestDate + ", locationDetails=" + 
                locationDetails + ", notes=" + notes + ", customerID=" + 
                customerID + ", wasteID=" + wasteID + '}';
    }
    
}
