/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Ath07
 */
public class AdminControl {
    @FXML private AnchorPane PanelDaftar, PanelTambah, PanelRemove, PanelRiwayat;

// Sembunyikan semua, tampilkan yang dipilih
    private void tampilPane(AnchorPane aktif) {
    PanelDaftar.setVisible(false);
    PanelTambah.setVisible(false);
    PanelRemove.setVisible(false);
    PanelRiwayat.setVisible(false);
    aktif.setVisible(true);
}

    @FXML void btnLookVehicle() { tampilPane(PanelDaftar); }
    @FXML void btnAddVehicle() { tampilPane(PanelTambah); }
    @FXML void btnRemoveVehicle() { tampilPane(PanelRemove); }
    @FXML void btnRiwayatTransaksi() { tampilPane(PanelRiwayat); }
    
    @FXML
    void btnLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewForm/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
