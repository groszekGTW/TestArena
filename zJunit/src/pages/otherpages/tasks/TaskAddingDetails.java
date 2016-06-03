package pages.otherpages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PageUtils;


public class TaskAddingDetails {
	
		public TaskAddingDetails(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
		private By tytulWidoku = By.xpath("//h1[@class='content_title']");
		private By tytulPole = By.id("title");
		private By opisPole = By.id("description");
		private By wydaniePole = By.id("releaseName");
		private By srodowiska = By.id("token-input-environments");
		private By wersje = By.id("token-input-versions");
		private By priorytetLista = By.id("priority");
		private By terminRealizacjiPole = By.id("dueDate");
		private By przypiszDo = By.id("assigneeName");
		private By przypiszDoKtos = By.xpath("//li[@class='ui-menu-item']");
		private By zapisz = By.id("save");
		
		public void asercjatytulWidoku(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(tytulWidoku));
			String Expected=driver.findElement(tytulWidoku).getText();		 
			Assert.assertEquals(Expected, "Dodaj zadanie");
		}
			
		public void dodajTytul(String tytul){
			PageUtils.sendKey(driver, tytulPole, "tytu³", tytul);
		}
		
		public void dodajsrodowisko(String srodowisko) throws InterruptedException{
			PageUtils.sendKeyAndEnter(driver, srodowiska, "srodowiska", srodowisko);
		}
		
		public void wybierzWydanie(String wydanie){
			PageUtils.sendKey(driver, wydaniePole, "wydanie", wydanie);
		}
		
		
		public void dodajWersje(String wersja) throws InterruptedException{	
			PageUtils.sendKeyAndEnter(driver, wersje, "wersje", wersja);
		}
		
		public void WybierzPriorytet(String priorytet){
			PageUtils.selectFilter(driver, priorytetLista, priorytet, priorytet);
		}
		
		public void WybierzTerminrealizacji(String data) throws InterruptedException{
			PageUtils.sendKeyAndEnter(driver, terminRealizacjiPole, "termin realizacji", data);
		}
		
		public void prypiszDoKogos(String ktos) throws InterruptedException{
			PageUtils.sendKey(driver, przypiszDo, "przypisz do", ktos);
			PageUtils.click(driver, przypiszDoKtos, "Lista osób do przypisania");
			PageUtils.click(driver, tytulWidoku, "tytu³ widoku");
		}
		
		public void dodajOpis(String opis) throws InterruptedException{
			PageUtils.sendKey(driver, opisPole, "opis", opis);
			PageUtils.click(driver, tytulWidoku, "tytu³ widoku");

		}
		 public void zapiszZmiany(){
			PageUtils.click(driver, zapisz, "zapisz");
		}
		
		 public void dodajNoweZadanie(String srodowisko,String wydanie, String wersja,String priorytet,String data,String ktos,String tytul,String opis) throws InterruptedException{
			 this.dodajsrodowisko(srodowisko);
			 this.wybierzWydanie(wydanie);
			 this.dodajWersje(wersja);
			 this.WybierzPriorytet(priorytet);
			 this.WybierzTerminrealizacji(data);
			 this.prypiszDoKogos(ktos);
			 this.dodajTytul(tytul);
			 this.dodajOpis(opis);
			 this.zapiszZmiany();			 
		 }

}
