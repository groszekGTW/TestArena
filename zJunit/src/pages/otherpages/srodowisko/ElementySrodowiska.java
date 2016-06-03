package pages.otherpages.srodowisko;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ElementySrodowiska {
	public ElementySrodowiska(WebDriver driver){
		this.driver = driver;
	}

	WebDriver driver;
	
	By DodajSrodowisko = By.xpath("//a[@href='http://testarena.gpe.pl/add_environment']");
	
	public void DodajNoweSrodowisko() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(DodajSrodowisko).click();
	}
	
	By EdytujIkona = By.id("action_icon");
	public void EdytujIkona(){
		driver.findElement(EdytujIkona).click();
	}
	
	
	By EdytujSrodowisko = By.xpath("//a[contains(.,'Edytuj')]");
	
	public void EdytujSrodowisko(){
		driver.findElement(EdytujSrodowisko).click();
		
	}
	By UsunSrodowisko = By.xpath("//a[contains(.,'Usuñ')]");
	public void UsunSrodowisko(){
		driver.findElement(UsunSrodowisko).click();
}
	By PotwierdzUsun = By.xpath("//button[contains(.,'Tak')]");;
	public void PotwierdzUsun(){
		driver.findElement(PotwierdzUsun).click();
		
	}
}
