package tests.logintests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.loginpages.LoginPage;
import pages.otherpages.cockpit.MenuTop;

public class LoginPageTestPOM {	
		protected WebDriver driver;
			 
		@Before	
		public void setup(){
			
			driver = new FirefoxDriver();	 
			driver.get("http://testarena.gpe.pl");		        
			}
			 
			 @Test
			 public void loginToTestArena() throws InterruptedException {
				 LoginPage loginpage = new LoginPage(driver);
				 loginpage.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");
				 MenuTop menutop = new MenuTop(driver);
				 menutop.getLogedUserInfo();
				 String Expected=driver.findElement(By.xpath("//span[@class='user-info']/small")).getText();		 
				 Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");
				 
			 }	 
			@After
			public void closeBrowser() {
				driver.quit();
			}
			
}






