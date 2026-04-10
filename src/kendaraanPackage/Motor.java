package kendaraanPackage;

/**
 *
 * @author Ath07
 */
public class Motor extends Kendaraan {
    private String tipeMotor; // Matic, Sport, Bebek

    public Motor(String merek, String nama, String seri,
                 double hargaSewa, String deskripsi, String tipeMotor) {
        super(merek, nama, seri, hargaSewa, deskripsi);
        this.tipeMotor = tipeMotor;
    }

    @Override
    public String getTipeKendaraan() { return "Motor"; }

    @Override
    public String getDetailSpesifik() { return "Tipe: " + tipeMotor; }

    public String getTipeMotor() { return tipeMotor; }
}
