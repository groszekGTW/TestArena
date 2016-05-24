package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageSection {
	protected WebDriver driver;
	
	public PageSection(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
