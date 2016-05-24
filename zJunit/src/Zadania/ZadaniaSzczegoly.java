package Zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ZadaniaSzczegoly {
	
		public ZadaniaSzczegoly(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
		By tytulWidoku = By.xpath("//h1[@class='content_title']");
		By tytulPole = By.id("title");
		By opisPole = By.id("description");
		By wydaniePole = By.id("releaseName");
		By fazaPole = By.id("phaseName");
		By srodowiska = By.id("token-input-environments");
		By wersje = By.id("token-input-versions");
		By priorytetLista = By.id("priority");
		By terminRealizacjiPole = By.id("dueDate");
		By przypiszDo = By.id("assigneeName");
		By przypiszDoKtos = By.xpath("//li[@class='ui-menu-item']");
		//By.id("ui-id-8");
		By zapisz = By.id("save");
		
		/*By terminRealizacjiMiesiac = By.xpath("//select[@class='ui-datepicker-month']");
		By terminRealizacjiRok = By.xpath("//select[@class='ui-datepicker-year']"); 
		*/
		
		public void dodajTytul(String tytul){
			driver.findElement(tytulPole).sendKeys(tytul);
		}
		
		public void dodajsrodowisko(String srodowisko) throws InterruptedException{			
			driver.findElement(srodowiska).sendKeys(srodowisko);
			Thread.sleep(2000);
			driver.findElement(srodowiska).sendKeys(Keys.ENTER);			
		}
		
		public void dodajWersje(String wersja) throws InterruptedException{			
			driver.findElement(wersje).sendKeys(wersja);
			Thread.sleep(2000);
			driver.findElement(wersje).sendKeys(Keys.ENTER);			
		}
		
		public void WybierzPriorytet(String priorytet){
			WebElement element = driver.findElement(priorytetLista); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(priorytet);
		}
		
		public void WybierzTerminrealizacji(String data){
			driver.findElement(terminRealizacjiPole).sendKeys(data);
			driver.findElement(terminRealizacjiPole).sendKeys(Keys.ENTER);
		}
		
		public void prypiszDoKogos(String ktos) throws InterruptedException{
			driver.findElement(przypiszDo).sendKeys(ktos);
			Thread.sleep(2000);
			driver.findElement(przypiszDoKtos).click();
			driver.findElement(tytulWidoku).click();
		}
		
		public void dodajOpis(String opis) throws InterruptedException{
			driver.findElement(opisPole).sendKeys(opis);			
			driver.findElement(tytulWidoku).click();
		}
		 public void zapiszZmiany(){
			 driver.findElement(zapisz).click();
		 }
		public void dodajsrodowisk(String Key) {			
			driver.findElement(srodowiska).sendKeys(Key);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tester[contains(text(), 'Nowe srodowisko')]")));
			//wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("token-input-environments"), "Nowe srodowisko"));
			wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.id("token-input-environments")), Key));		
			driver.findElement(srodowiska).sendKeys(Keys.ENTER);			
		}

}
