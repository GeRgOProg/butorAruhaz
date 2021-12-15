/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class VendegFelhasznalo extends Felhasznalo{

public VendegFelhasznalo()
{
    super();
}

  //Regisztráció
    @Override
    public void Regisztracio(List<Felhasznalo> lista)
    {
     System.out.println("Regisztráció");
        String felhasznalonev;
        String jelszo;
        BufferedReader keyboard = null;
        boolean mehetTovabb = true;
        try
        {
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Felhasználónév: ");
            felhasznalonev = keyboard.readLine();
            if(felhasznalonev.length() < 1)
            {
                mehetTovabb = false;
                System.out.println("Felhasználónév nem lehet üres!");   
            }
            else
            {
            for(int i = 0; i < lista.size(); i++)
            {
                if(lista.get(i).getFelhasznalonev().equals(felhasznalonev))
                {
                    System.out.println("Ez a felhasználó már létezik!");
                    mehetTovabb = false;
                    break;
                }
            }
            }
            if(mehetTovabb == true)
            {
            System.out.print("Jelszó: ");
            jelszo = keyboard.readLine();
            if(jelszo.length() < 1)
            {
                System.out.println("Jelszó nem lehet üres!");
                mehetTovabb = false;
            }
            if(mehetTovabb == true)
            {
            RegisztraltFelhasznalo ujfelhasznalo = new RegisztraltFelhasznalo(felhasznalonev, jelszo);
            lista.add(ujfelhasznalo);
            System.out.println("Felhasználó sikeresen regisztrálva!");
            }
            else if(mehetTovabb == false)
            {
                System.out.println("Regisztráció nem sikerült!");
            }
            }
            else if(mehetTovabb == false)
            {
                System.out.println("Regisztráció nem sikerült!");
            }
           
        }catch(IOException e)
        {
            System.out.println("I/O hiba történt!");
        }
    }   
 //Bejelentkezes
    
    @Override
    public Felhasznalo Bejelentkezes(List<Felhasznalo> lista)
    {
         System.out.println("Bejelentkezés");
        String felhasznalonev;
        String jelszo;
        boolean megtalalta = false;
        BufferedReader keyboard = null;
        try
        {
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Felhasználónév: ");
            felhasznalonev = keyboard.readLine();
            System.out.print("Jelszó: ");
            jelszo = keyboard.readLine();
            for(int i = 0; i < lista.size(); i++)
            {
                if(felhasznalonev.equals(lista.get(i).getFelhasznalonev()))
                {
                    if(jelszo.equals(lista.get(i).getJelszo()))
                    {
                        System.out.println("Sikeres belépés! Belépve mint: " + lista.get(i).getFelhasznalonev());
                        return lista.get(i);
                       
                    }
                    else
                    {
                        megtalalta = true;
                        System.out.println("Rossz jelszó!");
                        break;
                    }
                }
            }
            if(megtalalta == false)
                System.out.println("Ilyen felhasználó még nincs..");
            
        }catch(IOException e)
        {
            System.out.println("I/O hiba történt!");
        }
        VendegFelhasznalo def = new VendegFelhasznalo();
        return def;
    }
    
    //Keresés
    @Override
   public void Kereses(Raktar r)
   {
       r.Kereses();
   }
   
    //TerméketMegtekint
    @Override
   public void TermeketMegtekint(Raktar r)
   {
       BufferedReader keyboard = null;  
       try
       {
           keyboard = new BufferedReader(new InputStreamReader(System.in));
           int hanyadik;
           System.out.print("\nMelyik elemet szeretné megtekinteni?\nVálasz(Szám a listáról):");
           hanyadik = Integer.valueOf(keyboard.readLine());
           r.TermeketMegtekint(hanyadik);
       }catch(IOException e)
       {
           System.out.println("I/O hiba történt!");
       }
   }
   //Listaz
    @Override
   public void Listaz(Raktar r)
   {
       r.Listaz();
   }
}
