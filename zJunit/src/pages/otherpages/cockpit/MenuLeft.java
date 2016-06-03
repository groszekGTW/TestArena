package pages.otherpages.cockpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuLeft {
	
	protected WebDriver driver;

	public MenuLeft(WebDriver driver) {
		this.driver = driver;
	}
	
	private By Zadania = By.xpath("//a[@href='http://testarena.gpe.pl/tasks']");
	private By Srodowisko = By.xpath("//a[@href='http://testarena.gpe.pl/environments']");
	private By wersje = By.xpath("//a[@href='http://testarena.gpe.pl/versions']");


	public void otworzMenuSrodowisko(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Srodowisko));
		driver.findElement(Srodowisko).isEnabled();
		System.out.println("Sekcja Srodowisko lewego panelu nawigacji jest dostêpna");
		driver.findElement(Srodowisko).click();	
	}
	
	public void otworzMenuZadania(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Zadania));
		driver.findElement(Zadania).isEnabled();
		System.out.println("Sekcja zadania lewego panelu nawigacji jest dostêpna");
		driver.findElement(Zadania).click();
	}
	public void otworzMenuWersje(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wersje));
		driver.findElement(wersje).isEnabled();
		System.out.println("Sekcja Wersje lewego panelu nawigacji jest dostêpna");
		driver.findElement(wersje).click();	
	}

	

	

}
