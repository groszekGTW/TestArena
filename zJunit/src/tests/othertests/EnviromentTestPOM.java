package tests.othertests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import pages.loginpages.LoginPage;
import pages.otherpages.cockpit.MenuLeft;
import pages.otherpages.environments.EnvironmentAddingDetails;
import pages.otherpages.environments.EnvironmentSection;

public class EnviromentTestPOM {
	
	protected WebDriver driver;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://testarena.gpe.pl");
		
	}
		
	@Test
		public void enviromentTests() throws InterruptedException {
		
		EnvironmentSection enviromentSection = new EnvironmentSection(driver);
		EnvironmentAddingDetails enviromentAdd = new EnvironmentAddingDetails(driver);
		LoginPage LoogowanieUzytkownika = new LoginPage(driver);
		
		LoogowanieUzytkownika.loginAs("grzegorzjasik@wp.pl", "Password12#");
		WebElement userInfo = driver.findElement(By.xpath("//span[@class='user-info']/small"));
		String Expected= userInfo.getText();		 
		Assert.assertEquals(Expected, "grzegorzjasik@wp.pl");
	
		MenuLeft menuleft = new MenuLeft(driver);
		menuleft.openMenuEnvirionment();

		WebElement viewTitle = driver.findElement(By.xpath("//h1[@class='content_title']"));
		String Expected1 = viewTitle.getText();		 
		Assert.assertEquals(Expected1, "�rodowiska");
		enviromentSection.addNewEnvironment();
		enviromentAdd.addEnviromentName("To jest �rodowisko");
		enviromentAdd.addDescription("Tutaj znajduj� si� opis �rodowiska");
		enviromentAdd.SaveEnvironment();
		enviromentSection.getInfoBox();
		String Expected2  = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		Assert.assertEquals(Expected2, "�rodowisko zosta�o dodane.");

		enviromentSection.editIconAction();
		enviromentSection.editButton();
		enviromentAdd.addEnviromentName("To jest zmienione �rodowisko");
		enviromentAdd.addDescription("To jest zmieniony opis �rodowiska");
		enviromentAdd.SaveEnvironment();
		Thread.sleep(2000);
		String Expected3  = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		Assert.assertEquals(Expected3, "�rodowisko zosta�o zapisane.");
		
		enviromentSection.editIconAction();
		enviromentSection.removeButton();
		enviromentSection.acceptRemove();
		Thread.sleep(2000);
		String Expected4  = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		Assert.assertEquals(Expected4, "�rodowisko zosta�o usuni�te.");
		
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
}


