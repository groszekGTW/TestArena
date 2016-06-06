package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class AddReleasePage {
			
		WebDriver driver;
		
		By btnAddRelease = By.xpath("//a[@href='http://testarena.gpe.pl/add_release']");
		By txtbxName = By.id("name");
		By txtbxStartDate = By.id("startDate");
		By txtbxEndDate = By.id("endDate");
		By txtbxDescription = By.id("description");
		By btnSave = By.id("save");
		public By addReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o dodane.')]");
		public By addReleases = By.xpath("//a[contains(.,'Wydanie1')]");
		
		public AddReleasePage(WebDriver driver) {
			this.driver = driver;
		}

		public void clickAddRelease(){
			PageUtils.click(driver, btnAddRelease, "przycisk dodaj wydanie");
		}
		
		public void setName (String name ){
			PageUtils.sendKey(driver, txtbxName, "nazwa", name);
		}
		
		public void setStartDate (String startDate){
			PageUtils.sendKey(driver, txtbxStartDate, "data rozpoczêcia", startDate);
		}
		
		public void setEndDate (String endDate){
			PageUtils.sendKey(driver, txtbxEndDate, "data zakoñczenia", endDate);
		}
		
		public void setDescripton (String description){
			PageUtils.sendKey(driver, txtbxDescription, "opis", description);
		}
		
		public void clickSave(){
			PageUtils.click(driver, btnSave, "przycisk zapisz");
		}
}

