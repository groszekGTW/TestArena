package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
	
	
	public static void click(WebDriver driver, By byElement, String nazwaPola) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		WebElement webElement = driver.findElement(byElement);
		webElement.isEnabled();
		System.out.println("Pole " + nazwaPola + " jest dostêpne");
		webElement.click();
	}
	
	public static void sendKey(WebDriver driver, By byElement, String textboxName, String key) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		WebElement webElement = driver.findElement(byElement);
		webElement.isEnabled();
		System.out.println("Pole " + textboxName + " jest dostêpne");
		webElement.clear();
		webElement.sendKeys(key);
	}
	
	public static void sendKeyAndEnter(WebDriver driver, By byElement, String textboxName, String key) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		WebElement webElement = driver.findElement(byElement);
		webElement.isEnabled();
		System.out.println("Pole " + textboxName + " jest dostêpne");
		webElement.sendKeys(key);
		Thread.sleep(2000);
		webElement.sendKeys(Keys.ENTER);
	}
	
	public static void selectFilter(WebDriver driver, By byElement, String textboxName, String key){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
		driver.findElement(byElement).isEnabled();
		System.out.println("Pole " + textboxName + " jest dostêpne");
		WebElement element = driver.findElement(byElement); 
		Select dropDown = new Select(element); 
		dropDown.selectByVisibleText(key);
	}
	


}