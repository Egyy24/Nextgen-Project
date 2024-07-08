package LOGIN;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class FXMLWisataController {

    @FXML
    private Button btn_back;

    @FXML
    private ToggleButton btn_obelix;

    @FXML
    private ToggleButton candi_prmbn;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToPrambanan(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("prambanan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBackWisata(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("wisata.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
