package LOGIN;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FXMLPaymentController {
    @FXML
    private TextField biayaminTextField;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_bayarDonasi;
    @FXML
    private Button btn_bca;
    @FXML
    private Button btn_bjb;
    @FXML
    private Button btn_bni;
    @FXML
    private Button btn_bri;
    @FXML
    private Button btn_bsi;
    @FXML
    private Button btn_dana;
    @FXML
    private Button btn_duapuluhribu;
    @FXML
    private Button btn_duaratusribu;
    @FXML
    private Button btn_gopay;
    @FXML
    private Button btn_limapuluhribu;
    @FXML
    private Button btn_limaratusribu;
    @FXML
    private Button btn_mandiri;
    @FXML
    private Button btn_ovo;
    @FXML
    private Button btn_seratusribu;
    @FXML
    private Button btn_tigaratusribu;
    @FXML
    private AnchorPane data_pembayaran;
    @FXML
    private TextField donasiTextField;
    @FXML
    private TextField emailTextfield;
    @FXML
    private TextField namaTextField;
    @FXML
    private TextField nominalTextField;
    @FXML
    private TextField nomorTextField;
    @FXML
    private Pane rincianbayar_pane;
    @FXML
    private TextField totalTextField;
    
    private static final double ADMIN_FEE_PERCENTAGE = 0.025; // 2.5% admin fee
    private double currentAdminFee = 0;
    private String selectedPaymentMethod = "";

     @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Donasi.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        setupDonationButtons();
        setupPaymentMethodButtons();
        nominalTextField.setOnKeyReleased(this::updatePaymentDetails);
        btn_bayarDonasi.setOnAction(this::handleBayarDonasi);
    }

    private void setupDonationButtons() {
        Button[] donationButtons = {
            btn_duapuluhribu, btn_limapuluhribu, btn_seratusribu,
            btn_duaratusribu, btn_tigaratusribu, btn_limaratusribu
        };
        for (Button button : donationButtons) {
            button.setOnAction(this::handleDonationButtonClick);
        }
    }

    private void setupPaymentMethodButtons() {
        Button[] paymentButtons = {
            btn_bri, btn_bni, btn_bca, btn_bsi, btn_mandiri, btn_bjb,
            btn_dana, btn_ovo, btn_gopay
        };
        for (Button button : paymentButtons) {
            button.setOnAction(this::handlePaymentMethodClick);
        }
    }

    @FXML
    private void handleDonationButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String amountText = clickedButton.getText().replace("Rp. ", "").replace(".", "");
        int amount = Integer.parseInt(amountText);
        nominalTextField.setText(String.valueOf(amount));
        updatePaymentDetails(amount);
    }

    @FXML
    private void handlePaymentMethodClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        selectedPaymentMethod = clickedButton.getId();
        updateAdminFee();
        updatePaymentDetails(Integer.parseInt(nominalTextField.getText()));
    }

    private void updatePaymentDetails(KeyEvent event) {
        try {
            int amount = Integer.parseInt(nominalTextField.getText());
            updatePaymentDetails(amount);
        } catch (NumberFormatException e) {
            clearPaymentDetails();
        }
    }

    private void updatePaymentDetails(int donationAmount) {
        double totalAmount = donationAmount + currentAdminFee;
        donasiTextField.setText(String.format("Rp %,d", donationAmount));
        biayaminTextField.setText(String.format("Rp %,.0f", currentAdminFee));
        totalTextField.setText(String.format("Rp %,.0f", totalAmount));
    }

    private void updateAdminFee() {
        if (!nominalTextField.getText().isEmpty()) {
            int donationAmount = Integer.parseInt(nominalTextField.getText());
            currentAdminFee = donationAmount * ADMIN_FEE_PERCENTAGE;
            
           
            switch (selectedPaymentMethod) {
                case "btn_bri":
                case "btn_bni":
                case "btn_bca":
                    currentAdminFee += 1000; 
                    break;
                case "btn_dana":
                case "btn_ovo":
                case "btn_gopay":
                    currentAdminFee += 500;
                    break;
               
            }
        } else {
            currentAdminFee = 0;
        }
    }

    private void clearPaymentDetails() {
        donasiTextField.clear();
        biayaminTextField.clear();
        totalTextField.clear();
    }

    @FXML
    private void handleBayarDonasi(ActionEvent event) {
        if (selectedPaymentMethod.isEmpty() || nominalTextField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Informasi Tidak Lengkap", "Silakan pilih metode pembayaran dan masukkan jumlah donasi.");
            return;
        }

        String donationAmount = donasiTextField.getText();
        String adminFee = biayaminTextField.getText();
        String totalAmount = totalTextField.getText();
        String paymentMethod = getPaymentMethodName(selectedPaymentMethod);
        String name = namaTextField.getText();
        String email = emailTextfield.getText();
        String phoneNumber = nomorTextField.getText();

        String message = String.format(
            "Detail Transaksi:\n\n" +
            "Nama: %s\n" +
            "Email: %s\n" +
            "Nomor Telepon: %s\n" +
            "Jumlah Donasi: %s\n" +
            "Biaya Admin: %s\n" +
            "Total Pembayaran: %s\n" +
            "Metode Pembayaran: %s",
            name, email, phoneNumber, donationAmount, adminFee, totalAmount, paymentMethod
        );

        showAlert(AlertType.INFORMATION, "Detail Transaksi", "Donasi Berhasil", message);
    }

    private void showAlert(AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private String getPaymentMethodName(String buttonId) {
        switch (buttonId) {
            case "btn_bri": return "BRI";
            case "btn_bni": return "BNI";
            case "btn_bca": return "BCA";
            case "btn_bsi": return "BSI";
            case "btn_mandiri": return "Mandiri";
            case "btn_bjb": return "BJB";
            case "btn_dana": return "Dana";
            case "btn_ovo": return "OVO";
            case "btn_gopay": return "GoPay";
            default: return "Tidak diketahui";
        }
    }
}