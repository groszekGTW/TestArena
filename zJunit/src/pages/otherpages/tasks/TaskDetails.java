package pages.otherpages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TaskDetails {
	
	public TaskDetails(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		
		private By komunikat = By.id("j_info_box");

		
		public void getInfoBoxtext(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
		}

}
