package kokpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class menuLewe {
	
	protected WebDriver driver;

	public menuLewe(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	By Zadania = By.xpath("//a[@href='http://testarena.gpe.pl/tasks']");
	
	public void getZadania(){
		driver.findElement(Zadania).isEnabled();
		System.out.println("sekcja zadania lewego panelu nawigacji jest dostêpna");
		driver.findElement(Zadania).click();
		}
	

	

	

}
