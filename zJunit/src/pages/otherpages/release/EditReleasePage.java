package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class EditReleasePage {
		
		WebDriver driver;
		
		By btnAction = By.id("action_icon");
		By btnEditRelease = By.xpath ("//a[contains(.,'Edytuj')]");
		By txtbxName = By.id("name");
		By txtbxStartDate = By.id("startDate");
		By txtbxEndDate = By.id("endDate");
		By txtbxDescription = By.id("description");
		By btnSave = By.id("save");
		public By editRelease = By.xpath("//a[contains(.,'NowaNazwa1')]");
		public By editReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o zapisane.')]");

		public EditReleasePage(WebDriver driver){
			this.driver = driver;
		}
		public void clickAction(){
			PageUtils.click(driver, btnAction, "przycisk akcji");
		}
		public void clickEditRelease(){
			PageUtils.click(driver, btnEditRelease, "przycisk edytuj");
		}
		public void setName(String name){
			PageUtils.sendKey(driver, txtbxName, "nazwa", name);
		}
		public void setStartDate (String startDate){
			PageUtils.sendKey(driver, txtbxStartDate, "data rozpoczêcia", startDate);
		}
		public void setEndDate (String endDate){
			PageUtils.sendKey(driver, txtbxEndDate, "data zakoñczenia", endDate);
		}
		public void setDescription (String description){
			PageUtils.sendKey(driver, txtbxDescription, "opis", description);
		}
		public void clickSave(){
			PageUtils.click(driver, btnSave, "przycisk zapisz");
		}

}
