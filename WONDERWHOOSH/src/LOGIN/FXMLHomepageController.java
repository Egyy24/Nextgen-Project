package LOGIN;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLHomepageController {

    @FXML
    private Button Akun;

    @FXML
    private Button Dashboard;

    @FXML
    private Button Donasi;

    @FXML
    private Button Infowisata;

    @FXML
    private Button Kuliner;

    @FXML
    private Button Logout;

    @FXML
    private Button Promo;

    @FXML
    private Button Search;

    @FXML
    private Label email_label;

    @FXML
    private Label username_label;

    @FXML
    void switchToDonasi(ActionEvent event) {

    }

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToInfowisata(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wisata.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToKuliner(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("kuliner.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAkun(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Akun.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDonasi1(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Donasi.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchTologout(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Beranda.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    
    
    

}
