/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ewastemanagement;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330,12195928
 *Campus: Townsville
 *File Description: waste details object
 */
public class WasteDetails {
    //variables are initialized
    private int wasteID;
    private String wasteType;
    private String itemDetails;
    private String itemQuantity;
    private int customerID;

    //constructor and getters and setters
    public WasteDetails(int wasteID, String wasteType, String itemDetails, String itemQuantity, int customerID) {
        this.wasteID = wasteID;
        this.wasteType = wasteType;
        this.itemDetails = itemDetails;
        this.itemQuantity = itemQuantity;
        this.customerID = customerID;
    }

    public int getWasteID() {
        return wasteID;
    }

    public void setWasteID(int wasteID) {
        this.wasteID = wasteID;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    //to string method
    @Override
    public String toString() {
        return "WasteDetails{" + "wasteID=" + wasteID + ", wasteType=" + 
                wasteType + ", itemDetails=" + itemDetails + ", itemQuantity=" + 
                itemQuantity + ", customerID=" + customerID + '}';
    }
    
}
