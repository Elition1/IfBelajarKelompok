/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraanPackage;

/**
 *
 * @author Ath07
 */
public class SistemRental {
    private static SistemRental instance;
    
    public static final int MAX_MOBIL = 5;
    public static final int MAX_MOTOR = 5;
    
    private Mobil[] daftarMobil;
    private Motor[] daftarMotor;
    
    private int jmlMobil = 0;
    private int jmlMotor = 0;
    
    private SistemRental() {
        daftarMobil = new Mobil[MAX_MOBIL];
        daftarMotor = new Motor[MAX_MOTOR];
    }
    
    public static SistemRental getInstance() {
        if (instance == null)
            instance = new SistemRental();
        return instance;
    }
    
    public String tambahMobil(Mobil mobil) {
        if (jmlMobil >= MAX_MOBIL) return "Garasi mobil sudah penuh! Maksimal = " + MAX_MOBIL;
            daftarMobil[jmlMobil] = mobil;
            jmlMobil++;
            return "Selesai";
    }
    public String tambahMotor(Motor motor) {
        if (jmlMotor >= MAX_MOTOR) return "Garasi motor sudah penuh! Maksimal = " + MAX_MOBIL;
            daftarMotor[jmlMotor] = motor;
            jmlMotor++;
            return "Selesai";
    }
    
    public boolean hapusMobil(String seri) {
        for (int i = 0; i < jmlMobil; i++) {
            if(daftarMobil[i].getSeri().equals(seri)) {
                for (int j = i; j < jmlMobil - 1; j++) {
                    daftarMobil[j] = daftarMobil[j+1];
                }
                daftarMobil[jmlMobil-1] = null;
                jmlMobil--;
                return true;
            }
        }
        return false;
    }
     public boolean hapusMotor(String seri) {
        for (int i = 0; i < jmlMotor; i++) {
            if(daftarMotor[i].getSeri().equals(seri)) {
                for (int j = i; j < jmlMotor - 1; j++) {
                    daftarMotor[j] = daftarMotor[j+1];
                }
                daftarMotor[jmlMotor-1] = null;
                jmlMotor--;
                return true;
            }
        }
        return false;
    }

    public Mobil[] getDaftarMobil() {
        return daftarMobil;
    }

    public Motor[] getDaftarMotor() {
        return daftarMotor;
    }

    public int getJmlMobil() {
        return jmlMobil;
    }

    public int getJmlMotor() {
        return jmlMotor;
    }
    
    public Kendaraan[] semuaKendaraan() {
        Kendaraan[] semua = new Kendaraan[jmlMobil + jmlMotor];
        int idx =0;
        for (int i = 0; i < jmlMobil; i++) 
            semua[idx++] = daftarMobil[i];
        for (int i = 0; i < jmlMotor; i++) 
            semua[idx++] = daftarMotor[i];
        return semua;
    }
     
    public boolean canAddMobil() {
        return jmlMobil < MAX_MOBIL;
    }
    public boolean canAddMotor() {
        return jmlMotor < MAX_MOTOR;
    }
 }
