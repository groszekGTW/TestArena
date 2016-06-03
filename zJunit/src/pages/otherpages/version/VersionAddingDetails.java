package pages.otherpages.version;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VersionAddingDetails {
	public VersionAddingDetails(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
	private By nazwaPole = By.xpath("//input[@id='name']");
	private By zapisz = By.xpath("//input[@id='save']");
	private By tytulWidoku = By.xpath("//h1[@class='content_title']");

	
	public By getTytulWidoku(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tytulWidoku));
		return (tytulWidoku);
	}
	
	public void dodajNazwe(String nazwa){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nazwaPole));
		driver.findElement(nazwaPole).isEnabled();
		System.out.println("Pole tytu³ jest dostêpne");
		driver.findElement(nazwaPole).clear();
		driver.findElement(nazwaPole).sendKeys(nazwa);
	}
	
	public void zapiszWersje(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(zapisz));
		driver.findElement(zapisz).isEnabled();
		System.out.println("Pole zapisz jest dostêpne");
		driver.findElement(zapisz).click();
	}
	
	public void asercjaWersje(){
		String Expected=driver.findElement(getTytulWidoku()).getText();		 
		Assert.assertEquals(Expected, "Wersje");
	}
	
	public void zapiszNowaWersje(String nazwa){
		this.dodajNazwe(nazwa);
		this.zapiszWersje();
		
	}

}
