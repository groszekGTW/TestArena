package testy;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import LoginPage.loginPage;
import Zadania.ZadaniaSection;
import Zadania.ZadaniaSzczegoly;
import kokpit.menuGorne;
import kokpit.menuLewe;

public class test {
	protected WebDriver driver;

	loginPage lgp;
	menuGorne mg;
	menuLewe ml;
	ZadaniaSection zd;
	ZadaniaSzczegoly zs;
	 
	@Before	
	public void setup(){	 
	        driver = new FirefoxDriver();	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	 
	        driver.get("http://testarena.gpe.pl");
	 }
	 
	 @Test
	 public void test123() throws InterruptedException {
		 lgp = new loginPage(driver);
		 lgp.loginToArena("groszkowskimichal@gmail.com", "Gro3chu!");
		
		 ml = new menuLewe(driver);
		 ml.getZadania();
		 zd = new ZadaniaSection(driver);
		 zd.filtrowaniePrzezFiltry("wyd1", "[Wszystkie]", "Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "[Wszystkie]", "10");
		 zd.dodajNoweZadanie();
		 zs= new ZadaniaSzczegoly(driver);
		 //zs.dodajsrodowisko("Nowe srodowisko");
		 zs.dodajsrodowisko("Nowe srodowisko");
		 zs.dodajWersje("nowa wersja");
		 zs.WybierzPriorytet("Krytyczny");
		 zs.WybierzTerminrealizacji("2018-08-23 23:59");
		 zs.prypiszDoKogos("Mi");
		 zs.dodajTytul("tytul1");
		 zs.dodajOpis("opis opis opis");
		 zs.zapiszZmiany();

		 //zd.WybierzFiltrWydanie("wyd1");
		

	 }
	 
	

}
