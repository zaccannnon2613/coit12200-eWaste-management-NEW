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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 *Student names: Hughen Flint, Zac Cannon
 *Student ID: 12177330,12195928
 *Campus: Townsville
 *File Description: Controls add waste page
 */
public class AddWasteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //objects in the UI are initialized
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBooking;
    @FXML
    private TextField txtTypeWaste;
    @FXML
    private TextField txtItemDetails;
    @FXML
    private TextField txtItemQuantity;
    @FXML
    private TextField txtCustomerID;
    //varibles for adding and showing data
    WasteModel waste = new WasteModel();
    List<WasteDetails> result;
    int numOfEntries;
    int index;
    WasteDetails currentWaste;
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
    public void btnSaveListener(ActionEvent event){//adds the text inputted into an onject of waste
        String wasteType = txtTypeWaste.getText();
        String itemDetails = txtItemDetails.getText();
        String itemQuantity = txtItemQuantity.getText();
        int customerID = Integer.parseInt(txtCustomerID.getText());
        
        int addToList = waste.addWaste(wasteType, itemDetails, itemQuantity, customerID);
    }
     @FXML
    public void btnAddBooking(ActionEvent event) {
        //goes to the add booking page
        try {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();//node is used to keep the window in the same place, can also alter height and width
            root = FXMLLoader.load(getClass().getResource("AddBooking.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
