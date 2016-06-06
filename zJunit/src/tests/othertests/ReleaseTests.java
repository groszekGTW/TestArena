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
import pages.otherpages.phases.AddPhasesPage;
import pages.otherpages.release.AddReleasePage;
import pages.otherpages.release.CloneReleasePage;
import pages.otherpages.release.DeleteReleasePage;
import pages.otherpages.release.EditReleasePage;

public class ReleaseTests {

		protected WebDriver driver;

		
		@Before	
		public void setup(){	 
			driver = new FirefoxDriver();	  	 
		    driver.get("http://testarena.gpe.pl");
		}
		@Test
		public void testAddEditCloneDeleteReleaseAndAddPhases() throws InterruptedException{
			
			LoginPage loginpage = new LoginPage(driver);
			MenuLeft menuleft = new MenuLeft (driver);
			AddReleasePage addreleasePage = new AddReleasePage (driver);
			EditReleasePage	editreleasePage = new EditReleasePage (driver);
			CloneReleasePage clonereleasePage = new CloneReleasePage (driver);
			DeleteReleasePage deletereleasePage = new DeleteReleasePage (driver);
			AddPhasesPage addphasesPage = new AddPhasesPage (driver);
			MenuTop menutop = new MenuTop(driver);

			loginpage.loginAs("jagusia.serkowska@gmail.com", "Wsb123"); 
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
			menuleft.clickRelease();
			addreleasePage.clickAddRelease();
			addreleasePage.setName("Wydanie1");
			addreleasePage.setStartDate("2016-06-30");
			addreleasePage.setEndDate("2016-07-30");
			addreleasePage.setDescripton("Opis");
			addreleasePage.clickSave();
		try {
			assertEquals("Wydanie1",driver.findElement(addreleasePage.addReleases).getText());
			System.out.println("Pole z nazw¹ istnieje");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
		String addReleaseMessage = driver.findElement(addreleasePage.addReleaseInfo).getText();
		try {
			assertEquals("Wydanie zosta³o dodane.",addReleaseMessage);
			System.out.println("Komunikat wydanie zosta³o dodane");		 
		}
			 
		catch (Error e) {
			System.out.println(e.toString());
		}
			editreleasePage.clickAction();
			editreleasePage.clickEditRelease();
			editreleasePage.setName("NowaNazwa1");
			editreleasePage.setStartDate("2016-06-30");
			editreleasePage.setEndDate("2016-07-30");
			editreleasePage.setDescription("nowyOpis");
			editreleasePage.clickSave();
		try {
			assertEquals("NowaNazwa1",driver.findElement(editreleasePage.editRelease).getText());
			System.out.println("Edytowane pole z nazw¹ istnieje");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
		String editReleaseMessage = driver.findElement(editreleasePage.editReleaseInfo).getText();
		try {
			assertEquals("Wydanie zosta³o zapisane.",editReleaseMessage);
			System.out.println("Komunikat wydanie zosta³o zapisane");
		}
		catch (Error e){
			System.out.println(e.toString());
		}	 
			clonereleasePage.clickAction();
			clonereleasePage.clickCloneRelease();
			clonereleasePage.setName("NowaNazwa2");
			clonereleasePage.setEndDate("2016-08-30");
			clonereleasePage.selectEnvironment("srodowisko1");
			clonereleasePage.selectVersion("wersja1");
			clonereleasePage.clickSave();
		try {
			assertEquals("NowaNazwa2",driver.findElement(clonereleasePage.cloneRelease).getText());
			System.out.println("Klonowane wydanie istnieje");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
		String cloneReleaseMessage = driver.findElement(clonereleasePage.cloneReleaseInfo).getText();
		try {
			assertEquals("Wydanie zosta³o sklonowane.",cloneReleaseMessage);
			System.out.println("Komunikat wydanie zosta³o sklonowane");
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
			deletereleasePage.clickAction();
			deletereleasePage.clickDeleteRelease();
			deletereleasePage.clickDeletingRelease();
			
		String deletingReleaseMessage= driver.findElement(deletereleasePage.deletingReleaseInfo).getText();
		try {
			assertEquals("Wydanie zosta³o usuniête.",deletingReleaseMessage);
			System.out.println("Komunikat wydanie zosta³o usuniête");	 
		}
		catch (Error e) {
			System.out.println(e.toString());
		}
			addphasesPage.clickActions();
			addphasesPage.clickPhases();
			addphasesPage.clickAddPhases();
			addphasesPage.setName("Faza1");
			addphasesPage.setRelease("NowaNazwa2");
			addphasesPage.clickRelease();
			addphasesPage.setDescription("Opis");
			addphasesPage.clickSave();
			
		String addPhasesMessage = driver.findElement(addphasesPage.addPhasesInfo).getText();
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
