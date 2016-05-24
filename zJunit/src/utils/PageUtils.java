package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
	
	public static void waitForVisible(WebDriver driver, WebElement element) {
		(new WebDriverWait(driver, 200)).until(ExpectedConditions.visibilityOf(element));
	}

}
