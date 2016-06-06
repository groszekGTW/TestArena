package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class CloneReleasePage {
		
		WebDriver driver;
		
		By btnAction = By.id("action_icon");
		By btnCloneRelease = By.xpath ("//a[contains(.,'Klonuj')]");
		By txtbxName = By.id("name");
		By txtbxEndDate = By.id("endDate");
		By selectEnvironments = By.xpath("//input[contains(@id,'token-input-environments')]");
		By btnEnvironments = By.id("token-input-envitonments");
		By selectVersions = By.id("token-input-versions");
		By btnSave = By.id("save");
		public By cloneRelease = By.xpath("//a[contains(.,'NowaNazwa2')]");
		public By cloneReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o sklonowane.')]");
		
		public CloneReleasePage(WebDriver driver){
			this.driver = driver;
		}
		public void clickAction(){
			PageUtils.click(driver, btnAction, "przycisk akcji");
		}

		public void clickCloneRelease(){
			PageUtils.click(driver, btnCloneRelease, "przycisk klonuj");
		}
		public void setName(String name){
			PageUtils.sendKey(driver, txtbxName, "nazwa", name);
		}
		public void setEndDate (String endDate){
			PageUtils.sendKey(driver, txtbxEndDate, "data zakoñczenia", endDate);
		}
		public void selectEnvironment (String environment)throws InterruptedException{
			PageUtils.sendKeyAndEnter(driver, selectEnvironments, "wybierz œrodowisko", environment);
		}
		public void selectVersion (String version)throws InterruptedException{
			PageUtils.sendKeyAndEnter(driver, selectVersions, "wybierz wersje", version);
		}
		public void clickSave(){
			PageUtils.click(driver, btnSave, "przycisk zapisz");
		}
}
