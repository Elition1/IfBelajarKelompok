package kendaraanPackage;

/**
 *
 * @author Ath07
 */
public class Mobil extends Kendaraan
{
    private int jmlPintu;

    public Mobil(String merek, String nama, String seri, double hargaSewa, String deskripsi, int jmlPintu)
    {
        super(merek, nama, seri, hargaSewa, deskripsi);
        this.jmlPintu = jmlPintu;
    }

    @Override
    public String getTipeKendaraan()
    {
        return "mobil";
    }

    @Override
    public String getDetailSpesifik()
    {
        return jmlPintu + " pintu";
    }

    public int getJumlahPintu() { return jmlPintu; }
}
