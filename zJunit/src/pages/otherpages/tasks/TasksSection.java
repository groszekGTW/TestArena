package pages.otherpages.tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.PageUtils;

public class TasksSection {
		
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
		
		public TasksSection(WebDriver driver) {
			this.driver = driver;
		}
		public void dodajNoweZadanie(){
			PageUtils.click(driver, dodajZadanie, "dodaj zadanie");
		}
			
		public void WybierzFiltrWydanie(String keyRelease){
			PageUtils.selectFilter(driver, filtrWydanie, "filtr wydanie", keyRelease);

		}
		
		public void wybierzFiltrFaze(String keyFaza){
			PageUtils.selectFilter(driver, filtrFaza, "filtr faza", keyFaza);
		}
			
		public void WybierzFiltrStatus(String keyStatus){
			PageUtils.selectFilter(driver, filtrStatus, "filtr status", keyStatus);
		}
		
		public void WybierzFiltrPriorytet(String keyPriorytet){			
			PageUtils.selectFilter(driver, filtrPriorytet, "filtr priorytet", keyPriorytet);
		}
		
		public void WybierzfiltrPrzydzielil(String keyAssigner){	
			PageUtils.selectFilter(driver, filtrPrzydzielil, "filtr przydzielil", keyAssigner);

		}
		
		public void WybierzfiltrPrzydzieloneDo(String keyAssignee){			
			PageUtils.selectFilter(driver, filtrPrzydzieloneDo, "filtr przydzielone do", keyAssignee);

		}
				
		public void WybierzfiltrSrodowisko(String keyEnvirionment){			
			PageUtils.selectFilter(driver, filtrSrodowisko, "filtr srodowisko", keyEnvirionment);

		}
		
		public void WybierzfiltrWynik(String keyResult){			
			PageUtils.selectFilter(driver, filtrWynik, "filtr Wynik", keyResult);

		}
		public void ZaznaczCheckboxPrzekroczonyTermin(){
			PageUtils.click(driver, CheckboxPrzekroczonyTermin, "checkbox przekroczony termin");

		}
		
		public void kliknijPrzyciskFiltr(){
			PageUtils.click(driver, przyciskFiltr, "filtruj");
		}
					
		public void akcjeZamknij() throws InterruptedException{		
			PageUtils.click(driver, akcjeLista, "akcji");
			Thread.sleep(2000);
			PageUtils.click(driver, akcjeListaZamknij, "akcja zamknij");
		}
		
		public void asercjaZadania(){
			String Expected=driver.findElement(getTytulWidoku()).getText();		 
			Assert.assertEquals(Expected, "Zadania");
		}
		public void getInfoBox(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
			String Expected=driver.findElement(komunikat).getText();
		}
		
				
		public void getInfoBoxtext(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
		}
		public void filtrowaniePrzezFiltry(String keyStatus,String keyPriorytet,String keyAssigner,String przydzieloneDo,String srodowisko,String wynik){
						
			this.WybierzFiltrStatus(keyStatus);
			this.WybierzFiltrPriorytet(keyPriorytet);
			this.WybierzfiltrPrzydzielil(keyAssigner);
			this.WybierzfiltrPrzydzieloneDo(przydzieloneDo);
			this.WybierzfiltrSrodowisko(srodowisko);
			this.WybierzfiltrWynik(wynik);
			this.kliknijPrzyciskFiltr();
		}
		
}
