package kendaraanPackage;

public class Mobil extends Kendaraan
{
    private int jmlPintu;

    public Mobil(String merek, String seri, double hargaSewa, String deskripsi, int jmlPintu)
    {
        super(deskripsi, merek, hargaSewa, seri);
        this.jmlPintu = jmlPintu;
    }

    @Override
    void tipeKendaraan() {
        //Print kendaraan
    }

    public int getJmlPintu() {
        return jmlPintu;
    }

    public void setJmlPintu(int jmlPintu) {
        this.jmlPintu = jmlPintu;
    }

    public String getMerek(){
        return merek;
    }

    public void setMerek(String merek)
    {
        this.merek = merek;
    }

    public String getSeri()
    {
        return seri;
    }

    public void setSeri()
    {
        this.seri = seri;
    }

    public double getHargaSewa()
    {
        return hargaSewa;
    }

    public void setHargaSewa()
    {
        this.hargaSewa = hargaSewa;
    }

    public String getDeskripsi()
    {
        return deskripsi;
    }

    public void setDeskripsi()
    {
        this.deskripsi = deskripsi;
    }
}