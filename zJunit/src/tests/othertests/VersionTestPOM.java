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
import pages.otherpages.version.VersionSection;
import pages.otherpages.version.VersionAddingDetails;

public class VersionTestPOM {
	
	protected WebDriver driver;
	LoginPage lgp;
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
		 LoginPage loginpage = new LoginPage(driver);
		 loginpage.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");	
		 
		 MenuLeft menuleft = new MenuLeft(driver);
		 menuleft.otworzMenuWersje();
		 
		 VersionSection versionsection =  new VersionSection(driver);
		 versionsection.getTitlelView();
		 String Expected = driver.findElement(By.xpath("//h1[@class='content_title']")).getText();
		 Assert.assertEquals(Expected, "Wersje");
		 versionsection.addNewVersion();
		 
		 VersionAddingDetails versionaddingdetails = new VersionAddingDetails(driver);
		 versionaddingdetails.zapiszNowaWersje("wersja4");
		 
		 versionsection.getInfoBoxAfterSave();
		 String Expected1 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected1, "Wersja zosta³a dodana.");

		 versionsection.searchForResult("wersja4");
		 versionsection.actionEdit();
		 
		 versionaddingdetails.zapiszNowaWersje("wersja4.1");
		 
		 versionsection.getInfoBoxAfterEdit();
		 String Expected2 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected2, "Wersja zosta³a zapisana.");

		 versionsection.searchForResult("wersja4.1");
		 versionsection.actionDelete();
		 versionsection.getInfoBoxAfterTryToDelete();
		 String Expected3 = driver.findElement(By.xpath("//div[@id='j_popup_delete_version']/p")).getText();
		 Assert.assertEquals(Expected3, "Czy na pewno chcesz usun¹æ t¹ wersjê?");

		 versionsection.choseYes();
		 versionsection.getInfoBoxAfterDelete();
		 String Expected4 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected4, "Wersja zosta³a usuniêta.");

		 
		 
		 
		 
	 }	 
	/*@After
	public void closeBrowser() {
		driver.quit();
	}*/

}
