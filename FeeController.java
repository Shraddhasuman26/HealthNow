/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SRADHA SUMAN
 */
public class FeeController implements Initializable {
    ObservableList pay = FXCollections.observableArrayList();

    @FXML
    private TextField t1;
    @FXML
    private TextField t3;
    @FXML
    private Button clear;
    @FXML
    private Button calc;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField t2;
    @FXML
    private ChoiceBox<?> choicebox;
    @FXML
    private TextField t5;
    @FXML
    private TextField t4;
    @FXML
    private TextField t6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        additems();
    }    
    public void additems()
    {
        String s1="Cash";
        String s2="Credit";
        String s3="Cheque";
        pay.addAll(s1,s2,s3);
        choicebox.getItems().addAll(pay);
    }
        public void calculate(float amt,String c,String a){
            if(c.equals("Cash"))
            {
                float val=(float)(amt-(0.07*amt));
                t5.setText(Float.toString(val));
                t6.setText("Dear "+a+"!"+"You have to pay "+Float.toString(val));
            }
            else if(c.equals("Cheque"))
            {
                float val=(float)(amt-(0.05*amt));
                t5.setText(Float.toString(val));
                t6.setText("Dear "+a+"!"+"You have to pay "+Float.toString(val));
            }
            else if(c.equals("Credit"))
            {
                float val=amt;
                t5.setText(Float.toString(val));
                t6.setText("Dear "+a+"!"+"You have to pay "+Float.toString(val));
            }
    }

    @FXML
    private void handleButtonAction_clear(ActionEvent event) {
        t1.setText(" ");
        t2.setText(" ");
        t3.setText(" ");
        t4.setText(" ");        
    }

    @FXML
    private void handleButtonAction_calc(ActionEvent event) {
        String a = t1.getText();
//        String b = t2.getText();
        String c=(choicebox.getValue()).toString();
        float amt=Float.parseFloat(t4.getText());
        t6.setDisable(true);
        calculate(amt,c,a);
        
        
    }

    @FXML
    private void cancelButonAction(ActionEvent event) {
        if (event.getSource() == cancelButton) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }
    
}
