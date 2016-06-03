package tests.logintests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.loginpages.LoginPage;

public class LoginPageTestPOM {	
		
			protected WebDriver driver;
			 
			@Before	
			public void setup(){
			     driver = new FirefoxDriver();	 
			     driver.get("http://testarena.gpe.pl");		        
			 }
			 
			 @Test
			 public void poprawneLogowanie() throws InterruptedException {
				 LoginPage LoogowanieUzytkownika = new LoginPage(driver);
				 LoogowanieUzytkownika.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");
				 
			 }	 
			@After
			public void closeBrowser() {
				driver.quit();
			}
			
}






