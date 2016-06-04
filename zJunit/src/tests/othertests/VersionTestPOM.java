package tests.othertests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import pages.loginpages.LoginPage;
import pages.otherpages.cockpit.MenuLeft;
import pages.otherpages.cockpit.MenuTop;
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
		 MenuTop menutop = new MenuTop(driver);
		 menutop.getLogedUserInfo();
		 String Expected=driver.findElement(By.xpath("//span[@class='user-info']/small")).getText();		 
		 Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");

		 MenuLeft menuleft = new MenuLeft(driver);
		 menuleft.openMenuVersion();
		 
		 VersionSection versionsection =  new VersionSection(driver);
		 versionsection.getTitlelView();
		 String Expected1 = driver.findElement(By.xpath("//h1[@class='content_title']")).getText();
		 Assert.assertEquals(Expected1, "Wersje");
		 versionsection.addNewVersion();
		 
		 VersionAddingDetails versionaddingdetails = new VersionAddingDetails(driver);
		 versionaddingdetails.zapiszNowaWersje("wersja4");
		 
		 versionsection.getInfoBoxAfterSave();
		 String Expected2 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected2, "Wersja zosta³a dodana.");

		 versionsection.searchForResult("wersja4");
		 versionsection.actionEdit();
		 
		 versionaddingdetails.zapiszNowaWersje("wersja4.1");
		 
		 versionsection.getInfoBoxAfterEdit();
		 String Expected3 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected3, "Wersja zosta³a zapisana.");

		 versionsection.searchForResult("wersja4.1");
		 versionsection.actionDelete();
		 versionsection.getInfoBoxAfterTryToDelete();
		 String Expected4 = driver.findElement(By.xpath("//div[@id='j_popup_delete_version']/p")).getText();
		 Assert.assertEquals(Expected4, "Czy na pewno chcesz usun¹æ t¹ wersjê?");

		 versionsection.choseYes();
		 versionsection.getInfoBoxAfterDelete();
		 String Expected5 = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		 Assert.assertEquals(Expected5, "Wersja zosta³a usuniêta.");
	}
	 
	 @After
	public void closeBrowser() {
		driver.quit();
	}

}
