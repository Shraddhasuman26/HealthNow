/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SRADHA SUMAN
 */
public class DonateController implements Initializable {
    ObservableList bg = FXCollections.observableArrayList();

    @FXML
    private DatePicker d1;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private Button submit;
    @FXML
    private ChoiceBox<?> choicebox;
    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        additems();
    }    
    public void additems()
    {
        String s1="O+ve";
        String s2="A+ve";
        String s3="B+ve";
        String s4="AB+ve";
        String s5="O-ve";
        String s6="A-ve";
        String s7="B-ve";
        String s8="AB-ve";
        bg.addAll(s1,s2,s3,s4,s5,s6,s7,s8);
        choicebox.getItems().addAll(bg);
    }
    @FXML
    private void handleButtonAction_submit(ActionEvent event) {
        String a=t1.getText();
        int b=Integer.parseInt(t2.getText());
        String c=t3.getText();
        ToggleGroup member =new ToggleGroup();
        r1.setToggleGroup(member);
        r2.setToggleGroup(member);
        r3.setToggleGroup(member);
        RadioButton rb =(RadioButton) member.getSelectedToggle();
        String d = rb.getText();
        String ee=(choicebox.getValue()).toString();
        String f=(d1.getValue()).toString();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesdb","root","sanusubh");
            Statement s = con.createStatement();
            String s1 = "insert into regform(name,age,healthprob,sex,bloodgrp,dob) values ('"+a+"',"+b+",'"+c+"','"+d+"','"+ee+"','"+f+"');";
            s.executeUpdate(s1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("Service to others is the rent you pay for your room here in earth!");
            alert.setContentText("HAVE A NICE DAY!");
            alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
                }
        });        
        }catch(Exception e){System.out.println(e);}
    }

    @FXML
    public void cancelButtonAction(ActionEvent event) {
        if (event.getSource() == cancelButton) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();

        }
    }
    
}
