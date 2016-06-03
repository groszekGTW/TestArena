package tests.othertests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.loginpages.LogowanieUzytkownika;
import pages.otherpages.kokpit.MenuLewe;
import pages.otherpages.wersje.WersjeSekcja;
import pages.otherpages.wersje.WersjeSzczegolyNowej;

public class EdycjaNowejWersjiTestPOM {
	
	protected WebDriver driver;
	LogowanieUzytkownika lgp;
	MenuLewe ml;
	WersjeSekcja ws;
	WersjeSzczegolyNowej wsn;
	 
	@Before	
	public void setup(){
	     driver = new FirefoxDriver();	 
	     driver.get("http://testarena.gpe.pl");		        
	 }
	 
	 @Test
	 public void test123() throws InterruptedException {
		 lgp = new LogowanieUzytkownika(driver);
		 lgp.loginToArena("groszkowskimichal@gmail.com", "Gro3chu!");	
		 
		 ml = new MenuLewe(driver);
		 ml.otworzMenuWersje();
		 
		 ws =  new WersjeSekcja(driver);
		 ws.asercjaWersje();
		 ws.dodajNowaWersje();
		 
		 wsn = new WersjeSzczegolyNowej(driver);
		 wsn.zapiszNowaWersje("wersja4");
		 
		 ws.sprawdzKomunikatPoZapisieWersji();
		 ws.szukajWyniku("wersja4");
		 ws.akcjeEdytuj();
		 
		 wsn.zapiszNowaWersje("wersja4.1");
		 
		 ws.sprawdzKomunikatPoEdytowaniuWersji();
		 ws.szukajWyniku("wersja4");
		 ws.akcjeUsun();
		 ws.sprawdzKomunikatPrzyProbieUsunieciaWersji();
		 ws.dokonajDecyzjiTak();
		 ws.sprawdzKomunikatPoUsunieciuWersji();
		 
		 
		 
		 
	 }	 
	/*@After
	public void closeBrowser() {
		driver.quit();
	}*/

}
