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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zac
 */
public class SearchController implements Initializable {

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
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private TextField txtStrNo;
    @FXML
    private TextField txtStrName;
    @FXML
    private TextField txtSuburb;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTripRem;
    
    
    CustomerModel customer = new CustomerModel();
    List<Customer> result;
    int numOfEntries;
    int index;
    Customer currentCustomer;
    
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
         //gets the text from search
        String findCustomer = txtFName.getText();
        result = customer.getCustomerByName(findCustomer);//gets the name

        numOfEntries = result.size();//
        if (numOfEntries != 0) {
            index = 0;
            currentCustomer = result.get(index);//customer becomes the record found
            populateFields(currentCustomer);
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
    private void populateFields(Customer c) {
        txtFName.setText("" + c.getFirstName());
        txtLName.setText("" + c.getLastName());
        txtStrNo.setText("" + c.getStreetNum());
        txtStrName.setText(""+ c.getStreetName());
        txtSuburb.setText(""+ c.getSuburb());
        txtMobile.setText("" + c.getMobile());
        txtEmail.setText("" + c.getEmail());
        txtTripRem.setText("" + c.getTipCounter());
    }
}
