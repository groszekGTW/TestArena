package Zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			WebElement element = driver.findElement(StatusRozwiazaniaLista); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(status);
		}
		
		public void zamknijZadanie(String status, String komentarz){
			this.WybierzStatusRozwiazania(status);
			driver.findElement(komentarzPole).sendKeys(komentarz);
			driver.findElement(zamknij).click();
			
		}
}
