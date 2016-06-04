package tests.othertests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import pages.loginpages.LoginPage;
import pages.otherpages.cockpit.MenuLeft;
import pages.otherpages.tests.TestsAddingDetails;
import pages.otherpages.tests.TestsSection;

public class TestsTestPOM {
	protected WebDriver driver;
	 
	@Before	
	public void setup(){
	     driver = new FirefoxDriver();	 
	     driver.get("http://testarena.gpe.pl");      
	 }
	 
	 @Test
	 public void ClosingNewTask() throws InterruptedException {
		 LoginPage LoogowanieUzytkownika = new LoginPage(driver);
		 LoogowanieUzytkownika.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");

		 WebElement userInfo = driver.findElement(By.xpath("//span[@class='user-info']/small"));
		 String Expected= userInfo.getText();		 
		 Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");
				 	 		 
		 MenuLeft menuleft = new MenuLeft(driver);
		 menuleft.openMenuTests();
		 
		 TestsSection testssection = new TestsSection(driver);
		 testssection.getTitlelView();
		 String Expected1= driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		 Assert.assertEquals(Expected1, "Baza testów");
		 testssection.addNewTestCase();
		 
		 TestsAddingDetails testsaddingdetails = new TestsAddingDetails(driver);
		 testsaddingdetails.getTitlelView();
		 String Expected2= driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		 Assert.assertEquals(Expected2, "Dodaj przypadek testowy");
		 testsaddingdetails.saveTest("name", "description", "result");
		 
		 testssection.getInfoBoxAfterSave();
		 String Expected3= driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();		 
		 Assert.assertEquals(Expected3, "Przypadek testowy zosta³ dodany.");
		 testssection.searchForResult("name");
		 testssection.actionEdit();
		 
		 testsaddingdetails.getTitlelView();
		 String Expected4= driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		 Assert.assertEquals(Expected4, "Edytuj przypadek testowy");
		 testsaddingdetails.saveTest("name", "description", "result");
		 
		 testssection.getInfoBoxAfterSave();
		 String Expected5= driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();		 
		 Assert.assertEquals(Expected5, "Przypadek testowy zosta³ wyedytowany.");
		 testssection.actionDelete();
		 testssection.getInfoBoxAfterTryToDelete();
		 testssection.choseYes();
		 testssection.getInfoBoxAfterDelete();
		 String Expected6 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected6, "Test zosta³ usuniêty z bazy.");	
	 }
	 @After
		public void closeBrowser() {
			driver.quit();
		}


}
