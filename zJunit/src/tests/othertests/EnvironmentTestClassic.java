package tests.othertests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnvironmentTestClassic {
	
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
 
        driver.get("http://testarena.gpe.pl");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement username = driver.findElement(By.id("email"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		username.isEnabled();
		System.out.println("Pole adres e-mail jest dostêpne");
		username.sendKeys("grzegorzjasik@wp.pl");
        
		WebElement Password = driver.findElement(By.id("password"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    Password.isEnabled();
		System.out.println("Pole has³o jest dostêpne");
	    Password.sendKeys("Password12#");
	    
	    WebElement Login = driver.findElement(By.id("login"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    Login.isEnabled();
		System.out.println("Pole zaloguj jest dostêpne");
	    Login.click();
	    
	    String Expected = driver.findElement(By.xpath("//span[@class='user-info']/small")).getText();		 
		Assert.assertEquals(Expected, "grzegorzjasik@wp.pl");
		
	    WebElement openEnvironment = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/environments']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://testarena.gpe.pl/environments']")));
	    openEnvironment.isEnabled();
		System.out.println("Sekcja zadania lewego panelu nawigacji jest dostêpna");
		openEnvironment.click();
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='content_title']")));
	    String Expected1=driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		Assert.assertEquals(Expected1, "Środowiska");
		
		WebElement addEnvironments = driver.findElement(By.xpath("//a[@class='button_link']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button_link']")));
	    addEnvironments.isEnabled();
		addEnvironments.click();
		
		WebElement addEnvironmentsName = driver.findElement(By.xpath("//input[@id='name']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
	    addEnvironmentsName.isEnabled();
	    addEnvironmentsName.sendKeys("Tutaj znajduję się nazwa środowiska");
	    
	    WebElement addDescription = driver.findElement(By.xpath("//textarea[@id='description']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
	    addDescription.isEnabled();
	    addDescription.sendKeys("Tutaj znajduję się przykładowy opis środowiska");
	    
	    Thread.sleep(500);
	    
	    WebElement saveEnvironments = driver.findElement(By.xpath("//input[@id='save']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='save']")));
	    saveEnvironments.isEnabled();
	    saveEnvironments.click();
	    
	    WebElement infoBox = driver.findElement(By.xpath("//div[@id='j_info_box']/p"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='j_info_box']/p")));
	    infoBox.isEnabled();
		String Expected2  = driver.findElement(By.xpath("//div[@id='j_info_box']/p")).getText();
		Assert.assertEquals(Expected2, "Środowisko zostało dodane.");
	
	
		driver.quit();
	}


}
