/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;

//Raktar osztály

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//Az áruház raktárának implementációja
public class Raktar {
    private int darabszam;
    private List<Termek> termekek;
    
    //Konstruktor
    public Raktar()
    {
        termekek = new ArrayList<>();
    }
    
    //Getter
    public int getDarabszam() {
        return darabszam;
    }
    
    //Lista módosító és lekérdező függvények
    public void Listaz()
    {
       
        if(termekek.size() == 0)
        {
            System.out.println("Jelenleg nincs termék a raktárban!");
        }
        else
        {
             System.out.println("");
            System.out.println("Termékek listázása");
            System.out.printf("%1s %30s %15s %15s %15s %15s %15s","ID", "Név", "Ár", "Szín", "Magasság", "Szélesség","Raktáron");
        for(int i = 0; i < termekek.size(); i++)
        {
            System.out.println("");
            System.out.format("%1s %30s %15s %15s %15s %15s %15s",termekek.get(i).getId(), termekek.get(i).getNev(), termekek.get(i).getAr(), termekek.get(i).getSzin(), termekek.get(i).getMagassag(), termekek.get(i).getSzelesseg(), termekek.get(i).getDarabszam());
            
        }
            System.out.println("\nListázás kész!");
        }
    }
    
    public void TermeketHozzaad(Termek t)
    {
        boolean letezik = false;
        for(int i = 0; i < termekek.size(); i++)
        {
            if(t.getId() == termekek.get(i).getId())
            {
                letezik = true;
                termekek.get(i).setDarabszam(termekek.get(i).getDarabszam() + 1);
                break;
            }
        }
        if(letezik == false)
        termekek.add(t);
        
    }
    
    public void TermeketTorol(int hanyadik)
    {
       termekek.remove(hanyadik-1);
        System.out.println("Termék sikeresen törölve!");
    }
    
    public void TermeketMegtekint(int hanyadik)
    {
        if(hanyadik-1 < 0 || hanyadik-1 > termekek.size())
        {
            System.out.println("Helytelen index! Próbáld meg újra!");
                    
        }
        else
        {
        System.out.println(hanyadik + ". Termék megtekintése: ");
        System.out.println("ID: " + termekek.get(hanyadik-1).getId());
        System.out.println("Név: " + termekek.get(hanyadik-1).getNev());
        System.out.println("Szín: " + termekek.get(hanyadik-1).getSzin());
        System.out.println("Magasság: " + termekek.get(hanyadik-1).getMagassag());
        System.out.println("Szélesség: " + termekek.get(hanyadik-1).getSzelesseg());
        System.out.println("Raktáron: " + termekek.get(hanyadik-1).getDarabszam() + "db");
        }
        }
    public Termek TermeketKivalaszt(int hanyadik)
    {
         if(hanyadik-1 < 0 || hanyadik-1 > termekek.size())
        {
            System.out.println("Helytelen index! Próbáld meg újra!");
                    
        }
         else
        return termekek.get(hanyadik-1);
        return null;
    }
    public void Kereses()
    {
        BufferedReader keyboard = null;
        try
        {
         keyboard = new BufferedReader(new InputStreamReader(System.in));
         if(keyboard != null)
         {
              System.out.println("");
            System.out.println("Mi alapján szeretnél keresni?");
            System.out.println("1 - ID");
            System.out.println("2 - Név");
            System.out.println("3 - Szín");
            System.out.println("4 - Magasság");
            System.out.println("5 - Szélesség");
            System.out.print("Válasz: ");
            int response = Integer.valueOf(keyboard.readLine());
            switch(response)
            {
                case 1:
                {
                    System.out.print("\nID beolvasása: ");
                    int keresettID = Integer.valueOf(keyboard.readLine());
                    boolean megtalalva = false;
                    int keresettindex = 0;
                     for(int i = 0; i < termekek.size(); i++)
                    {
                       if(termekek.get(i).getId()== keresettID)
                       {
                           megtalalva = true;
                           keresettindex = i;
                       }
                    }
                   if(megtalalva == true)
                    TermeketMegtekint(keresettindex+1);
                     else
                        System.out.println("Nincs ilyen termék..");
                }break;
                case 2:
                {
                    System.out.print("\nNév beolvasása: ");
                    String keresettNev = keyboard.readLine();
                    boolean megtalalva = false;
                    int keresettindex = 0;
                     for(int i = 0; i < termekek.size(); i++)
                    {
                       if(termekek.get(i).getNev().equals(keresettNev))
                       {
                           megtalalva = true;
                           keresettindex = i;
                       }
                    }
                     if(megtalalva == true)
                    TermeketMegtekint(keresettindex+1);
                     else
                        System.out.println("Nincs ilyen termék..");
                }break;
                case 3:
                {
                    List<Integer> talalat = new ArrayList<>();
                    System.out.print("\nSzín beolvasása: ");
                    String keresettSzin = keyboard.readLine();
                    boolean megtalalva = false;
                   
                     for(int i = 0; i < termekek.size(); i++)
                    {
                       if(termekek.get(i).getSzin().equals(keresettSzin))
                       {
                           megtalalva = true;
                           talalat.add(i);
                       }
                    }
                     if(megtalalva == true)
                     {
                         for(int i = 0; i < talalat.size(); i++)
                         {
                             TermeketMegtekint(talalat.get(i) + 1);
                             System.out.println();
                         }
                     }
                     else
                        System.out.println("Nincs ilyen termék..");
                }break;
                case 4:
                {
                     List<Integer> talalat = new ArrayList<>();
                    System.out.print("\nSzélesség beolvasása: ");
                    double keresettSzelesseg = Double.valueOf(keyboard.readLine());
                    boolean megtalalva = false;
                   
                     for(int i = 0; i < termekek.size(); i++)
                    {
                       if(termekek.get(i).getSzelesseg() == keresettSzelesseg)
                       {
                           megtalalva = true;
                           talalat.add(i);
                       }
                    }
                     if(megtalalva == true)
                     {
                         for(int i = 0; i < talalat.size(); i++)
                         {
                             TermeketMegtekint(talalat.get(i) + 1);
                             System.out.println();
                         }
                     }
                     else
                        System.out.println("Nincs ilyen termék..");
                }break;
                case 5:
                {
                     List<Integer> talalat = new ArrayList<>();
                    System.out.print("\nMagasság beolvasása: ");
                    double keresettMagassag = Double.valueOf(keyboard.readLine());
                    boolean megtalalva = false;
                   
                     for(int i = 0; i < termekek.size(); i++)
                    {
                       if(termekek.get(i).getMagassag() == keresettMagassag)
                       {
                           megtalalva = true;
                           talalat.add(i);
                       }
                    }
                     if(megtalalva == true)
                     {
                         for(int i = 0; i < talalat.size(); i++)
                         {
                             TermeketMegtekint(talalat.get(i) + 1);
                             System.out.println();
                         }
                     }
                     else
                        System.out.println("Nincs ilyen termék..");
                }break;
            }
         }
        }catch(IOException e)
        {
            System.out.println("I/O hiba történt!");
        }
    }
    
    public void fajlbair()
    {
        PrintWriter pw = null;
         try
            {
                 pw = new PrintWriter("termekek.txt");
               for(int i = 0; i < termekek.size(); i++)
               {
                   Termek kovetkezo = termekek.get(i);
                   pw.println(kovetkezo.getId() + ";" +kovetkezo.getNev() + ";" + kovetkezo.getAr() + ";" + kovetkezo.getSzin() + ";" + kovetkezo.getMagassag() + ";" + kovetkezo.getSzelesseg() + ";" + kovetkezo.getDarabszam());
                   pw.flush();
               }
            }catch(FileNotFoundException e)
            {
                System.out.println("File nem található!");
            }finally{
                if(pw != null)
                pw.close();
            }
    }
}

