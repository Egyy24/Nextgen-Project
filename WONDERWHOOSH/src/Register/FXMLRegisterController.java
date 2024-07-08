package Register;

import java.io.IOException;

import LOGIN.XMLUserManager;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLRegisterController {
     @FXML
    private AnchorPane registe_;

    @FXML
    private Button register_Button;

    @FXML
    private TextField register_email;

    @FXML
    private PasswordField register_password;

    @FXML
    private CheckBox register_selecShowPassword;

    @FXML
    private TextField register_showPassword;

    @FXML
    private Hyperlink register_signInAccount;

    @FXML
    private TextField register_username;

    private XMLUserManager userManager = new XMLUserManager();

    @FXML
    private void handleRegister(ActionEvent event) {
        String username = register_username.getText();
        String email = register_email.getText();
        String password = register_password.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "All fields are required", null);
            return;
        }

        userManager.saveUser(username, email, password);
        showAlert("Success", "Registration successful", event);
    }

    @FXML
    private void change() {
        if (register_selecShowPassword.isSelected()) {
            register_showPassword.setText(register_password.getText());
            register_showPassword.setVisible(true);
            register_password.setVisible(false);
        } else {
            register_password.setText(register_showPassword.getText());
            register_password.setVisible(true);
            register_showPassword.setVisible(false);
        }
    }

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../LOGIN/LoginPage.fxml"));
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
        root = FXMLLoader.load(getClass().getResource("../LOGIN/LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
   
}
