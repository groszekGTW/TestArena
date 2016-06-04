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

	public void openMenuEnvirionment(){		
		PageUtils.click(driver, envirionment, "Srodowisko lewego panelu nawigacji");
	}
	
	public void openMenuTasks(){		
		PageUtils.click(driver, tasks, "zadania lewego panelu nawigacji");
	}
	public void openMenuVersion(){	
		PageUtils.click(driver, version, "wersje lewego panelu nawigacji");
	}

}
