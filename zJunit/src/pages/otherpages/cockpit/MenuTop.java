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
	
	private By user_info = By.xpath("//span[@class='user-info']/small");
	private By massageButton = By.xpath("//a[@class='top_messages']");

	public void massage (){
		PageUtils.click(driver, massageButton, "Przycisk wiadomosci");
	}
	
	public void getLogedUserInfo(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(user_info));
	}

}
