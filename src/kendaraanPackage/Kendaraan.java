/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraanPackage;

abstract class Kendaraan {
    private String deskripsi;
    private String merek;
    private String seri;
    public double hargaSewa;

    public Kendaraan(String deskripsi, String merek, String seri, double hargaSewa)
    {
        this.merek = merek;
        this.hargaSewa = hargaSewa;
        this.deskripsi = deskripsi;
        this.seri = seri;
    }

    public Kendaraan() {
        this.merek = null;
        this.seri = null;
        this.hargaSewa = 0;
        this.deskripsi = "Tidak Ada Deskripsi";
    }

    abstract void tipeKendaraan();
}
