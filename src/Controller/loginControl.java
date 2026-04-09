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
/**
 *
 * @author Ath07
 */
public class loginControl {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    
    private final String USER_ADMIN = "admin";
    private final String PASS_ADMIN = "admin";
    private final String USER_USER = "user";
    private final String PASS_USER = "user";
    
    @FXML 
    public void handleLogin(ActionEvent event) {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();
        
        if (username.isEmpty() || password.isEmpty()) {
            Peringatan("Error Login","Username atau password masih kosong. Tolong diisi!");
            return;
        }
        if (username.equals(USER_ADMIN) && password.equals(PASS_ADMIN)) {
            Peringatan("Login Berhasil","Selamat datang, Admin Tersayang UwU");
            tampilForm(event, "/viewForm/FormAdmin.fxml");
        } else if (username.equals(USER_USER) && password.equals(PASS_USER)){
            Peringatan("Login Berhasil","Selamat Datang di RentGo! App!!");
            tampilForm(event, "/viewForm/FormUser.fxml");
        } else {
            Peringatan("Error Login","Username atau password salah!");
        }
    } 
    
    public void tampilForm(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
             e.printStackTrace();
             Peringatan("Error", "Gagal membuka halaman: " + fxmlPath);
        }
    }
    public void Peringatan (String judul, String pesan) {
        Alert peringatan = new Alert(Alert.AlertType.INFORMATION);
        peringatan.setTitle(judul);
        peringatan.setHeaderText(null);
        peringatan.setContentText(pesan);
        peringatan.showAndWait();
    }
}
