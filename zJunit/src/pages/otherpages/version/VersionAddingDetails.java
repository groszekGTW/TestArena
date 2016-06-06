package pages.otherpages.version;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;

public class VersionAddingDetails {
	public VersionAddingDetails(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
	private By nameField = By.xpath("//input[@id='name']");
	private By saveButton = By.xpath("//input[@id='save']");
	private By viewTitle = By.xpath("//h1[@class='content_title']");

	
	public By getViewTitle(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewTitle));
		return (viewTitle);
	}
	
	public void addName(String name){
		PageUtils.sendKey(driver, nameField, "tytu³", name);
	}
	
	public void saveVersion(){
		PageUtils.click(driver, saveButton, "zapisz");
	}
	
	public void saveNewWersion(String nazwa){
		this.addName(nazwa);
		this.saveVersion();
		
	}

}
