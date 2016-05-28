package kokpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class MenuGorne {
	
	protected WebDriver driver;

	public MenuGorne(WebDriver driver) {
		this.driver = driver;
	}
	
	private By user_info = By.xpath("//span[@class='user-info']/small");
	private By przyciskWiadomosci = By.xpath("//a[@class='top_messages']");

	
	public void massage (){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(przyciskWiadomosci));
		driver.findElement(przyciskWiadomosci).isEnabled();
		System.out.println("Przycisk wiadomosci jest dostêpne");
		driver.findElement(przyciskWiadomosci).click();
	}
	
	public By informacjeOzalogwanymUzytkowniku(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(user_info));
		driver.findElement(user_info).isEnabled();
		System.out.println("Pole informacji u¿ytkownika jest dostêpne");
		return user_info;
	}
	
	public void asercjaZalogowanyUzytkownik(){
		String Expected=driver.findElement(informacjeOzalogwanymUzytkowniku()).getText();		 
		Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");
	}



	
	
	

	

}
