package tests.othertests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReleaseTestsClassic {

		protected WebDriver driver;
	 
		
		@Test
		public void addReleaseClassic() {
			WebDriver driver = new FirefoxDriver();
			driver.get("http://testarena.gpe.pl");
			WebDriverWait wait = new WebDriverWait(driver,5);
			WebElement user = driver.findElement(By.id("email"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
			user.isEnabled();
			System.out.println("Pole adres e-mail dost�pne");
			user.sendKeys("jagusia.serkowska@gmail.com");
			WebElement password = driver.findElement(By.id("password"));
			password.isEnabled();
			System.out.println("Pole has�o dostepne");
			password.sendKeys("Wsb123");
			WebElement login = driver.findElement(By.id("login"));
			login.isEnabled();
			System.out.println("Pole zaloguj dost�pne");
			login.click();
			try {
				assertEquals("Agnieszka",driver.findElement(By.xpath("//span[contains(@class,'user-info')]")).getText().substring(0, 9));
				System.out.println("W polu z imieniem i nazwiskiem imie ma 9 znakow");
			} 
			catch (Error e) {
				System.out.println(e.toString());
			}
			
			
			try {
				assertNotNull(driver.findElement(By.xpath("//span[contains(@class,'user-info')]")));
				System.out.println("Pole z imieniem i nazwiskiem istnieje");
			}
			catch (Error e) {
				System.out.println(e.toString());
			}
			wait = new WebDriverWait(driver,5);
			WebElement release = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/releases']"));
			release.isEnabled();
			System.out.println("Przycisk wydanie dost�pny");
			release.click();
			wait = new WebDriverWait(driver,5);
			WebElement addRelease = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/add_release']"));
			addRelease.isEnabled();
			System.out.println("Przycisk dodaj wydanie dost�pny");
			addRelease.click();
			wait = new WebDriverWait(driver,5);
			WebElement setName = driver.findElement(By.id("name"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
			setName.isEnabled();
			System.out.println("Pole nawa dost�pne");
			setName.sendKeys("Nazwa1");
			WebElement setStartDate = driver.findElement(By.id("startDate"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startDate")));
			setStartDate.isEnabled();
			System.out.println("Pole dataR dost�pne");
			setStartDate.sendKeys("2016-06-30");
			WebElement setEndDate = driver.findElement(By.id("endDate"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("endDate")));
			setEndDate.isEnabled();
			System.out.println("Pole dataZ dost�pne");
			setEndDate.sendKeys("2016-07-30");
			WebElement setDescription = driver.findElement(By.id("description"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
			setDescription.isEnabled();
			System.out.println("Pole opis dost�pne");
			setDescription.sendKeys("Opis");
			WebElement clickSave = driver.findElement(By.id("save"));
			clickSave.isEnabled();
			System.out.println("Przycisk zapisz dost�pny");
			clickSave.click();
			try
			{
				 assertEquals("Wydanie1",driver.findElement(By.xpath("//a[contains(.,'Wydanie1')]")).getText());
				 System.out.println("Pole z nazw� istnieje");
			 }
			 catch (Error e)
			{
				 System.out.println(e.toString());
				 
			}
			String wiadomosc = driver.findElement(By.xpath("//p[contains(.,'Wydanie zosta�o dodane.')]")).getText();
			try
			{
				assertEquals("Wydanie zosta�o dodane.",wiadomosc);
				System.out.println("Komunikat wydanie zosta�o dodane");		 
			}
				 
			catch (Error e)
			{
				System.out.println(e.toString());
			}
			driver.quit();
			
		}
	

}
