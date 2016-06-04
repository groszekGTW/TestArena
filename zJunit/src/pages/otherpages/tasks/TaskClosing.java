package pages.otherpages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PageUtils;

public class TaskClosing {
	
	public TaskClosing(WebDriver driver) {
		this.driver = driver;
	}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
		By environments = By.id("token-input-environments");
		By versions = By.id("token-input-versions");
		By resolutionId = By.id("resolutionId");
		By closeButton = By.xpath("//input[@id='close']");
		By cancelButton =  By.xpath("//a[contains(.,'Anuluj')]");
		By commentField = By.xpath("//textarea[@id='comment']");
		
		public void selectResolution(String resolution){
			PageUtils.selectFilter(driver, resolutionId, "Status rozwiazania jest", resolution);
		}
		
		public void dodajKomentarz(String comment){		
			PageUtils.sendKey(driver, commentField, "komentarz", comment);
		}
		
		public void zamknijZadanie(){
			PageUtils.click(driver, closeButton, "zamknij");
		}

		public void taskClosing(String resolution, String comment){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(commentField));
			this.selectResolution(resolution);
			this.dodajKomentarz(comment);
			this.zamknijZadanie();
			
		}
}
