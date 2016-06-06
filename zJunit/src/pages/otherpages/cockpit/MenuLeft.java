package pages.otherpages.cockpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageUtils;

public class MenuLeft {
	
	protected WebDriver driver;

	public MenuLeft(WebDriver driver) {
		this.driver = driver;
	}
	
	private By tasks = By.xpath("//a[@href='http://testarena.gpe.pl/tasks']");
	private By envirionment = By.xpath("//a[@href='http://testarena.gpe.pl/environments']");
	private By version = By.xpath("//a[@href='http://testarena.gpe.pl/versions']");
	private By tests = By.xpath("//a[@href='http://testarena.gpe.pl/tests']");
	private By btnRelease = By.xpath("//a[@href='http://testarena.gpe.pl/releases']");


	public void openMenuEnvirionment(){		
		PageUtils.click(driver, envirionment, "Srodowisko lewego panelu nawigacji");
	}
	
	public void openMenuTasks(){		
		PageUtils.click(driver, tasks, "zadania lewego panelu nawigacji");
	}
	
	public void openMenuVersion(){	
		PageUtils.click(driver, version, "wersje lewego panelu nawigacji");
	}
	
	public void openMenuTests(){
		PageUtils.click(driver, tests, "baza testów lewego panelu nawigacji");
	}
	
	public void clickRelease(){
		PageUtils.click(driver, btnRelease, "przycisk wydania");
	}

}
