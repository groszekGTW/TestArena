package tests.logintests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.loginpages.LogowanieUzytkownika;

public class LogowanieTestPOM {	
		
			protected WebDriver driver;
			LogowanieUzytkownika lgp;	
			 
			@Before	
			public void setup(){
			     driver = new FirefoxDriver();	 
			     driver.get("http://testarena.gpe.pl");		        
			 }
			 
			 @Test
			 public void test123() throws InterruptedException {
				 lgp = new LogowanieUzytkownika(driver);
				 lgp.loginToArena("groszkowskimichal@gmail.com", "Gro3chu!");	
			 }	 
			@After
			public void closeBrowser() {
				driver.quit();
			}
			
}






