/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ewastemanagement;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author Zac
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
    private TextField txtNotes;
    
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
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
