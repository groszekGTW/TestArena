package pages.otherpages.version;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;

public class VersionSection {
	
			public VersionSection(WebDriver driver) {
				this.driver = driver;
			}
	
			WebDriver driver;
	
			private By viewTitle = By.xpath("//h1[@class='content_title']");
			private By addVersion = By.xpath("//a[@href='http://testarena.gpe.pl/add_version']");	
			private By resultFilter = By.id("resultCountPerPage");
			private By filterButton = By.id("j_filterButton");
			private By acctionlist = By.id("action_icon");
			private By acctionEdit = By.xpath("//a[contains(.,'Edytuj')]");
			private By acctionDelete = By.xpath("//a[contains(.,'Usuñ')]");
			private By infoBox = By.xpath("//div[@id='j_info_box']/p");
			private By decisionInfoBox = By.xpath("//div[@id='j_popup_delete_version']/p");
			private By searchField = By.id("search");
			private By searchButton = By.xpath("//a[@id='j_searchButton']");
			private By decisionInfoBoxYes = By.xpath("//button[contains(.,'Tak')]");
					
			public void getTitlelView(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(viewTitle));
			}
			
			
			public void addNewVersion(){
				PageUtils.click(driver, addVersion, "dodaj wersje");
			}				
			public void resultFilter(String wynik){			
				PageUtils.selectFilter(driver, resultFilter, "filtr wynik", wynik);
			}
			public void filterButton(){
				PageUtils.click(driver, filterButton, "filtruj");
			}						
			public void actionEdit() throws InterruptedException{
				PageUtils.click(driver, acctionlist, "akcji");
				Thread.sleep(2000);
				PageUtils.click(driver, acctionEdit, "Akcje edytuj");
			}
			
			public void actionDelete() throws InterruptedException{
				PageUtils.click(driver, acctionlist, "akcji");
				Thread.sleep(2000);
				PageUtils.click(driver, acctionDelete, "Akcje usuñ");

			}
			public void filInSearch(String szukanaFraza){
				PageUtils.sendKey(driver, searchField, "szukaj", szukanaFraza);
			}
			
			public void clickSearch(){
				PageUtils.click(driver, searchButton, "Przycisk szukaj");
			}
						
			public void	clickYes(){
				PageUtils.click(driver, decisionInfoBoxYes, "Przycisk tak w komunikacie decyzji");
			}			
			
			public void getInfoBoxAfterEdit(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
			}
			
			public void getInfoBoxAfterSave(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
			}
			
			public void getInfoBoxAfterTryToDelete(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(decisionInfoBox));
			}
			public void getInfoBoxAfterDelete(){
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
		
			}
			public void searchForResult(String szukanaFraza){
				this.filInSearch(szukanaFraza);
				this.clickSearch();
			}
			
			public  void choseYes(){
				this.getInfoBoxAfterTryToDelete();
				this.clickYes();
			}


}
