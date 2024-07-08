package LOGIN;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDonasiController {

    @FXML
    private Button btn_Donasi1;

    @FXML
    private Button btn_Donasi2;

    @FXML
    private Button btn_Donasi3;

    @FXML
    private Button btn_back;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPayment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PaymentDonasi.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}