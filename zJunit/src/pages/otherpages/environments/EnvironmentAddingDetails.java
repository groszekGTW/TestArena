package pages.otherpages.environments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;


public class EnvironmentAddingDetails {

	public EnvironmentAddingDetails(WebDriver driver){
		this.driver = driver;		
	}
	
	WebDriver driver;
	WebDriverWait WebDriverWait;
	WebElement Webelement;
		
	private By environmentName = By.xpath("//input[@id='name']");;
	private By environmentDescription = By.xpath("//textarea[@id='description']");
	private By save = By.xpath("//input[@id='save']");
	
	public void addEnviromentName(String name){
		PageUtils.sendKey(driver, environmentName, "name", name);
	}
	
	public void addDescription(String description){
		PageUtils.sendKey(driver, environmentDescription, "description", description);
	}

	public void SaveEnvironment(){
	PageUtils.click(driver, save, "save");	
	
	}
	public void addNewEnvirnoment(String name,String description) throws InterruptedException{
		this.addDescription(description);
		this.addEnviromentName(name);
	}
	
}
