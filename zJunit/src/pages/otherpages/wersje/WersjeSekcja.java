package pages.otherpages.wersje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WersjeSekcja {
	
			WebDriver driver;
	
			private By tytulWidoku = By.xpath("//h1[@class='content_title']");
			private By dodajWersje = By.xpath("//a[@href='http://testarena.gpe.pl/add_version']");	
			private By filtrWynik = By.id("resultCountPerPage");
			private By przyciskFiltr = By.id("j_filterButton");
			private By akcjeLista = By.id("action_icon");
			private By akcjeListaEdytuj = By.xpath("//a[contains(.,'Edytuj')]");
			private By akcjeListaUsun = By.xpath("//a[contains(.,'Usuñ')]");
			private By komunikat = By.xpath("//div[@id='j_info_box']/p");
			private By komunikatDecyzji = By.xpath("//div[@id='j_popup_delete_version']/p");
			private By SzukajPole = By.id("search");
			private By szukajPrzycisk = By.xpath("//a[@id='j_searchButton']");
			private By komunikatDecyzjiTak = By.xpath("//button[contains(.,'Tak')]");
					
			public By getTytulWidoku(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(tytulWidoku));
				return (tytulWidoku);
			}
			
			public WersjeSekcja(WebDriver driver) {
				this.driver = driver;
			}
			public void dodajNowaWersje(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(dodajWersje));
				driver.findElement(dodajWersje).isEnabled();
				System.out.println("Pole dodaj zadanie jest dostêpne");
				driver.findElement(dodajWersje).click();
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
			public void kliknijPrzyciskFiltr(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(przyciskFiltr));
				driver.findElement(przyciskFiltr).isEnabled();
				System.out.println("Pole filtruj jest dostêpne");
				driver.findElement(przyciskFiltr).click();
			}						
			public void akcjeEdytuj() throws InterruptedException{
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(akcjeLista));
				driver.findElement(akcjeLista).isEnabled();
				System.out.println("Pole akcji jest dostêpne");
				driver.findElement(akcjeLista).click();
				Thread.sleep(2000);
				driver.findElement(akcjeListaEdytuj).isEnabled();
				System.out.println("Akcja edytuj jest dostêpna");
				driver.findElement(akcjeListaEdytuj).click();
			}
			
			public void akcjeUsun() throws InterruptedException{
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(akcjeLista));
				driver.findElement(akcjeLista).isEnabled();
				System.out.println("Pole akcji jest dostêpne");
				driver.findElement(akcjeLista).click();
				Thread.sleep(2000);
				driver.findElement(akcjeListaUsun).isEnabled();
				System.out.println("Akcja usun jest dostêpna");
				driver.findElement(akcjeListaUsun).click();
			}
			public void wypelnijSzukajPole(String szukanaFraza){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(SzukajPole));
				driver.findElement(SzukajPole).isEnabled();
				System.out.println("Pole szukaj jest dostêpne");
				driver.findElement(SzukajPole).clear();		
				driver.findElement(SzukajPole).sendKeys(szukanaFraza);
			}
			
			public void kliknijSzukajPrzycisk(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(szukajPrzycisk));
				driver.findElement(szukajPrzycisk).isEnabled();
				System.out.println("Przycisk szukaj jest dostêpny");
				driver.findElement(szukajPrzycisk).click();				
			}
			
			public void dokonajDecyzjiTak(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikatDecyzji));
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikatDecyzjiTak));
				driver.findElement(komunikatDecyzjiTak).isEnabled();
				System.out.println("Przycisk tak w komunikacie decyzji jest dostêpny");
				driver.findElement(komunikatDecyzjiTak).click();
			}

			public void asercjaWersje(){
				String Expected=driver.findElement(getTytulWidoku()).getText();		 
				Assert.assertEquals(Expected, "Wersje");
			}			
			public void sprawdzKomunikatPoEdytowaniuWersji(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
				String Expected=driver.findElement(komunikat).getText();
				Assert.assertEquals(Expected, "Wersja zosta³a zapisana.");
			}
			public void sprawdzKomunikatPoZapisieWersji(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
				String Expected=driver.findElement(komunikat).getText();
				Assert.assertEquals(Expected, "Wersja zosta³a dodana.");
			}
			
			public void sprawdzKomunikatPrzyProbieUsunieciaWersji(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikatDecyzji));
				String Expected=driver.findElement(komunikatDecyzji).getText();
				Assert.assertEquals(Expected, "Czy na pewno chcesz usun¹æ t¹ wersjê?");
			}
			public void sprawdzKomunikatPoUsunieciuWersji(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
				String Expected=driver.findElement(komunikat).getText();
				Assert.assertEquals(Expected, "Wersja zosta³a usuniêta.");
			}
			public void szukajWyniku(String szukanaFraza){
				this.wypelnijSzukajPole(szukanaFraza);
				this.kliknijSzukajPrzycisk();
			}
			


}
