package tests.logintests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPageTestClassic {
				
			public static void main(String[] args) throws InterruptedException {
		        WebDriver driver = new FirefoxDriver();
		        driver.get("http://testarena.gpe.pl");
		        WebDriverWait wait = new WebDriverWait(driver, 5);
		        WebElement username = driver.findElement(By.id("email"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
				username.isEnabled();
				System.out.println("Pole adres e-mail jest dostêpne");
				username.sendKeys("groszkowskimichal@gmail.com");        
				WebElement Password = driver.findElement(By.id("password"));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			    Password.isEnabled();
				System.out.println("Pole has³o jest dostêpne");
			    Password.sendKeys("Gro3chu!");	    
			    WebElement Login = driver.findElement(By.id("login"));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			    Login.isEnabled();
				System.out.println("Pole zaloguj jest dostêpne");
			    Login.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='user-info']/small")));
			    String Expected=driver.findElement(By.xpath("//span[@class='user-info']/small")).getText();		 
				Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");
			    driver.quit();  
			}
		
	}
