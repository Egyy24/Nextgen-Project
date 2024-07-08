package LOGIN;

import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLLoginController {
    @FXML
    private TextField login_username;
    @FXML
    private TextField login_showPassword;
    @FXML
    private PasswordField login_password;
    @FXML
    private CheckBox login_selecShowPassword;
    @FXML
    private Button login_Button;
    @FXML
    private Hyperlink login_registerAccount;
    @FXML
    private Text signInText;
    @FXML
    private Text welcomeText;

    

   
    private XMLUserManager userManager = new XMLUserManager();

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = login_username.getText();
        String password = login_password.getText();
        if (userManager.authenticateUser(username, password)) {
            showAlert("Success", "Login successful", event);
        } else {
            showAlert("Error", "Login failed", null);
        }
    }
    @FXML
    private void change() {
        if (login_selecShowPassword.isSelected()) {
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(true);
            login_password.setVisible(false);
        } else {
            login_password.setText(login_showPassword.getText());
            login_password.setVisible(true);
            login_showPassword.setVisible(false);
        }
    }

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegisterPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Register/RegisterPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message, ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        
        if (event != null) {
            // Assuming you want to switch to another page on successful login
            try {
                switchToNextPage(event); // This method should be implemented to switch to your desired page
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void switchToNextPage(ActionEvent event) throws IOException {
        // Load the next page after successful login
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
