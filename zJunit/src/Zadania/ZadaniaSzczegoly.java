package Zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ZadaniaSzczegoly {
	
	public ZadaniaSzczegoly(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		
		private By komunikat = By.id("j_info_box");

		
		public void sprawdzKomunikatPoDodaniuZadania(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
			String Expected=driver.findElement(komunikat).getText();
			Assert.assertEquals(Expected, "Zadanie zosta³o dodane.");
		}

}
