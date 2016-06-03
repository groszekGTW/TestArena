package pages.loginpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogowanieUzytkownika {
	
	public LogowanieUzytkownika(WebDriver driver) {
		this.driver = driver;
		
	}
	WebDriver driver;
	
	private By UserNamePole = By.id("email");
	private By PasswordPole = By.id("password");
	private By btn_LogIn = By.id("login");
	
	public void open(String url) {
		driver.get(url);
		}
	
	public void setUsername (String Username ){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserNamePole));
		driver.findElement(UserNamePole).isEnabled();
		System.out.println("Pole Adres E-mail jest dostêpne");
		driver.findElement(UserNamePole).sendKeys(Username);
	}
	
	public void setPassword (String Password){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordPole));
		driver.findElement(PasswordPole).isEnabled();
		System.out.println("Pole Has³o jest dostêpne");
		driver.findElement(PasswordPole).sendKeys(Password);
	}
	
	public void clickLogIn (){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_LogIn));
		driver.findElement(btn_LogIn).isEnabled();
		System.out.println("Pole Zaloguj jest dostêpne");
		driver.findElement(btn_LogIn).click();
	}
	public void loginToArena(String Username,String Password){
		this.setUsername(Username); 
        this.setPassword(Password); 
        this.clickLogIn();        
 
         
	}
}



