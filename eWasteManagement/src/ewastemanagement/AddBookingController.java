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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: ,12195928
 *Campus: Townsville
 *File Description: Controls the homepage
 */
public class AddBookingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //objects on the UI are initialized
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtBookingDate;
    @FXML
    private TextField txtTimePickup;
    @FXML
    private TextField txtReqDate;
    @FXML
    private TextField txtStrNo;
    @FXML
    private TextField txtStrName;
    @FXML
    private TextField txtSuburb;
    @FXML
    private TextArea txtNotes;
    @FXML
    private TextField txtCustID;
    @FXML
    private TextField txtWasteID;
    //variables for showing and getting data
    BookingModel booking = new BookingModel();
    List<Booking> result;
    int numOfEntries;
    int index;
    Booking currentBooking;

    //parent and stage
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
    public void btnSaveListener(ActionEvent event) {
        //gets the text from the input and stores in a variable
        String bookingDate = txtBookingDate.getText();
        String requestDate = txtReqDate.getText();
        String timePickup = txtTimePickup.getText();
        int streetNo = Integer.parseInt(txtStrNo.getText());
        String streetName = txtStrName.getText();
        String suburb = txtSuburb.getText();
        String notes = txtNotes.getText();
        int customerID = Integer.parseInt(txtCustID.getText());
        int wasteID = Integer.parseInt(txtWasteID.getText());
        
        
       

        //adds the variables to the booking object list
        int addToList = booking.addBooking(bookingDate, timePickup, requestDate, streetNo, streetName, suburb, notes, customerID, wasteID);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

}
