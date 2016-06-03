package pages.otherpages.version;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.PageUtils;

public class VersionSection {
	
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
					
			public void getTitlelView(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(tytulWidoku));
			}
			
			public VersionSection(WebDriver driver) {
				this.driver = driver;
			}
			public void addNewVersion(){
				PageUtils.click(driver, dodajWersje, "dodaj wersje");
			}				
			public void resultFilter(String wynik){			
				PageUtils.selectFilter(driver, filtrWynik, "filtr wynik", wynik);
			}
			public void filterButton(){
				PageUtils.click(driver, przyciskFiltr, "filtruj");
			}						
			public void actionEdit() throws InterruptedException{
				PageUtils.click(driver, akcjeLista, "akcji");
				Thread.sleep(2000);
				PageUtils.click(driver, akcjeListaEdytuj, "Akcje edytuj");
			}
			
			public void actionDelete() throws InterruptedException{
				PageUtils.click(driver, akcjeLista, "akcji");
				Thread.sleep(2000);
				PageUtils.click(driver, akcjeListaUsun, "Akcje usuñ");

			}
			public void filInSearch(String szukanaFraza){
				PageUtils.sendKey(driver, SzukajPole, "szukaj", szukanaFraza);
			}
			
			public void clickSearch(){
				PageUtils.click(driver, szukajPrzycisk, "Przycisk szukaj");
			}
			
			public void getPopupDelete(){
				PageUtils.returnElement(driver, komunikatDecyzji);
			}
			public void	clickYes(){
				PageUtils.click(driver, komunikatDecyzjiTak, "Przycisk tak w komunikacie decyzji");
			}

						
			
			public void getInfoBoxAfterEdit(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
			}
			
			public void getInfoBoxAfterSave(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
			}
			
			public void getInfoBoxAfterTryToDelete(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikatDecyzji));
			}
			public void getInfoBoxAfterDelete(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(komunikat));
		
			}
			public void searchForResult(String szukanaFraza){
				this.filInSearch(szukanaFraza);
				this.clickSearch();
			}
			
			public  void choseYes(){
				this.getPopupDelete();
				this.clickYes();
			}


}
