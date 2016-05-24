package Zadania;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ZadaniaSection {
		
		public ZadaniaSection(WebDriver driver) {
			this.driver = driver;
		}
		
		WebDriver driver;
		
		By dodajZadanie = By.xpath("//a[@href='http://testarena.gpe.pl/task_add']");
		
		By filtrWydanie = By.xpath("//select[@id='release']");
		
		By filtrFaza = By.xpath("//select[@id='phase']");
		
		By filtrStatus = By.xpath("//select[@id='status']");
		
		By filtrPriorytet = By.xpath("//select[@id='priority']");
		
		By filtrPrzydzielil = By.xpath("//select[@id='assigner']");
		
		By filtrPrzydzieloneDo = By.xpath("//select[@id='assignee']");
		
		By filtrSrodowisko = (By.xpath("//select[@id='environment']"));
		
		By filtrWynik = By.xpath("//select[@id='resultCountPerPage']");
		
		By CheckboxPrzekroczonyTermin = By.xpath("//input[@id='exceededDueDate']");
		
		By przyciskFiltr = By.xpath("//button[@id='j_filterButton']");
		
		public void dodajNoweZadanie(){
			driver.findElement(dodajZadanie).click();
		}
			
		public void WybierzFiltrWydanie(String wydanie){
			//WebElement element = driver.findElement(By.xpath("//select[@id='release']")); 
			WebElement element = driver.findElement(filtrWydanie); 
						Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(wydanie);
		}
		
		public void wybierzFiltrFaze(String faza){			
			WebElement element = driver.findElement(filtrFaza); 
						Select dropDown = new Select(element); 
			dropDown.selectByVisibleText(faza);
		}
			
		public void WybierzFiltrStatus(String status){			
			WebElement element = driver.findElement(filtrStatus); 
				Select dropDown = new Select(element); 
				dropDown.selectByVisibleText(status);
		}
		
		public void WybierzFiltrPriorytet(String priorytet){			
			WebElement element = driver.findElement(filtrPriorytet); 
				Select dropDown = new Select(element); 
				dropDown.selectByVisibleText(priorytet);
		}
		
		public void WybierzfiltrPrzydzielil(String przydzielil){			
			WebElement element = driver.findElement(filtrPrzydzielil); 
				Select dropDown = new Select(element); 
				dropDown.selectByVisibleText(przydzielil);
		}
		
		public void WybierzfiltrPrzydzieloneDo(String przydzieloneDo){			
			WebElement element = driver.findElement(filtrPrzydzieloneDo); 
				Select dropDown = new Select(element); 
				dropDown.selectByVisibleText(przydzieloneDo);
		}
				
		public void WybierzfiltrSrodowisko(String srodowisko){			
			WebElement element = driver.findElement(filtrSrodowisko); 
				Select dropDown = new Select(element); 
				dropDown.selectByVisibleText(srodowisko);
		}
		
		public void WybierzfiltrWynik(String wynik){			
			WebElement element = driver.findElement(filtrWynik); 
				Select dropDown = new Select(element); 
				dropDown.selectByVisibleText(wynik);
		}
		public void ZaznaczCheckboxPrzekroczonyTermin(){
			driver.findElement(CheckboxPrzekroczonyTermin).click();
		}
		
		public void kliknijPrzyciskFiltr(){
			driver.findElement(przyciskFiltr).click();
		}
		
		public void filtrowaniePrzezFiltry(String wydanie,String faza,String status,String priorytet,String przydzielil,String przydzieloneDo,String srodowisko,String wynik){
					
			this.WybierzFiltrWydanie(wydanie);
			this.wybierzFiltrFaze(faza);
			this.WybierzFiltrStatus(status);
			this.WybierzFiltrPriorytet(priorytet);
			this.WybierzfiltrPrzydzielil(przydzielil);
			this.WybierzfiltrPrzydzieloneDo(przydzieloneDo);
			this.WybierzfiltrSrodowisko(srodowisko);
			this.WybierzfiltrWynik(wynik);
			this.ZaznaczCheckboxPrzekroczonyTermin();
			this.kliknijPrzyciskFiltr();
		}
	
}
