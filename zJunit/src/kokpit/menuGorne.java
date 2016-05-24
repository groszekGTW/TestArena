package kokpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class menuGorne {
	
	protected WebDriver driver;

	public menuGorne(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	By TestArena_Profil = By.className("top_avatar_header");
	By user_info = By.className("user_info");
	By MsgButton = By.xpath("//a[@class='top_messages']");
	
	
	
	
	
	public void massage (){
		driver.findElement(MsgButton).isEnabled();
		System.out.println("Przycisk Msg jest dostêpne");
		driver.findElement(MsgButton).click();
	}
	



	
	
	

	

}
