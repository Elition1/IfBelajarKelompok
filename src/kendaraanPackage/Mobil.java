package kendaraanPackage;

public class Mobil extends Kendaraan
{
    private int jmlPintu;

    public Mobil(String merek, String nama, String seri, double hargaSewa, String deskripsi, int jmlPintu)
    {
        super(deskripsi, merek, nama, hargaSewa, seri);
        this.jmlPintu = jmlPintu;
    }

    public String getDetailSpesifik()
    {
        return jmlPintu + " pintu";
    }

    public int getJumlahPintu() { return jmlPintu; }

    @Override
    void tipeKendaraan() {
        //Print kendaraan
    }
}