package tests.othertests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.loginpages.LogowanieUzytkownika;
import pages.otherpages.cockpit.MenuLeft;
import pages.otherpages.version.VersionSection;
import pages.otherpages.version.VersionAddingDetails;

public class VersionTestPOM {
	
	protected WebDriver driver;
	LogowanieUzytkownika lgp;
	MenuLeft ml;
	VersionSection ws;
	VersionAddingDetails wsn;
	 
	@Before	
	public void setup(){
	     driver = new FirefoxDriver();	 
	     driver.get("http://testarena.gpe.pl");		        
	 }
	 
	 @Test
	 public void test123() throws InterruptedException {
		 lgp = new LogowanieUzytkownika(driver);
		 lgp.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");	
		 
		 ml = new MenuLeft(driver);
		 ml.otworzMenuWersje();
		 
		 ws =  new VersionSection(driver);
		 ws.asercjaWersje();
		 ws.dodajNowaWersje();
		 
		 wsn = new VersionAddingDetails(driver);
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
