package Srodowisko;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FunkcjeSrodowiska {
	public FunkcjeSrodowiska(WebDriver driver){
		this.driver = driver;
	}

	WebDriver driver;

	
	By NazwaSrodowisko = By.xpath("//input[@id='name']");
	By WpiszOpis = By.xpath("//textarea[@id='description']");
	By ZapiszSrodowisko = By.xpath("//input[@id='save']");
	
	
	public void DodajNowaNazwe(String wpisznazwe){
	driver.findElement(NazwaSrodowisko).sendKeys(wpisznazwe);
	}

	public void UsunNazwe(){
	driver.findElement(NazwaSrodowisko).clear();
	}

	public void DodajNowyOpis(String wpiszopis){	
	driver.findElement(WpiszOpis).sendKeys(wpiszopis);
	}

	public void UsunOpis(){	
	driver.findElement(WpiszOpis).clear();
	}

	public void ZapiszSrodowisko(){
	driver.findElement(ZapiszSrodowisko).click();
	}

}