package kendaraanPackage;

public class Motor extends Kendaraan
{
    private String tipeMotor;
    public Motor (String merek, String seri, double hargaSewa, String deskripsi, String tipeMotor)
    {
        super(merek, seri, hargaSewa, deskripsi);
        this.tipeMotor = tipeMotor;
    }

    @Override
    void tipeKendaraan()
    {

    }

    public String getTipeMotor() {
        return tipeMotor;
    }

    public void setTipeMotor(String tipeMotor) {
        this.tipeMotor = tipeMotor;
    }
}
