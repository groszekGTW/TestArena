package testy;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import LoginPage.LogowanieUzytkownika;
import Srodowisko.ElementySrodowiska;
import Srodowisko.FunkcjeSrodowiska;
import kokpit.MenuLewe;


public class test1 {
	protected WebDriver driver;
	
	LogowanieUzytkownika lu;
	MenuLewe ml;
	ElementySrodowiska es;
	FunkcjeSrodowiska fs;
	
	
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();	 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	 
        driver.get("http://testarena.gpe.pl");
 }
	
	
	@Test
	public void TestSrodowisko() throws InterruptedException {
		lu = new LogowanieUzytkownika(driver);
		lu.loginToArena("grzegorzjasik@wp.pl", "Password12#");
	
		ml = new MenuLewe(driver);
		ml.otworzMenuSrodowisko();
		
		es = new ElementySrodowiska(driver);
		es.DodajNoweSrodowisko();

		 

		
		fs = new FunkcjeSrodowiska(driver);
		fs.DodajNowaNazwe("ŒrodowiskoTest");
		fs.DodajNowyOpis("Tutaj znajdujê siê opis œrodowiska");
		fs.ZapiszSrodowisko();
		
		es.EdytujIkona();
		es.EdytujSrodowisko();
		fs.UsunNazwe();
		fs.DodajNowaNazwe("SrodowiskoPoEdytowaniu");
		fs.UsunOpis();
		fs.DodajNowyOpis("Tutaj znadujê siê zmodyfikowany opis œrodowiska");
		fs.ZapiszSrodowisko();
		
		


		es.EdytujIkona();
		es.UsunSrodowisko();
		es.PotwierdzUsun();
		
		
}
	@After
	public void Quit(){
	driver.quit();
	}

}

