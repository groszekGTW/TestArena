package Zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZamykanieZadania {
	
	public ZamykanieZadania(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
		By srodowiska = By.id("token-input-environments");
		By wersje = By.id("token-input-versions");
		By StatusRozwiazaniaLista = By.id("resolutionId");
		By zamknij = By.xpath("//input[@id='close']");
		By anuluj =  By.xpath("//a[contains(.,'Anuluj')]");
		By komentarzPole = By.xpath("//textarea[@id='comment']");
		
		
		public void WybierzStatusRozwiazania(String status){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(StatusRozwiazaniaLista));
			driver.findElement(StatusRozwiazaniaLista).isEnabled();
			System.out.println("Pole Status rozwiazania jest dostêpne");
			WebElement element = driver.findElement(StatusRozwiazaniaLista); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(status);
		}
		
		public void dodajKomentarz(String komentarz){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komentarzPole));
			driver.findElement(komentarzPole).isEnabled();
			System.out.println("Pole komentarz jest dostêpne");
			driver.findElement(komentarzPole).sendKeys(komentarz);
		}
		
		public void zamknijZadanie(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(zamknij));
			driver.findElement(zamknij).isEnabled();
			System.out.println("Pole zamknij jest dostêpne");
			driver.findElement(zamknij).click();
		}


		public void zamykanieZadania(String status, String komentarz){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komentarzPole));
			this.WybierzStatusRozwiazania(status);
			this.dodajKomentarz(komentarz);
			this.zamknijZadanie();
			
		}
}
