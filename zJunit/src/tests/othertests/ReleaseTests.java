package tests.othertests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.loginpages.LoginPage;
import pages.otherpages.cockpit.MenuLeft;
import pages.otherpages.cockpit.MenuTop;
import pages.otherpages.phases.PhasesDetailsPage;
import pages.otherpages.release.ReleaseCloneDetailsPage;
import pages.otherpages.release.ReleaseDetailsPage;
import pages.otherpages.release.ReleaseSectionPage;


public class ReleaseTests {
	protected WebDriver driver;

	@Before	
	public void setup(){	 
		driver = new FirefoxDriver();	  	 
	    driver.get("http://testarena.gpe.pl");
	}
	@Test
	public void testAddEditCloneDeleteReleaseAndAddPhases() throws InterruptedException{
			
		LoginPage loginPage = new LoginPage(driver);
		MenuLeft menuLeft = new MenuLeft(driver);
		MenuTop menutop = new MenuTop(driver);
		ReleaseCloneDetailsPage releaseClone = new ReleaseCloneDetailsPage (driver);
		ReleaseDetailsPage releaseDetails = new ReleaseDetailsPage (driver);
		ReleaseSectionPage releaseSection = new ReleaseSectionPage (driver);
		PhasesDetailsPage phasesDetails = new PhasesDetailsPage (driver);
			
			loginPage.loginAs("jagusia.serkowska@gmail.com", "Wsb123"); 
		try {
			assertEquals("Agnieszka",driver.findElement(menutop.userInf).getText().substring(0, 9));
			System.out.println("W polu z imieniem i nazwiskiem imie ma 9 znakow");
		} 
		catch (Error e) {
			System.out.println(e.toString());
		}
		try {
			assertNotNull(driver.findElement(menutop.userInf));
			System.out.println("Pole z imieniem i nazwiskiem istnieje");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
			menuLeft.clickRelease();
			releaseSection.clickAddRelease();
			releaseDetails.releaseDetail("Wydanie1", "2016-06-30", "2016-07-30", "Opis");
		try {
			assertEquals("Wydanie1",driver.findElement(releaseSection.addReleases).getText());
			System.out.println("Pole z nazw¹ istnieje");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
		String addReleaseMessage = driver.findElement(releaseSection.addReleaseInfo).getText();
		try {
			assertEquals("Wydanie zosta³o dodane.",addReleaseMessage);
			System.out.println("Komunikat wydanie zosta³o dodane");		 
		}
			 
		catch (Error e) {
			System.out.println(e.toString());
		}
			releaseSection.releaseClickEdit();
			releaseDetails.releaseDetail("NowaNazwa1", "2016-07-30", "2016-08-30", "NowyOpis");
		try {
			assertEquals("NowaNazwa1",driver.findElement(releaseSection.editRelease).getText());
			System.out.println("Edytowane pole z nazw¹ istnieje");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
		String editReleaseMessage = driver.findElement(releaseSection.editReleaseInfo).getText();
		try {
			assertEquals("Wydanie zosta³o zapisane.",editReleaseMessage);
			System.out.println("Komunikat wydanie zosta³o zapisane");
		}
		catch (Error e){
			System.out.println(e.toString());
		}	 
			releaseSection.releaseClickClone();
			releaseClone.releaseClone("NowaNazwa2", "2016-09-30", "srodowisko1", "wersja1");
		try {
			assertEquals("NowaNazwa2",driver.findElement(releaseSection.cloneRelease).getText());
			System.out.println("Klonowane wydanie istnieje");
	}
	catch (Error e) {
		System.out.println(e.toString());
	}
	String cloneReleaseMessage = driver.findElement(releaseSection.cloneReleaseInfo).getText();
	try {
		assertEquals("Wydanie zosta³o sklonowane.",cloneReleaseMessage);
		System.out.println("Komunikat wydanie zosta³o sklonowane");
	}
	catch (Error e) {
		System.out.println(e.toString());
	}
		releaseSection.releaseDelete();
			
	String deletingReleaseMessage= driver.findElement(releaseSection.deletingReleaseInfo).getText();
	try {
		assertEquals("Wydanie zosta³o usuniête.",deletingReleaseMessage);
		System.out.println("Komunikat wydanie zosta³o usuniête");	 
	}
	catch (Error e) {
		System.out.println(e.toString());
	}
		releaseSection.releaseClickPhases();
		phasesDetails.releasePhases("Faza1", "NowaNazwa2", "Opis");
			
	String addPhasesMessage = driver.findElement(releaseSection.addPhasesInfo).getText();
	try {
		assertEquals("Faza zosta³a dodana.",addPhasesMessage);
		System.out.println("Komunikat faza zosta³a dodana");
		}
	catch (Error e) {
		System.out.println(e.toString()); 
	}
} 
	@After
	public void closeBrowser(){
		driver.quit();
	}
}


