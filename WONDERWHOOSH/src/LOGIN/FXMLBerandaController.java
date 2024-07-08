package LOGIN;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLBerandaController {

    @FXML
    private ImageView Gambar;

    @FXML
    private ImageView GambarLogo;

     @FXML
    private Hyperlink beranda_signIn;

    @FXML
    private Button beranda_signUp;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginPage(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRegisterPage(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../Register/RegisterPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
