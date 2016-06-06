package pages.otherpages.cockpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;


public class MenuTop {
	
	protected WebDriver driver;

	public MenuTop(WebDriver driver) {
		this.driver = driver;
	}
	
	private By userInfo = By.xpath("//span[@class='user-info']/small");
	public  By userInf = By.xpath("//span[contains(@class,'user-info')]");

	private By massageButton = By.xpath("//a[@class='top_messages']");

	public void massage (){
		PageUtils.click(driver, massageButton, "Przycisk wiadomosci");
	}
	
	public void getLogedUserInfo(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userInfo));
	}

}
