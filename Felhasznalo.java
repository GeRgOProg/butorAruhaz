/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butoraruhaz;

//Felhasználó ősosztály

import java.util.List;

//Ebből fog származni a 3 másik felhasználó osztálya
public class Felhasznalo {
  private String felhasznalonev;
  private String jelszo;
  private String jogosultsag;

  
  //Konstruktor
  public Felhasznalo(String _felhasznalonev, String _jelszo, String _jogosultsag)
  {
      this.felhasznalonev = _felhasznalonev;
      this.jelszo = _jelszo;
      this.jogosultsag = _jogosultsag;
  }
  public Felhasznalo()
  {
      this.jogosultsag = "guest";
  }
  //Getterek
  public String getFelhasznalonev()
  {
      return this.felhasznalonev;
  }
  
 protected String getJelszo()
 {
     return this.jelszo;
 }
  
  public String getJogosultsag()
  {
      return this.jogosultsag;
  }
  
  //Regisztráció
  public void Regisztracio(List<Felhasznalo> lista)
  {
    this.Regisztracio(lista);
  }
  
  //Bejelentkezés
  public Felhasznalo Bejelentkezes(List<Felhasznalo> lista)
  {
     return this.Bejelentkezes(lista);
  }
  
  public void Kereses(Raktar r)
  {
      this.Kereses(r);
  }
  
  public void Listaz(Raktar r)
  {
      this.Listaz(r);
  }
  
  public void TermeketMegtekint(Raktar r)
  {
      this.TermeketMegtekint(r);
      
  }
  
 public void TermeketHozzaad(Raktar r)
 {
     this.TermeketHozzaad(r);
 }
 
 public void TermeketTorol(Raktar r)
 {
     this.TermeketTorol(r);
 }
 
 public void TermeketModosit(Raktar r)
 {
     this.TermeketModosit(r);
 }
 
 public void RendelestLetrehoz()
 {
     this.RendelestLetrehoz();
 }
 
 public void RendelestLekerdez()
 {
     this.RendelestLekerdez();
 }
 
 public void Kosarhozad(Raktar r)
 {
     this.Kosarhozad(r);
 }
 public void KosarbolTorol()
 {
     this.KosarbolTorol();
 }
 
 public void Vasarlas()
 {
     this.Vasarlas();
 }
}
