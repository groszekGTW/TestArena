package pages.loginpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageUtils;

public class LogowanieUzytkownika {

	public LogowanieUzytkownika(WebDriver driver) {
		this.driver = driver;

	}

	WebDriver driver;

	private By userName = By.id("email");
	private By password = By.id("password");
	private By btnLogIn = By.id("login");

	
	public void setUsername(String email) {
		PageUtils.sendKey(driver, userName, "Adres E-mail", email);
	}

	public void setPassword(String Password) {
		PageUtils.sendKey(driver, password, "has³o", Password);
	}

	public void clickLogIn()  {
		PageUtils.click(driver, btnLogIn, "przycisk login");
	}
	

	public void loginAs(String email, String Password) {
		this.setUsername(email);
		this.setPassword(Password);
		this.clickLogIn();

	}
}
