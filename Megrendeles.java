/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;

//Megrendeles osztály

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Egy felhasználó által adott megrendelés implementációja
public class Megrendeles {
    private int id;
    private int tetelszam;
    private int vegosszeg;
    private boolean fizetve;
    private List<Termek> kosar;
    
    //Konstruktor
    public Megrendeles()
    {
        Random rnd = new Random();
        id = rnd.nextInt(999);
        kosar = new ArrayList<>();
        fizetve = false;
    }
    
    //Getterek
    public int getId() {
        return id;
    }

    public int getTetelszam() {
        return tetelszam;
    }

    public int getVegosszeg() {
        return vegosszeg;
    }

    public boolean getFizetve() {
        return fizetve;
    }
    
    //Végösszeg módosítása
    public void vegosszegNovel(int ennyivel)
    {
        this.vegosszeg = this.vegosszeg + ennyivel;
    }
    
    public void vegosszegCsokkent(int ennyivel)
    {
        this.vegosszeg = this.vegosszeg - ennyivel;
    }
    
    //Fizetés
    public void fizetve()
    {
        this.fizetve = true;
        for(int i = 0; i < this.kosar.size(); i++)
        {
            
            kosarbolTorol(i+1);
        }
    }
    
    //Kosár tartalmának megtekintése
    public void kosaratListaz()
    {
        System.out.println("");
        this.tetelszam = kosar.size();
        System.out.println("ID: " + this.id);
        System.out.println("Tételszám: " + this.tetelszam);
        System.out.println("Kosár tartalma: ");
        for(int i = 0; i < kosar.size(); i++)
        {
            System.out.println(i+1 + ".termék: ");
            System.out.println("ID: " + kosar.get(i).getId());
            System.out.println("Név: " + kosar.get(i).getNev());
            System.out.println("Ár: " + kosar.get(i).getAr());
            System.out.println("Szín: " + kosar.get(i).getSzin());
            System.out.println("Magasság: " + kosar.get(i).getMagassag());
            System.out.println("Szélesség: " + kosar.get(i).getSzelesseg());
            System.out.println("");
        }
    }
    
    public void kosarhozad(Termek t)
    {
        
        if(t.getDarabszam() != 0)
        {
        kosar.add(t);
        vegosszegNovel(t.getAr());
        System.out.println("Termék sikeresen kosárhoz adva!\nVégösszeg: " + this.vegosszeg);
        t.setDarabszam(t.getDarabszam()-1);
        }else
        {
            System.out.println("A termékből jelenleg nincs raktáron!");
        }
    }

    public void kosarbolTorol(int hanyadik)
    {
          if(hanyadik-1 < 0 || hanyadik-1 > kosar.size())
        {
            System.out.println("Helytelen index! Próbáld meg újra!");
                    
        }
          else
          {
        Termek kivalasztott = kosar.get(hanyadik - 1);
        vegosszegCsokkent(kosar.get(hanyadik-1).getAr());
        kivalasztott.setDarabszam(kivalasztott.getDarabszam()+1);
       
        kosar.remove(hanyadik-1);
          }
       
    }
}
 
