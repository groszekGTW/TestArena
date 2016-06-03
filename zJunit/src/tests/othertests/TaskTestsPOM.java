package tests.othertests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.loginpages.LogowanieUzytkownika;
import pages.otherpages.cockpit.MenuTop;
import pages.otherpages.tasks.TasksSection;
import pages.otherpages.tasks.TaskDetails;
import pages.otherpages.tasks.TaskAddingDetails;
import pages.otherpages.tasks.TaskClosing;
import pages.otherpages.cockpit.MenuLeft;

public class TaskTestsPOM {
	protected WebDriver driver;

	 
	@Before	
	public void setup(){
	     driver = new FirefoxDriver();	 
	     driver.get("http://testarena.gpe.pl");
	        
	 }
	 
	 @Test
	 public void ClosingNewTask() throws InterruptedException {
		 
		 LogowanieUzytkownika LoogowanieUzytkownika = new LogowanieUzytkownika(driver);
		 LoogowanieUzytkownika.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");

		 MenuTop menutop = new MenuTop(driver);
		 menutop.asercjaZalogowanyUzytkownik();
				 	 		 
		 MenuLeft menuleft = new MenuLeft(driver);
		 menuleft.otworzMenuZadania();
			 
		 TasksSection taskssection = new TasksSection(driver);
		 taskssection.asercjaZadania();
		 taskssection.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 taskssection.dodajNoweZadanie();
		 
		 TaskAddingDetails taskaddingdetails = new TaskAddingDetails(driver);
		 taskaddingdetails.asercjatytulWidoku();
		 taskaddingdetails.dodajNoweZadanie("Nowe srodowisko", "wyd1", "nowa wersja", "Krytyczny", "2018-08-23 23:59", "Mi", "tytul1", "opis opis opis");
		 
		 TaskDetails taskdetails = new TaskDetails(driver);
		 taskdetails.getInfoBoxtext();
		 String Expected=driver.findElement(By.id("j_info_box")).getText();
		 Assert.assertEquals(Expected, "Zadanie zosta³o dodane.");

		 menuleft.otworzMenuZadania();
		 
		 taskssection.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 taskssection.akcjeZamknij();
		 
		 TaskClosing taskclosing = new TaskClosing(driver);
		 taskclosing.zamykanieZadania("Powodzenie", "komentarz");
		 taskssection.getInfoBoxtext();
		 String Expected1=driver.findElement(By.id("j_info_box")).getText();
		 Assert.assertEquals(Expected1, "Zadanie zosta³o zamkniête.");
		 
		 taskssection.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");

	
	 }
	 
	

}
