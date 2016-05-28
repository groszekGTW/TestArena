package kokpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuLewe {
	
	protected WebDriver driver;

	public MenuLewe(WebDriver driver) {
		this.driver = driver;
	}
	
	By Zadania = By.xpath("//a[@href='http://testarena.gpe.pl/tasks']");
	By Srodowisko = By.xpath("//a[@href='http://testarena.gpe.pl/environments']");


	public void otworzMenuSrodowisko(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Srodowisko));
		driver.findElement(Srodowisko).isEnabled();
		System.out.println("Sekcja Srodowisko lewego panelu nawigacji jest dost�pna");
		driver.findElement(Srodowisko).click();	
	}
	
	public void otworzMenuZadania(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Zadania));
		driver.findElement(Zadania).isEnabled();
		System.out.println("Sekcja zadania lewego panelu nawigacji jest dost�pna");
		driver.findElement(Zadania).click();
	}
	

	

	

}
