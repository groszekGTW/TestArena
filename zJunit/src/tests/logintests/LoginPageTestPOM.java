package tests.logintests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.loginpages.LogowanieUzytkownika;

public class LoginPageTestPOM {	
		
			protected WebDriver driver;
			 
			@Before	
			public void setup(){
			     driver = new FirefoxDriver();	 
			     driver.get("http://testarena.gpe.pl");		        
			 }
			 
			 @Test
			 public void poprawneLogowanie() throws InterruptedException {
				 LogowanieUzytkownika LoogowanieUzytkownika = new LogowanieUzytkownika(driver);
				 LoogowanieUzytkownika.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");
				 
			 }	 
			@After
			public void closeBrowser() {
				driver.quit();
			}
			
}






