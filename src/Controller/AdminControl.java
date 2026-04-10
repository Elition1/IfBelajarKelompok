/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controller;//nama package
/*
IMPORT library JavaFX dan kemampuan class OOP
*/

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kendaraanPackage.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;


/*
-AdminControl berfungsi sebagai pengatur utama untuk hamanan admin
-pakai initializable agar methd initialize() dipanggil otomatis oleh FXML Loader saat FXML dibuat.
*/
public class AdminControl implements Initializable {
    //FXML untuk panel sidebar, setiap anchorpane mewakili suatu halaman di konten utama form
    @FXML private AnchorPane PanelDaftar, PanelTambah, PanelRemove, PanelRiwayat;
    
    //FXML untuk komponen panel hapus kendaraan
    //tabel untuk menampilkan kendaraan dan columnnya
    @FXML private TableView<Kendaraan> tabRemove;
    @FXML private TableColumn<Kendaraan, String> colTipe2, colMerek2, colNama2, colSeri2, colDeskripsi2;
    @FXML private TableColumn<Kendaraan, Double> colHarga2;
    //FXML untuk komponen tambah kendaraan
    @FXML private ComboBox<String> cmbJenis, cmbMerek, cmbStatus;//cmbBox
    @FXML private TextField txtHarga, txtDeskripsi;//textBox
    
    //FXML untuk panel daftar kendaraan
    //lihat tabel serta columnnya
    @FXML private TableView<Kendaraan> tabelDaftar;
    @FXML private TableColumn<Kendaraan, String> colTipe, colMerek, colNama, colSeri, colDeskripsi;
    @FXML private TableColumn<Kendaraan, Double> colHarga;
    
    //instance SistemRental sebagai sumer data
    private SistemRental sisRental = SistemRental.getInstance();
    
    
    /**
     * Dipanggil oleh FXML Loader setelah semua fxml selesai di-tambah (saat mulai)
     * ISi otomatis semua data comboBox, menyetel kolom tabel
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbJenis.setItems(FXCollections.observableArrayList("Mobil", "Motor"));
        cmbStatus.setItems(FXCollections.observableArrayList("Tersedia", "Sedang Dirental"));
        cmbStatus.setVisible(false);

        // Listener: saat jenis dipilih → update merek, tampilkan status
        cmbJenis.setOnAction(e -> {
            String jenis = cmbJenis.getValue();
            cmbMerek.setValue(null);
            cmbStatus.setVisible(jenis != null);

            if ("Mobil".equals(jenis)) {
                cmbMerek.setItems(FXCollections.observableArrayList(
                    "Toyota", "Honda", "Suzuki", "BMW"
                ));
            } else if ("Motor".equals(jenis)) {
                cmbMerek.setItems(FXCollections.observableArrayList(
                    "Yamaha", "Honda", "Suzuki"
                ));
            } else {
                cmbMerek.setItems(FXCollections.observableArrayList());
            }
        });
        
        setupTabelHapus();
        setupTabelDaftar();
        muatDataTabel();
        tampilPane(PanelDaftar);
    }
   
    /**
     *Menghubungkan kolom2 tabel hapus dengan Property
     * pada class Kendaraan menggunakan PropertyValueFactory
     * Nama string hrs sesuai getter
     */
    private void setupTabelHapus() {
        colTipe2.setCellValueFactory(new PropertyValueFactory<>("tipeKendaraan"));
        colMerek2.setCellValueFactory(new PropertyValueFactory<>("merek"));
        colNama2.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colSeri2.setCellValueFactory(new PropertyValueFactory<>("seri"));
        colHarga2.setCellValueFactory(new PropertyValueFactory<>("hargaSewa"));
        colDeskripsi2.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
    }
    
    /**
     * Menghubungkan kolom2 tabel daftar dengan Property
     */
    private void setupTabelDaftar() {
        colTipe.setCellValueFactory(new PropertyValueFactory<>("tipeKendaraan"));
        colMerek.setCellValueFactory(new PropertyValueFactory<>("merek"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colSeri.setCellValueFactory(new PropertyValueFactory<>("seri"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("hargaSewa"));
        colDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
    }
    
    //MUAT DATA
    /**
     * Mengambil semua data kendaraan dari SistemRental
     * menyimpannya ke MasterList (Data)
     * Dipanggil setial ada penambahan atau penguangan data dalam tabel
     */
    private void muatDataTabel() {
        Kendaraan[] semua = sisRental.semuaKendaraan();
        ObservableList<Kendaraan> data = FXCollections.observableArrayList();
        for (Kendaraan k : semua) {
            if (k != null) data.add(k);
        }
        tabelDaftar.setItems(data);
        if (tabRemove != null) tabRemove.setItems(data);
    }
    
    /**
     * FXML - untuk tombol simpan kendaraan
     * Dipanggil setiap tombol simpan kendaraan ditekan oleh user
     * membaca input dari form, memvalidasi, lalu membuat objek Mobil atau motor baru
     * Menambah data tersebut ke SistemRental
     */
    @FXML
    public void btnSimpanKendaraan() {
        String jenis = cmbJenis.getValue();
        String merek = cmbMerek.getValue();
        String hargaStr = txtHarga.getText().trim();
        String deskripsi = txtDeskripsi.getText().trim();
        
        //cek kondisi false
        if (jenis == null || merek == null || hargaStr.isEmpty() || deskripsi.isEmpty()) {
            Peringatan("Error", "Ada data yang masih kosong!");
            return;
        }
        //kondisi true
        try { 
            double harga = Double.parseDouble(hargaStr);
            String hasil;
            
            if (jenis.equals("Mobil")) {
                String seri = "MOB-" + (sisRental.getJmlMobil() + 1);
                Mobil baru = new Mobil(merek, merek, seri, harga, deskripsi, 4);
                hasil = sisRental.tambahMobil(baru);//tambah objek mobil
            } else {
                String seri = "MOT-" + (sisRental.getJmlMotor() + 1);
                Motor baru = new Motor(merek, merek, seri, harga, deskripsi, "Matic");
                hasil = sisRental.tambahMotor(baru);//tambah objek motor
            }
            if (!hasil.equals("Selesai")) {//jika menerima Selesai maka garasi sudah penuh
                Peringatan("Stok Penuh!", hasil);
                return;
            }
            muatDataTabel();//refresh tabel
            Peringatan("Berhasil", "Kendaraan berhasil ditambahkan!\n"
                    //menampilkan messagebox sisa kendaraan di garasi
                    + "Sisa slot Mobil : " + (sisRental.MAX_MOBIL - sisRental.getJmlMobil())
                    + "\nSisa slot Motor : " + (sisRental.MAX_MOTOR - sisRental.getJmlMotor()));
            //pilihan jadi kosong lagi
            cmbJenis.setValue(null);
            cmbMerek.setValue(null);
            cmbStatus.setValue(null);
            cmbStatus.setVisible(false);
            txtHarga.clear();
            txtDeskripsi.clear();
        } catch (NumberFormatException e) {//jika di txtHarga bukan berupa angka
            Peringatan("Error", "Harga harus dengan format angka!");
        }
    }
    
    /**
     * FXML - btnRemove
     * Dipanggil saat tombol hapus kendaraan ditekan
     * mengambil kendaraan yg diselect di tabRemove, lalu menghapusnya
     * penghapusan berdasarkan tipenya (dari class SistemRental)
     */
    @FXML
    public void btnRemove() {
        Kendaraan pilih = tabRemove.getSelectionModel().getSelectedItem();
        
        //cek kondisi false
        if (pilih == null) {
            Peringatan("Error", "Pilih Kendaraan yang akan dihapus terlebih dahulu!");
            return;
        }
        //jika true
        boolean berhasil;
        if (pilih instanceof Mobil) {
            //hapus mobil atau motor yang di select
            berhasil = sisRental.hapusMobil(pilih.getSeri());
        } else {
            berhasil = sisRental.hapusMotor(pilih.getSeri());
        }
        if (berhasil) {
            muatDataTabel();//refresh data tabel
            Peringatan("Berhasil", "Kendaraan " + pilih.getSeri() + " berhasil dihapus!");
        } else {
            Peringatan("Error", "Gagal menghapus kendaraan!");//error
        }
    }
    
    // Sembunyikan semua, tampilkan yang dipilih
    private void tampilPane(AnchorPane aktif) {
        PanelDaftar.setVisible(false);
        PanelTambah.setVisible(false);
        PanelRemove.setVisible(false);
        PanelRiwayat.setVisible(false);
        aktif.setVisible(true);
    }
    //menampilkan panel yang dipilih sesuai tombolnya
    @FXML void btnLookVehicle()      { tampilPane(PanelDaftar); }
    @FXML void btnAddVehicle()       { tampilPane(PanelTambah); }
    @FXML void btnRemoveVehicle()    { tampilPane(PanelRemove); }
    @FXML void btnRiwayatTransaksi() { tampilPane(PanelRiwayat); }
    
    /*
    FXML btnLogout
    -Dipanggil saat tombol logout ditekan
    -tutup halaman utama, kembali ke halaman login
    
    */
    @FXML
    void btnLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewForm/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();//tampilkan form login
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //membuat suatu messageBox
    public void Peringatan(String judul, String pesan) {
        Alert peringatan = new Alert(Alert.AlertType.INFORMATION);
        peringatan.setTitle(judul);
        peringatan.setHeaderText(null);
        peringatan.setContentText(pesan);
        peringatan.showAndWait();
    }
    
}


