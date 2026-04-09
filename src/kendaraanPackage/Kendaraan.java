/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraanPackage;

abstract class Kendaraan {
    private String deskripsi;

    public Kendaraan(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Kendaraan() {
        this.deskripsi = "Tidak Ada Deskripsi";
    }
}
