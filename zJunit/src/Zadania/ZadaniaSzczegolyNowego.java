package Zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ZadaniaSzczegolyNowego {
	
		public ZadaniaSzczegolyNowego(WebDriver driver) {
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
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(tytulPole));
			driver.findElement(tytulPole).isEnabled();
			System.out.println("Pole tytu³ jest dostêpne");
			driver.findElement(tytulPole).sendKeys(tytul);
		}
		
		public void dodajsrodowisko(String srodowisko) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(srodowiska));
			driver.findElement(srodowiska).isEnabled();
			System.out.println("Pole srodowiska jest dostêpne");
			driver.findElement(srodowiska).sendKeys(srodowisko);
			Thread.sleep(2000);
			driver.findElement(srodowiska).sendKeys(Keys.ENTER);			
		}
		
		public void wybierzWydanie(String wydanie){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(wydaniePole));
			driver.findElement(wydaniePole).isEnabled();
			System.out.println("Pole wydanie jest dostêpne");
			driver.findElement(wydaniePole).sendKeys(wydanie);
		}
		
		
		public void dodajWersje(String wersja) throws InterruptedException{	
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(wersje));
			driver.findElement(wersje).isEnabled();
			System.out.println("Pole wersje jest dostêpne");
			driver.findElement(wersje).sendKeys(wersja);
			Thread.sleep(2000);
			driver.findElement(wersje).sendKeys(Keys.ENTER);			
		}
		
		public void WybierzPriorytet(String priorytet){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(priorytetLista));
			driver.findElement(priorytetLista).isEnabled();
			System.out.println("Pole priorytet jest dostêpne");
			WebElement element = driver.findElement(priorytetLista); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(priorytet);
		}
		
		public void WybierzTerminrealizacji(String data){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(terminRealizacjiPole));
			driver.findElement(terminRealizacjiPole).isEnabled();
			System.out.println("Pole terminRealizacji jest dostêpne");
			driver.findElement(terminRealizacjiPole).sendKeys(data);
			driver.findElement(terminRealizacjiPole).sendKeys(Keys.ENTER);
		}
		
		public void prypiszDoKogos(String ktos) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(przypiszDo));
			driver.findElement(przypiszDo).isEnabled();
			System.out.println("Pole przypisz do jest dostêpne");
			driver.findElement(przypiszDo).sendKeys(ktos);
			wait.until(ExpectedConditions.visibilityOfElementLocated(przypiszDoKtos));
			driver.findElement(przypiszDoKtos).isEnabled();
			System.out.println("Lista osób do przypisania jest dostêpna");
			driver.findElement(przypiszDoKtos).click();
			driver.findElement(tytulWidoku).click();
		}
		
		public void dodajOpis(String opis) throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(opisPole));
			driver.findElement(opisPole).isEnabled();
			System.out.println("Pole opis jest dostêpne");
			driver.findElement(opisPole).sendKeys(opis);		
			wait.until(ExpectedConditions.visibilityOfElementLocated(tytulWidoku));
			driver.findElement(tytulWidoku).click();
		}
		 public void zapiszZmiany(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(zapisz));
			driver.findElement(zapisz).isEnabled();
			System.out.println("Pole zapisz jest dostêpne");
			driver.findElement(zapisz).click();
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
