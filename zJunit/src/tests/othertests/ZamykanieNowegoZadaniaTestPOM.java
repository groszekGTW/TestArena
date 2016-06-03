package tests.othertests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.loginpages.LogowanieUzytkownika;
import pages.otherpages.kokpit.MenuGorne;
import pages.otherpages.kokpit.MenuLewe;
import pages.otherpages.zadania.ZadaniaSekcja;
import pages.otherpages.zadania.ZadaniaSzczegoly;
import pages.otherpages.zadania.ZadaniaSzczegolyNowego;
import pages.otherpages.zadania.ZamykanieZadania;

public class ZamykanieNowegoZadaniaTestPOM {
	protected WebDriver driver;

	LogowanieUzytkownika lgp;
	MenuGorne mg;
	MenuLewe ml;
	ZadaniaSekcja zd;
	ZadaniaSzczegolyNowego zsn;
	ZamykanieZadania zz;
	ZadaniaSzczegoly zs;
	 
	@Before	
	public void setup(){
	     driver = new FirefoxDriver();	 
	     driver.get("http://testarena.gpe.pl");
	        
	 }
	 
	 @Test
	 public void test123() throws InterruptedException {
		 
		 lgp = new LogowanieUzytkownika(driver);
		 lgp.loginToArena("groszkowskimichal@gmail.com", "Gro3chu!");
		 
		 mg = new MenuGorne(driver);
		 mg.asercjaZalogowanyUzytkownik();
				 	 		 
		 ml = new MenuLewe(driver);
		 ml.otworzMenuZadania();
			 
		 zd = new ZadaniaSekcja(driver);
		 zd.asercjaZadania();
		 zd.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 zd.dodajNoweZadanie();
		 
		 zsn = new ZadaniaSzczegolyNowego(driver);
		 zsn.asercjatytulWidoku();
		 zsn.dodajNoweZadanie("Nowe srodowisko", "wyd1", "nowa wersja", "Krytyczny", "2018-08-23 23:59", "Mi", "tytul1", "opis opis opis");
		 
		 zs = new ZadaniaSzczegoly(driver);
		 zs.sprawdzKomunikatPoDodaniuZadania();
		 
		 ml.otworzMenuZadania();
		 
		 zd.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 zd.akcjeZamknij();
		 
		 zz = new ZamykanieZadania(driver);
		 zz.zamykanieZadania("Powodzenie", "komentarz");
		 zd.sprawdzKomunikatPoZamknieciuZadania();
		 
		 zd.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");

	
	 }
	 
	

}
