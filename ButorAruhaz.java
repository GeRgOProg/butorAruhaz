/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author X7PT4C
 */

//Szoftvertechnológia 24-es csoport
//Keresztúri Gergő (X7PT4C)
//Bősze Máté (BM9PC7
//Molnár Ákos (CYA4YX)

//Bútoráruház projekt: Program
public class ButorAruhaz {
public Raktar butorRaktar = new Raktar();
protected List<Felhasznalo> felhasznalok = new ArrayList<>();
public Felhasznalo aktualisFelhasznalo = new VendegFelhasznalo();


public void start()
    {
        
         //Fájlból olvasás 
        {
          BufferedReader file = null;
          try
          {
              try
              {
              file = new BufferedReader(new FileReader("felhasznalok.txt"));
              if(file != null)
              {
                  String line;
                  while((line = file.readLine()) != null)
                  {
                      String[] words = line.split(";");
                      String nev = words[0];
                      String jelszo = words[1];
                      String jogosultsag = words[2];
                      if(jogosultsag.equals("user"))
                      {
                      RegisztraltFelhasznalo uj = new RegisztraltFelhasznalo(nev,jelszo);
                      felhasznalok.add(uj);
                      }
                      else if(jogosultsag.equals("admin"))
                      {
                          AdminFelhasznalo uj = new AdminFelhasznalo(nev, jelszo);
                          felhasznalok.add(uj);
                      }
                      else if(jogosultsag.equals("guest"))
                      {
                          continue;
                      }
                  }
              }
          }catch(FileNotFoundException e)
          {
              System.out.println("Fájl nem található!");
          }
          }catch(IOException e)
          {
              System.out.println("I/O hiba történt!");
          }
           
         try
         {
             try
             {
                 file = new BufferedReader(new FileReader("termekek.txt"));
              if(file != null)
              {
                  String line;
                  while((line = file.readLine()) != null)
                  {
                      String[] words = line.split(";");
                      int id = Integer.valueOf(words[0]);
                      String nev = words[1];
                      int ar = Integer.valueOf(words[2]);
                      String szin = words[3];
                      double magassag = Double.valueOf(words[4]);
                      double szelesseg = Double.valueOf(words[5]);
                      int darabszam = Integer.valueOf(words[6]);
                      Termek uj = new Termek(id,nev,ar,szin,magassag,szelesseg,darabszam);
                     butorRaktar.TermeketHozzaad(uj);
                      
                  }
              }
             }catch(FileNotFoundException e)
             {
                 System.out.println("Fájl nem található");
             }
         }catch(IOException e)
         {
             System.out.println("I/O hiba történt!");
         }
          
        }
        
        
        
        //Alkalmazás kezdete
        menu(aktualisFelhasznalo);
    }
    public static void main(String[] args) {
      
       
        new ButorAruhaz().start();
    
    }
    public void menu(Felhasznalo jelenlegi)
    {
        //Fájlba írás
        {
            PrintWriter pw = null;
            try
            {
               pw = new PrintWriter("felhasznalok.txt");
               for(int i = 0; i < felhasznalok.size(); i++)
               {
                   Felhasznalo kovetkezo = felhasznalok.get(i);
                   pw.println(kovetkezo.getFelhasznalonev() + ";" + kovetkezo.getJelszo()+ ";" + kovetkezo.getJogosultsag());
                   pw.flush();
               }
            }catch(FileNotFoundException e)
            {
                System.out.println("File nem található!");
            }finally{
                if(pw != null)
                pw.close();
            }
               butorRaktar.fajlbair();
        }
        System.out.println("");
        String jogosultsag = jelenlegi.getJogosultsag();
        switch(jogosultsag)
        {
            case "user":
            {
                
                BufferedReader keyboard = null;
                try
                {
                keyboard = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Üdvözöljük a bútoráruházban!");
                System.out.println("Bejelentkezve mint: " + jelenlegi.getFelhasznalonev()+ "(USER)");
                System.out.println("1 - Regisztráció");
                System.out.println("2 - Bejelentkezés");
                System.out.println("3 - Keresés");
                System.out.println("4 - Termékek listázása");
                System.out.println("5 - Termék megtekintése");
                System.out.println("6 - Megrendelés létrehozása");
                System.out.println("7 - Megrendelés állapotának lekérdezése");
                System.out.println("8 - Kosárhoz adás");
                System.out.println("9 - Kosárból törlés");
                System.out.println("10 - Vásárlás és fizetés");
                System.out.println("11 - Kilépés");
                System.out.print("Válasz: ");
                 try
                {
                int valasz = Integer.valueOf(keyboard.readLine());
               
                switch(valasz)
                {
                    case 1:
                    {
                        jelenlegi.Regisztracio(felhasznalok);
                        menu(jelenlegi);
                    }break;
                    
                    case 2:
                    {
                        jelenlegi = jelenlegi.Bejelentkezes(felhasznalok);
                        
                        menu(jelenlegi);
                    }break;
                    
                    case 3:
                    {
                        jelenlegi.Kereses(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 4:
                    {
                        jelenlegi.Listaz(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 5:
                    {
                        jelenlegi.TermeketMegtekint(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 6:
                    {
                        jelenlegi.RendelestLetrehoz();
                        menu(jelenlegi);
                    }break;
                    
                    case 7:
                    {
                        jelenlegi.RendelestLekerdez();
                        menu(jelenlegi);
                        }break;
                    
                    case 8:
                    {
                        jelenlegi.Kosarhozad(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 9:
                    {
                        jelenlegi.KosarbolTorol();
                        menu(jelenlegi);
                    }break;
                    
                    case 10:
                    {
                        jelenlegi.Vasarlas();
                        menu(jelenlegi);
                    }break;
                           
                    case 11: break;
                    default: {System.out.println("Hiba történt!"); menu(jelenlegi);}break;     
                  
                }
                }catch(NumberFormatException e)
                {
                    System.out.println("Rossz formátum! Kérem számot írjon!");
                    menu(jelenlegi);
                }
                }catch(IOException e)
                {
                    System.out.println("I/O hiba történt!");
                }
            }break;
            
            case "admin":
            {
                 BufferedReader keyboard = null;
                try
                {
                    keyboard = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Üdvözöljük a bútoráruházban!");
                System.out.println("Bejelentkezve mint: " + jelenlegi.getFelhasznalonev() + "(ADMIN)");
                System.out.println("1 - Regisztráció");
                System.out.println("2 - Bejelentkezés");
                System.out.println("3 - Keresés");
                System.out.println("4 - Termék hozzáadása");
                System.out.println("5 - Termék törlése");
                System.out.println("6 - Termék módosítása");
                System.out.println("7 - Termékek listázása");
                System.out.println("8 - Termék megtekintése");
                System.out.println("9 - Megrendelés létrehozása");
                System.out.println("10 - Megrendelés állapotának lekérdezése");
                System.out.println("11 - Kosárhoz adás");
                System.out.println("12 - Kosárból törlés");
                System.out.println("13 - Vásárlás és fizetés");
                System.out.println("14 - Kilépés");
                System.out.print("Válasz: ");
                 try
                {
                int valasz = Integer.valueOf(keyboard.readLine());
               
               switch(valasz)
               {
                   case 1:
                   {
                       jelenlegi.Regisztracio(felhasznalok);
                       menu(jelenlegi);
                   }break;
                   
                   case 2:
                   {
                       jelenlegi = jelenlegi.Bejelentkezes(felhasznalok);
                       menu(jelenlegi);
                   }break;
                
                   case 3:
                   {
                       jelenlegi.Kereses(butorRaktar);
                       menu(jelenlegi);
                   }break;
                   
                   case 4:
                   {
                       jelenlegi.TermeketHozzaad(butorRaktar);
                       menu(jelenlegi);
                      
                   }break;
                   
                   case 5:
                   {
                    jelenlegi.TermeketTorol(butorRaktar);
                    menu(jelenlegi);
                   }break;
                   
                   case 6:
                   {
                       jelenlegi.TermeketModosit(butorRaktar);
                       menu(jelenlegi);
                   }break;
                   
                   case 7:
                   {
                       jelenlegi.Listaz(butorRaktar);
                       menu(jelenlegi);
                   }break;
                   
                   case 8:
                   {
                       jelenlegi.TermeketMegtekint(butorRaktar);
                       menu(jelenlegi);
                   }break;
                   
                   case 9:
                   {
                       jelenlegi.RendelestLetrehoz();
                       menu(jelenlegi);
                   }break;
                   
                   case 10:
                   {
                       jelenlegi.RendelestLekerdez();
                       menu(jelenlegi);
                   }break;
                   
                   case 11:
                   {
                       jelenlegi.Kosarhozad(butorRaktar);
                       menu(jelenlegi);
                   }break;
                   
                   case 12:
                   {
                       jelenlegi.KosarbolTorol();
                       menu(jelenlegi);
                   }break;
                   
                   case 13:
                   {
                       jelenlegi.Vasarlas();
                       menu(jelenlegi);
                   }break;
                   
                   case 14:break;
                   default: {System.out.println("Hiba történt!"); menu(jelenlegi);}break;
               }
                }catch(NumberFormatException e)
                {
                    System.out.println("Rossz formátum! Kérem számot írjon!");
                    menu(jelenlegi);
                }
                }catch(IOException e)
                {
                    System.out.println("I/O hiba történt!");
                }
                
            }break;
            
            case "guest":
            {
                 BufferedReader keyboard = null;
                try
                {
                    keyboard = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Üdvözöljük a bútoráruházban!");
                System.out.println("Bejelentkezve mint: Vendeg(GUEST)");
                System.out.println("1 - Regisztráció");
                System.out.println("2 - Bejelentkezés");
                System.out.println("3 - Keresés");
                System.out.println("4 - Termékek listázása");
                System.out.println("5 - Termék megtekintése");
                System.out.println("6 - Kilépés");
                    System.out.print("Válasz: ");
                    try
                    {
                int valasz = Integer.valueOf(keyboard.readLine());
                switch(valasz)
                {
                    case 1:
                    {
                      jelenlegi.Regisztracio(felhasznalok);
                      menu(jelenlegi);
                    }break;
                    
                    case 2:
                    {
                        jelenlegi = jelenlegi.Bejelentkezes(felhasznalok);
                        menu(jelenlegi);
                    }break;
                    
                    case 3:
                    {
                        jelenlegi.Kereses(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 4:
                    {
                        jelenlegi.Listaz(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 5:
                    {
                        jelenlegi.TermeketMegtekint(butorRaktar);
                        menu(jelenlegi);
                    }break;
                    
                    case 6: break;
                    default: {System.out.println("Hiba történt!"); menu(jelenlegi);}break;
                }
                 }catch(NumberFormatException e)
                {
                    System.out.println("Rossz formátum! Kérem számot írjon!");
                    menu(jelenlegi);
                }
                 }catch(IOException e)
                {
                    System.out.println("I/O hiba történt!");
                }
                
            }break;
            default: {System.out.println("Hiba történt!"); menu(jelenlegi);}break;     
        }
    }
}
