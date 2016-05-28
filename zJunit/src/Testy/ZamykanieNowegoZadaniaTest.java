package Testy;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import LoginPage.LogowanieUzytkownika;
import Zadania.ZadaniaSekcja;
import Zadania.ZadaniaSzczegoly;
import Zadania.ZamykanieZadania;
import kokpit.MenuGorne;
import kokpit.MenuLewe;

public class ZamykanieNowegoZadaniaTest {
	protected WebDriver driver;

	LogowanieUzytkownika lgp;
	MenuGorne mg;
	MenuLewe ml;
	ZadaniaSekcja zd;
	ZadaniaSzczegoly zs;
	ZamykanieZadania zz;
	 
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
		 
		 zs = new ZadaniaSzczegoly(driver);
		 zs.asercjatytulWidoku();
		 zs.dodajNoweZadanie("Nowe srodowisko", "wyd1", "nowa wersja", "Krytyczny", "2018-08-23 23:59", "Mi", "tytul1", "opis opis opis");
		 		 
		 ml.otworzMenuZadania();
		 
		 zd.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 zd.akcjeZamknij();
		 
		 zz = new ZamykanieZadania(driver);
		 zz.zamykanieZadania("Powodzenie", "komentarz");
	
	 }
	 
	

}
