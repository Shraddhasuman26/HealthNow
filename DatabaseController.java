package employees;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DatabaseController implements Initializable, EventHandler {

    @FXML
    public TextField idTextField;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField departmentTextField;
//    public TextField salaryTextField;

    @FXML
    private TableView<Employees> employeesTableView;

    @FXML
    private TableColumn<Employees, Integer> idTableView;

    @FXML
    private TableColumn<Employees, String> firstNameTableView;

    @FXML
    private TableColumn<Employees, String> lastNameTableView;

    @FXML
    private TableColumn<Employees, String> departmentTableView;

//    @FXML
//    private TableColumn<Employees, Double> salaryTableView;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;
    @FXML
    private Button donate;
    @FXML
    private MenuItem aboutus;
    @FXML
    private MenuItem our_doc;
    @FXML
    private MenuItem healthblog;
    @FXML
    private Button generatefees;
    @FXML
    private MenuItem disc;

   

    @Override
    @FXML
    public void handle(Event event) {
        if (event.getSource() == insertButton) {
            System.out.println("Here");
            insertEmployees();
        } else if (event.getSource() == updateButton) {
            updateEmployees();
        } else if (event.getSource() == deleteButton){
            deleteEmployees();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showEmployees();

    }

    public ObservableList<Employees> getEmployeesList() {

        ObservableList<Employees> employeesList = FXCollections.observableArrayList();
        DatabaseConnection connectionDB = new DatabaseConnection();
        Connection newConnection = connectionDB.databaseConnection;

        String query = "SELECT * FROM doc";
        Statement statement;
        ResultSet resultSet;

        try {
            statement = newConnection.createStatement();
            resultSet = statement.executeQuery(query);
            Employees employees;
            while (resultSet.next()) {
                employees = new Employees(resultSet.getInt("Id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("department"));
//                        resultSet.getDouble("salary"));
                employeesList.add(employees);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return employeesList;
    }

    public void showEmployees() {
        ObservableList<Employees> list = getEmployeesList();

        idTableView.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("Id"));
        firstNameTableView.setCellValueFactory(new PropertyValueFactory<Employees, String>("firstName"));
        lastNameTableView.setCellValueFactory(new PropertyValueFactory<Employees, String>("lastName"));
        departmentTableView.setCellValueFactory(new PropertyValueFactory<Employees, String>("Department"));
//        salaryTableView.setCellValueFactory(new PropertyValueFactory<Employees, Double>("Salary"));

        employeesTableView.setItems(list);
    }

    private void insertEmployees() {
        String query = "INSERT INTO doc VALUES (" +
                idTextField.getText() + ",'" +
                firstNameTextField.getText() + "','" +
                lastNameTextField.getText() + "','" +
                departmentTextField.getText() + "')" ;
//                salaryTextField.getText() + ")";
        System.out.println(query);
        executeQuery(query);
        System.out.println("Insert");
        showEmployees();

    }

    public void updateEmployees() {
        String query = "UPDATE doc SET firstName = '" +
                firstNameTextField.getText() + "', lastName = '" +
                lastNameTextField.getText() + "', department = '" +
                departmentTextField.getText() + "' WHERE id = " +
                idTextField.getText();
        System.out.println(query);
        executeQuery(query);
        showEmployees();
    }

    public void deleteEmployees(){
        String query = "DELETE FROM doc WHERE id = " + idTextField.getText() + "";
        executeQuery(query);
        showEmployees();
    }

    private void executeQuery(String query) {
        DatabaseConnection connection = new DatabaseConnection();
        Statement statement;

        try {
            statement = connection.databaseConnection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Catch");
            e.printStackTrace();
            e.getCause();
        }
    }
    
    @FXML
    void handleButtonAction_donate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("donate.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("DONATION REGISTRATION FORM");
        databaseStage.setScene(new Scene(root, 640, 627));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show();
    }
    @FXML
    void handleButtonAction_fees(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fee.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("FEES");
        databaseStage.setScene(new Scene(root, 482, 456));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show(); 
    }

    @FXML
    private void handleButtonAction_aboutus(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("aboutus.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("ABOUT US");
        databaseStage.setScene(new Scene(root, 568, 457));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show();
    }

    @FXML
    private void handleButtonAction_ourdoc(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ourdoc.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("DOCTOR INFORMATION");
        databaseStage.setScene(new Scene(root, 594, 466));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show();
    }

    @FXML
    private void handleButtonAction_healthblog(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("healthblogs.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("HEALTH BLOGS");
        databaseStage.setScene(new Scene(root, 630, 485));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show();
    }

    @FXML
    private void handleButtonAction_disc (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("discount.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("DISCOUNTS");
        databaseStage.setScene(new Scene(root, 600, 344));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show();
    }
}    
