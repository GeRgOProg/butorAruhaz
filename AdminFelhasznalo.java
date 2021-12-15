/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;
//AdminFelhasznalo osztály
//Egy adminisztrátor jogosultságú felhasználó implementációja

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AdminFelhasznalo extends Felhasznalo{
    private String felhasznalonev;
    private String jelszo;
    private Megrendeles aktualis;
    //Konstruktor
    public AdminFelhasznalo(String _felhasznalonev, String _jelszo)
    {
        super(_felhasznalonev, _jelszo, "admin");
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
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println(lista.get(i).getFelhasznalonev());
        }
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
   
   //TerméketHozzáad
    @Override
   public void TermeketHozzaad(Raktar r)
   {
       System.out.println("Termék hozzáadása");
       int id;
       String nev;
       int ar;
       String szin;
       double magassag;
       double szelesseg;
       BufferedReader keyboard = null;
       
       
       try
       {
           keyboard = new BufferedReader(new InputStreamReader(System.in));
           System.out.print("Termék ID: ");
           id = Integer.valueOf(keyboard.readLine());
           System.out.print("Termék név: ");
           nev = keyboard.readLine();
           System.out.print("Ár: ");
           ar = Integer.valueOf(keyboard.readLine());
           System.out.print("Szín: ");
           szin = keyboard.readLine();
           System.out.print("Magasság: ");
           magassag = Double.valueOf(keyboard.readLine());
           System.out.print("Szélesség: ");
           szelesseg = Double.valueOf(keyboard.readLine());
           Termek ujtermek = new Termek(id,nev,ar,szin,magassag,szelesseg);
           r.TermeketHozzaad(ujtermek);
           System.out.println("Termék sikeresen hozzáadva!");
       }catch(IOException e)
       {
           System.out.println("I/O hiba történt!");
       }
   }
   
   //TerméketTöröl
    @Override
   public void TermeketTorol(Raktar r)
   {
       System.out.println("Termék törlése");
      Listaz(r);
      BufferedReader keyboard = null;  
       try
       {
           keyboard = new BufferedReader(new InputStreamReader(System.in));
           int hanyadik;
           System.out.print("\nMelyik elemet szeretné törölni?\nVálasz(Szám a listáról):");
           hanyadik = Integer.valueOf(keyboard.readLine());
           r.TermeketTorol(hanyadik);
       }catch(IOException e)
       {
           System.out.println("I/O hiba történt!");
       }
       
   }
   //TerméketMódosít
    @Override
   public void TermeketModosit(Raktar r)
   {
       System.out.println("Termék módosítása");
       int ID;
       String nev;
       Listaz(r);
       BufferedReader keyboard = null;  
       try
       {
           keyboard = new BufferedReader(new InputStreamReader(System.in));
           int hanyadik;
           System.out.print("\nMelyik elemet szeretné módosítani?\nVálasz(Szám a listáról):");
           hanyadik = Integer.valueOf(keyboard.readLine());
           r.TermeketTorol(hanyadik);
       }catch(IOException e)
       {
           System.out.println("I/O hiba történt!");
       }
       
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
   
   //RendelestLetrehoz
    @Override
   public void RendelestLetrehoz()
   {
       if(this.aktualis == null)
       {
       Megrendeles uj = new Megrendeles();
       this.aktualis = uj;
       System.out.println("Rendelés ID(" + this.aktualis.getId() + ") létrehozva!");
       }else
       {
           System.out.println("Sajnálom, egyszerre csak egy rendelés engedélyezett!");
       }
   }
   //RendelestLekerdez
    @Override
   public void RendelestLekerdez()
   {
       if(this.aktualis != null)
       {
       this.aktualis.kosaratListaz();
       System.out.println("Fizetve: " + this.aktualis.getFizetve());
       }
       else
       {
           System.out.println("Nincs még rendelése!");
       }
     }
   //Kosarhozad
    @Override
   public void Kosarhozad(Raktar r)
   {
      if(this.aktualis != null)
       {
      Listaz(r);
      BufferedReader keyboard = null;
      try
      {
          keyboard = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("\nMelyik elemet szeretné hozzáadni a kosárhoz?\nVálasz(szám a listáról):");
       int valasz = Integer.valueOf(keyboard.readLine());
       Termek kivalasztott = r.TermeketKivalaszt(valasz);
       aktualis.kosarhozad(kivalasztott);
         
      }catch(IOException e)
      {
          System.out.println("I/O hiba történt!");
      }
       }
        else
       {
           System.out.println("Nincs még rendelése!");
       }
    }
   //KosarbolTorol
    @Override
   public void KosarbolTorol()
   {
       if(this.aktualis != null)
       {
       aktualis.kosaratListaz();
       BufferedReader keyboard = null;    
      try
      {
          keyboard = new BufferedReader(new InputStreamReader(System.in));
          System.out.print("\nMelyik elemet szeretné törölni a kosárból?\nVálasz(szám a listáról):");
       int valasz = Integer.valueOf(keyboard.readLine());
       aktualis.kosarbolTorol(valasz);
       System.out.println("Termék sikeresen eltávolítva a kosárból!\nVégösszeg: " + this.aktualis.getVegosszeg());
      }catch(IOException e)
      {
          System.out.println("I/O hiba történt!");
      }
       }else
       {
           System.out.println("Nincs még rendelése!");
       }
   }
   //Vasarlas
    @Override
   public void Vasarlas()
   {
       if(this.aktualis != null)
       {
       System.out.println("Rendelés jelenlegi állapota");
       this.RendelestLekerdez();
       System.out.println("Végösszeg: " + this.aktualis.getVegosszeg());
       BufferedReader keyboard = null;
              try
              {
                  keyboard = new BufferedReader(new InputStreamReader(System.in));
               System.out.print("Szeretne fizetni? Válasz(igen/nem): ");
               String valasz = keyboard.readLine().toLowerCase();
               switch(valasz)
               {
                   case "igen":
                   {
                       this.aktualis.fizetve();
                       System.out.println("Köszönjük szépen a vásárlást!\nTovábbi szép napot!");
                       this.aktualis = null;
                       
                   }break;
                   
                   case "nem":
                   {
                       System.out.print("Törölni szeretné a rendelését?\nVálasz(igen/nem): ");
                       String torli = keyboard.readLine().toLowerCase();
                       switch(torli)
                       {
                           case "igen":
                           {
                               for(int i = 0; i < this.aktualis.getTetelszam(); i++)
                                   this.aktualis.kosarbolTorol(i+1);
                               this.aktualis = null;
                               System.out.println("Rendelés törölve!");
                           }break;
                           
                           case "nem":
                           {
                               System.out.println("Rendben. Tranzakció visszavonva!");
                           }break;
                           
                           default: {System.out.println("Nem megfelelő formátum! Kérem igennel vagy nemmel válaszoljon!"); }break;
                       }
                   }break;
                   default: {
                       System.out.println("Nem megfelelő formátum! Kérem igennel vagy nemmel válaszoljon!");
                   }break;
              }
              }catch(IOException e)
              {
                  System.out.println("I/O hiba történt!");
              }
       }else
       {
           System.out.println("Nincs még rendelése!");
       }
   }
   
}
