package tests.othertests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.loginpages.LoginPage;
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
		 
		 LoginPage LoogowanieUzytkownika = new LoginPage(driver);
		 LoogowanieUzytkownika.loginAs("groszkowskimichal@gmail.com", "Gro3chu!");

		 WebElement userInfo = driver.findElement(By.xpath("//span[@class='user-info']/small"));
		 String Expected= userInfo.getText();		 
		 Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");
				 	 		 
		 MenuLeft menuleft = new MenuLeft(driver);
		 menuleft.otworzMenuZadania();
			 
		 TasksSection taskssection = new TasksSection(driver);
		 		 
		 WebElement viewTitle = driver.findElement(By.xpath("//h1[@class='content_title']"));
		 String Expected1 = viewTitle.getText();		 
		 Assert.assertEquals(Expected1, "Zadania");
		 
		 taskssection.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 taskssection.addNewTask();
		 
		 TaskAddingDetails taskaddingdetails = new TaskAddingDetails(driver);
		
		 String Expected2=driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		 Assert.assertEquals(Expected2, "Dodaj zadanie");
		 
		 taskaddingdetails.asercjatytulWidoku();
		 
		 taskaddingdetails.dodajNoweZadanie("Nowe srodowisko", "wyd1", "nowa wersja", "Krytyczny", "2018-08-23 23:59", "Mi", "tytul1", "opis opis opis");
		 
		 TaskDetails taskdetails = new TaskDetails(driver);
		 taskdetails.getInfoBox();
		 String Expected3  = driver.findElement(By.id("j_info_box")).getText();
		 Assert.assertEquals(Expected3, "Zadanie zosta³o dodane.");

		 menuleft.otworzMenuZadania();
		 
		 taskssection.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");
		 taskssection.actionClose();
		 
		 TaskClosing taskclosing = new TaskClosing(driver);
		 taskclosing.zamykanieZadania("Powodzenie", "komentarz");
		 taskssection.getInfoBox();
		 String Expected4 = driver.findElement(By.id("j_info_box")).getText();
		 Assert.assertEquals(Expected4, "Zadanie zosta³o zamkniête.");
		 
		 taskssection.filtrowaniePrzezFiltry("Nowe", "Krytyczny", "Micha³ Groszkowski", "Micha³ Groszkowski", "Nowe srodowisko", "10");

	
	 }
	 
	

}
