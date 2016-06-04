package pages.otherpages.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PageUtils;

public class TestsAddingDetails {
	
	public TestsAddingDetails(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	By viewTitle = By.xpath("//h1[@class='content_title']");
	By nameField = By.id("name");
	By descriptionField = By.id("description");
	By resultField = By.id("result");
	By saveButton = By.id("add");
	
	public void getTitlelView(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewTitle));
	}
	
	public void fillNameField(String name){
		PageUtils.sendKey(driver, nameField, "nazwa", name);
	}
	public void fillDescriptionField(String description){
		PageUtils.sendKey(driver, descriptionField, "opis", description);
		PageUtils.click(driver, viewTitle, "tytu³ widoku");
	}
	public void fillResultField(String result){
		PageUtils.sendKey(driver, resultField, "rezultat oczekiwany", result);
		PageUtils.click(driver, viewTitle, "tytu³ widoku");
	}
	
	public void clickSaveButton(){
		PageUtils.click(driver, saveButton, "zapisz");
	}
	
	public void saveTest(String name,String description,String result){
		this.fillNameField(name);
		this.fillDescriptionField(description);
		this.fillResultField(result);
		this.clickSaveButton();
	}

}
