package LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.PageSection;

public class Logpa extends PageSection{
public Logpa(WebDriver driver) {
		super(driver);
	}
WebDriver driver;
		
	@FindBy(id="email")
	private WebElement Username;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(id="login")
	private WebElement LogIn;
	
	
	
	public void LogInToTestArena (String username, String password){
		Username.sendKeys(username);	
		Password.sendKeys(password);		
		LogIn.click();
	}

		
}
	
         



