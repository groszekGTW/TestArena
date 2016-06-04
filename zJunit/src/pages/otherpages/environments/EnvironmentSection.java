package pages.otherpages.environments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utils.PageUtils;

public class EnvironmentSection {

	public EnvironmentSection(WebDriver driver) {
		this.driver = driver;
	}
	
	WebDriver driver;
	
	private By titleView = By.xpath("//h1[@class='content_title']");
	private By addNewEnvironment = By.xpath("//a[@class='button_link']");
	private By actionIcon = By.xpath("//a[@id='action_icon']");
	private By editButton = By.xpath("//a[contains(.,'Edytuj')]");
	private By infoBox = By.xpath("//div[@id='j_info_box']/p");
	private By removeButton = By.xpath("//a[contains(.,'Usuñ')]");
	private By acceptRemove = By.xpath("//button[contains(.,'Tak')]");
	
	public void getInfoBox(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
	}
	
	public By getViewTitle(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleView));
		return titleView;
	}
	
	public void addNewEnvironment(){
		PageUtils.click(driver, addNewEnvironment, "dodaj zadanie");
	}
	
	public void editIconAction(){
		PageUtils.click(driver, actionIcon, "actionIcon");	
	}

	public void editButton(){
		PageUtils.click(driver, editButton, "editButton");
	}
	
	public void removeButton(){
		PageUtils.click(driver, removeButton, "removeButton");
	}
	
	public void acceptRemove(){
		PageUtils.click(driver, acceptRemove, "acceptRemove");
	}
}
