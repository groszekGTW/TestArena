package Zadania;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ZadaniaSekcja {
		
		WebDriver driver;
		private By tytulWidoku = By.xpath("//h1[@class='content_title']");
		private By dodajZadanie = By.xpath("//a[@href='http://testarena.gpe.pl/task_add']");
		private By filtrWydanie = By.xpath("//select[@id='release']");
		private By filtrFaza = By.xpath("//select[@id='phase']");		
		private By filtrStatus = By.xpath("//select[@id='status']");		
		private By filtrPriorytet = By.xpath("//select[@id='priority']");		
		private By filtrPrzydzielil = By.xpath("//select[@id='assigner']");		
		private By filtrPrzydzieloneDo = By.xpath("//select[@id='assignee']");		
		private By filtrSrodowisko = (By.xpath("//select[@id='environment']"));		
		private By filtrWynik = By.xpath("//select[@id='resultCountPerPage']");		
		private By CheckboxPrzekroczonyTermin = By.xpath("//input[@id='exceededDueDate']");		
		private By przyciskFiltr = By.xpath("//button[@id='j_filterButton']");
		private By akcjeLista = By.id("action_icon");
		private By akcjeListaZamknij = By.xpath("//a[contains(.,'Zamknij')]");
		private By komunikat = By.id("j_info_box");
				
		public By getTytulWidoku(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(tytulWidoku));
			return (tytulWidoku);
		}
		
		public ZadaniaSekcja(WebDriver driver) {
			this.driver = driver;
		}
		public void dodajNoweZadanie(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(dodajZadanie));
			driver.findElement(dodajZadanie).isEnabled();
			System.out.println("Pole dodaj zadanie jest dostêpne");
			driver.findElement(dodajZadanie).click();
		}
			
		public void WybierzFiltrWydanie(String wydanie){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrWydanie));
			driver.findElement(filtrWydanie).isEnabled();
			System.out.println("Pole filtr wydanie jest dostêpne");
			WebElement element = driver.findElement(filtrWydanie); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(wydanie);
		}
		
		public void wybierzFiltrFaze(String faza){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrFaza));
			driver.findElement(filtrFaza).isEnabled();
			System.out.println("Pole filtr faza jest dostêpne");
			WebElement element = driver.findElement(filtrFaza); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(faza);
		}
			
		public void WybierzFiltrStatus(String status){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrStatus));
			driver.findElement(filtrStatus).isEnabled();
			System.out.println("Pole filtr status jest dostêpne");
			WebElement element = driver.findElement(filtrStatus); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(status);
		}
		
		public void WybierzFiltrPriorytet(String priorytet){			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrPriorytet));
			driver.findElement(filtrPriorytet).isEnabled();
			System.out.println("Pole filtr priorytet jest dostêpne");
			WebElement element = driver.findElement(filtrPriorytet); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(priorytet);
		}
		
		public void WybierzfiltrPrzydzielil(String przydzielil){	
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrPrzydzielil));
			driver.findElement(filtrPrzydzielil).isEnabled();
			System.out.println("Pole filtr przydzielil zadanie jest dostêpne");
			WebElement element = driver.findElement(filtrPrzydzielil); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(przydzielil);
		}
		
		public void WybierzfiltrPrzydzieloneDo(String przydzieloneDo){			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrPrzydzieloneDo));
			driver.findElement(filtrPrzydzieloneDo).isEnabled();
			System.out.println("Pole filtr przydzielone do jest dostêpne");
			WebElement element = driver.findElement(filtrPrzydzieloneDo); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(przydzieloneDo);
		}
				
		public void WybierzfiltrSrodowisko(String srodowisko){			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrSrodowisko));
			driver.findElement(filtrSrodowisko).isEnabled();
			System.out.println("Pole filtr srodowisko jest dostêpne");
			WebElement element = driver.findElement(filtrSrodowisko); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(srodowisko);
		}
		
		public void WybierzfiltrWynik(String wynik){			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filtrWynik));
			driver.findElement(filtrWynik).isEnabled();
			System.out.println("Pole filtr wynik jest dostêpne");
			WebElement element = driver.findElement(filtrWynik); 
			Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(wynik);
		}
		public void ZaznaczCheckboxPrzekroczonyTermin(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckboxPrzekroczonyTermin));
			driver.findElement(CheckboxPrzekroczonyTermin).isEnabled();
			System.out.println("Pole Przekroczony termin jest dostêpne");
			driver.findElement(CheckboxPrzekroczonyTermin).click();
		}
		
		public void kliknijPrzyciskFiltr(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(przyciskFiltr));
			driver.findElement(przyciskFiltr).isEnabled();
			System.out.println("Pole filtruj jest dostêpne");

			driver.findElement(przyciskFiltr).click();
		}
					
		public void akcjeZamknij() throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(akcjeLista));
			driver.findElement(akcjeLista).isEnabled();
			System.out.println("Pole akcji jest dostêpne");
			driver.findElement(akcjeLista).click();
			Thread.sleep(2000);
			driver.findElement(akcjeListaZamknij).isEnabled();
			System.out.println("Akcja zamknij jest dostêpna");
			driver.findElement(akcjeListaZamknij).click();
		}
		
		public void asercjaZadania(){
			String Expected=driver.findElement(getTytulWidoku()).getText();		 
			Assert.assertEquals(Expected, "Zadania");
		}
		
		public void sprawdzKomunikatPoZamknieciuZadania(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
			String Expected=driver.findElement(komunikat).getText();
			Assert.assertEquals(Expected, "Zadanie zosta³o zamkniête.");
		}
		public void filtrowaniePrzezFiltry(String status,String priorytet,String przydzielil,String przydzieloneDo,String srodowisko,String wynik){
						
			this.WybierzFiltrStatus(status);
			this.WybierzFiltrPriorytet(priorytet);
			this.WybierzfiltrPrzydzielil(przydzielil);
			this.WybierzfiltrPrzydzieloneDo(przydzieloneDo);
			this.WybierzfiltrSrodowisko(srodowisko);
			this.WybierzfiltrWynik(wynik);
			this.kliknijPrzyciskFiltr();
		}
		
}
