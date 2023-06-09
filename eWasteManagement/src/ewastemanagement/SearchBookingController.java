/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ewastemanagement;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330,12195928
 *Campus: Townsville
 *File Description: manages the search for booking
 */
public class SearchBookingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtFNameSearch;
    @FXML
    private TextField txtStrNoSearch;
    @FXML
    private TextField txtStrNameSearch;
    @FXML
    private TextField txtMobileSearch;
    @FXML
    private TextField txtStrNo;
    @FXML
    private TextField txtStrName;
    @FXML
    private TextField txtSuburb;
    @FXML
    private TextField txtDateBooked;
    @FXML
    private TextField txtReqDate;
    @FXML
    private TextField txtPickupTime;
    @FXML
    private TextArea txtNotes;
    
     //varaiables for searching and showing the data
    BookingModel booking = new BookingModel();
    List<Booking> result;
    int numOfEntries;
    int index;
    Booking currentBooking;
    
    //initializes the stage and parent
    
    Stage stage;
    Parent root;
    
    @FXML
    public void btnBackListener(ActionEvent event) {
        //goes back to the home page
        try {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();//node is used to keep the window in the same place, can also alter height and width
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void btnSearchListener(ActionEvent event){
        String findCustomer = txtFNameSearch.getText();
        result = booking.getDetailsByName(findCustomer);//gets the name

        numOfEntries = result.size();//
        if (numOfEntries != 0) {
            index = 0;
            currentBooking = result.get(index);//customer becomes the record found
            populateFields(currentBooking);
        } else {
            displayAlert();
        }
    }
    @FXML
    public void btnSearcgAddress(ActionEvent event){
        String findCustomer = txtMobileSearch.getText();
        result = booking.getDetailsByMobile(findCustomer);//gets the mobile

        numOfEntries = result.size();//
        if (numOfEntries != 0) {
            index = 0;
            currentBooking = result.get(index);//customer becomes the record found
            populateFields(currentBooking);
        } else {
            displayAlert();
        }
    }
    @FXML
    public void btnSearchMobile(ActionEvent event){
        String findCustomer = txtStrNameSearch.getText();
        int findCustomerStrNo = Integer.parseInt(txtStrNoSearch.getText());
        result = booking.getDetailsByAddress(findCustomer, findCustomerStrNo);//gets the street name and number

        numOfEntries = result.size();//
        if (numOfEntries != 0) {
            index = 0;
            currentBooking = result.get(index);//customer becomes the record found
            populateFields(currentBooking);
        } else {
            displayAlert();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     //makes and displays an alert
    public void displayAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("Entry not found");
        alert.show();
    }

    //gets the fields from the database and outputs into the text fields
    private void populateFields(Booking b) {
        txtStrNo.setText(""+ b.getStrNo());
        txtStrName.setText("" + b.getStrName());
        txtSuburb.setText("" + b.getSuburb());
        txtDateBooked.setText("" + b.getBookingDate());
        txtReqDate.setText("" + b.getRequestDate());
        txtPickupTime.setText(""+ b.getTimeOfPickup());
        txtNotes.setText("" + b.getNotes());
    }
    
}
