/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraanPackage;

/**
 *
 * @author Ath07
 */
public abstract class Kendaraan {
    private String nama, merek, seri, deskripsi;
    private double hargaSewa;
    private boolean dipinjam;

    public Kendaraan(String merek, String nama,  String seri,  double hargaSewa, String deskripsi) {
        this.nama = nama;
        this.merek = merek;
        this.seri = seri;
        this.deskripsi = deskripsi;
        this.hargaSewa = hargaSewa;
        this.dipinjam = false;
    }
    
    public abstract String getTipeKendaraan();
    public abstract String getDetailSpesifik();
    
    public String getInfoLengkap() {
        return "[" + getTipeKendaraan() + "]" + merek + " " + nama + " | Seri: " + seri + " | Rp" + hargaSewa + " | " + getDetailSpesifik();
    }
    
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public boolean isDipinjam() {
        return dipinjam;
    }

    public void setDipinjam(boolean dipinjam) {
        this.dipinjam = dipinjam;
    }
    
    
}

