package employees;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.Group;

public class LoginController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML
    private Label invalidLoginLabel;
    private TextField usernameTextField;
    private PasswordField passwordTextField;
    private ImageView loginImageView;
    @FXML
    private Button cancelButton;
    @FXML
    private Button b1;
    @FXML
    private Label l1;
    @FXML
    private TextField t1;


    @FXML
    public void loginButtonAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("databaseForm.fxml")));

        Stage databaseStage = new Stage();
        databaseStage.setTitle("HOSPITAL PORTAL");
        databaseStage.setScene(new Scene(root, 800, 700));
        databaseStage.initModality(Modality.APPLICATION_MODAL);
        databaseStage.show();
    }

    @FXML
    public void cancelButtonAction(ActionEvent event) {
        if (event.getSource() == cancelButton) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        File loginFile = new File("Images/lockImage.png");
//        Image loginImage = new Image(loginFile.toURI().toString());
//        loginImageView.setImage(loginImage);

    }

//    public void validateLogin() {
//        DatabaseConnection connectToDB = new DatabaseConnection();
//        Connection connectNow = connectToDB.loginConnection;
//
//        String verifyLogin = "SELECT count(1) FROM user_accounts WHERE username = '" +
//                usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() + "'";
//
//        try {
//            Statement statement = connectNow.createStatement();
//            ResultSet queryResult = statement.executeQuery(verifyLogin);
//
//            while (queryResult.next()) {
//                if (queryResult.getInt(1) == 1) {
//                    invalidLoginLabel.setText("");
//                    openDatabaseWindow();
//                } else {
//                    invalidLoginLabel.setText("Wrong username or password. Please try again.");
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getCause();
//        }
//
//    }

//    public void openDatabaseWindow() throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("databaseForm.fxml")));
//
//        Stage databaseStage = new Stage();
//        databaseStage.setTitle("Employee database");
//        databaseStage.setScene(new Scene(root, 640, 627));
//        databaseStage.initModality(Modality.APPLICATION_MODAL);
//        databaseStage.show();
//    }

    @FXML
    private void handleButtonAction_b1(ActionEvent event) {
        String a=t1.getText();
        l1.setText("WELCOME "+ a);
    }
}
