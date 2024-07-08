package LOGIN;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FXMLAkunController {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_logout;

    @FXML
    private ImageView imageview;

    @FXML
    private Button showimageview;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToBackhome(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() {
        showimageview.setOnAction(event -> browseAndSetProfilePicture());
    }

    @FXML
    private void browseAndSetProfilePicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Foto Profil");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("File Gambar", "*.png", "*.jpg", "*.jpeg")
        );
        
        // Coba set direktori awal ke direktori user
        try {
            String userHomeDir = System.getProperty("user.home");
            File initialDirectory = new File(userHomeDir);
            if (initialDirectory.exists()) {
                fileChooser.setInitialDirectory(initialDirectory);
            }
        } catch (Exception e) {
            System.err.println("Tidak dapat mengatur direktori awal: " + e.getMessage());
        }
        
        File selectedFile = fileChooser.showOpenDialog(showimageview.getScene().getWindow());
        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                imageview.setImage(image);
            } catch (Exception e) {
                showAlert("Error", "Gagal memuat gambar", "Pastikan file yang dipilih adalah file gambar yang valid.");
            }
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}