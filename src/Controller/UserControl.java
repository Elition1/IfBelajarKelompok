package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kendaraanPackage.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;

public class UserControl implements Initializable
{
    @FXML private AnchorPane LayerUser, LayerBeranda, Layerkendaraan, IsiTabMotor ;
    @FXML private HBox LayerPesan;

    @FXML private Button TombolBeranda, TombolKendaraan, TombolLogout, ButtonSewaPesanan;
    @FXML private ToggleButton ButtonLogoHonda, ButtonLogoSuzuki, ButtonLogoKawasaki, ButtonLogoBMW, ButtonLogoMitsubisi, ButtonLogoHondaMotor, ButtonLogoSuzukiMotor, ButtonAll;

    @FXML private ComboBox<Kendaraan> cmbUserCars;
    @FXML private Tab TabMobil, TabMotor;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        tampilLayar(LayerBeranda);

        SistemRental sisRental = SistemRental.getInstance();
        Kendaraan[] all = sisRental.semuaKendaraan();

        ObservableList<Kendaraan> list = FXCollections.observableArrayList();
        for (Kendaraan l : all)
            if (l != null) list.add(l);
    }

    private void tampilLayar(AnchorPane aktif){
        LayerUser.setVisible(false);
        LayerBeranda.setVisible(false);
        Layerkendaraan.setVisible(false);
        aktif.setVisible(true);
    }

    private void tampilHpane(HBox aktif){
        LayerPesan.setVisible(false);
        aktif.setVisible(true);
    }

    @FXML
    public void setList(ObservableList<Kendaraan> list)
    {
        cmbUserCars.setItems(list);
    }

    @FXML
    private void btnSewaLayar() {
        tampilHpane(LayerPesan);
    }

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

    public void Peringatan(String judul, String pesan) {
        Alert warning = new Alert(Alert.AlertType.INFORMATION);
        warning.setTitle(judul);
        warning.setHeaderText(null);
        warning.setContentText(pesan);
        warning.showAndWait();
    }
}
