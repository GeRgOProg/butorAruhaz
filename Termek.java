/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;

//Termek osztály
//Egy adott termék implementációja
public class Termek {
    private int id;
    private String nev;
    private int ar;
    private String szin;
    private double magassag;
    private double szelesseg;
    private int darabszam;
    
    //Konstruktor
    public Termek(int _id, String _nev, int _ar, String _szin, double _magassag, double _szelesseg)
    {
        this.id = _id;
        this.nev = _nev;
        this.ar = _ar;
        this.szin = _szin;
        this.magassag = _magassag;
        this.szelesseg = _szelesseg;
        this.darabszam = 1;
    }
    
    public Termek(int _id, String _nev, int _ar, String _szin, double _magassag, double _szelesseg, int _darabszam)
    {
        this.id = _id;
        this.nev = _nev;
        this.ar = _ar;
        this.szin = _szin;
        this.magassag = _magassag;
        this.szelesseg = _szelesseg;
        this.darabszam = _darabszam;
    }
    
    //Getterek
    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    public String getSzin() {
        return szin;
    }

    public double getMagassag() {
        return magassag;
    }

    public double getSzelesseg() {
        return szelesseg;
    }

    public int getDarabszam() {
        return darabszam;
    }
    
    //Setterek

    public void setId(int id) {
        this.id = id;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public void setMagassag(double magassag) {
        this.magassag = magassag;
    }

    public void setSzelesseg(double szelesseg) {
        this.szelesseg = szelesseg;
    }

    public void setDarabszam(int darabszam) {
        if(darabszam != 0)
        this.darabszam = darabszam;
        else
       this.darabszam = 0;
    }
    
}
