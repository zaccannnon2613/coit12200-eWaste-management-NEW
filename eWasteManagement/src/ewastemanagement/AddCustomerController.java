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
 *Student ID: 12177330 ,12195928
 *Campus: Townsville
 *File Description: Controls the add to customer page
 */
public class AddCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnExit;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtStrNum;
    @FXML
    private TextField txtStreetName;
    @FXML
    private TextField txtSuburb;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtEmail;
    
    CustomerModel customer = new CustomerModel();
    List<Customer> result;
    Stage stage;
    Parent root;
    
    @FXML
    public void btnExit(ActionEvent event) {
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
    
    public void btnSaveListener(ActionEvent event){//variables to store the text input are initialized
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String mobile = txtMobile.getText();
        String email = txtEmail.getText();
        int streetNum = Integer.parseInt(txtStrNum.getText());
        String streetName = txtStreetName.getText();
        String suburb = txtSuburb.getText();
        int tipCounter = 2;
        

        //adds the text to the database
        int addToList = customer.addCustomer(firstName, lastName, mobile, email, streetNum, streetName, suburb, tipCounter);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
