package LoginPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	
	By txtbx_UserName = By.id("email");

	By txtbx_Password = By.id("password");
	
	By btn_LogIn = By.id("login");
	
	
	
	
	  
	public void setUsername (String Username ){
		driver.findElement(txtbx_UserName).isEnabled();
		System.out.println("Pole login dostêpne");
		driver.findElement(txtbx_UserName).sendKeys(Username);
	}
	
	public void setPassword (String Password){
		driver.findElement(txtbx_Password).isEnabled();
		System.out.println("Pole login dostêpne");
		driver.findElement(txtbx_Password).sendKeys(Password);
	}
	
	public void clickLogIn (){
		driver.findElement(btn_LogIn).click();
	}
	public void loginToArena(String Username,String Password){
		 
        this.setUsername(Username); 
 
        this.setPassword(Password); 
 
        this.clickLogIn();        
 
         
	}
}



