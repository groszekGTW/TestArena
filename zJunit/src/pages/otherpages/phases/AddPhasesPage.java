package pages.otherpages.phases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class AddPhasesPage {
		
		WebDriver driver;
		
		By btnActions = By.id("action_icon");
		By btnPhases = By.xpath("//a[contains(.,'Fazy')]");
		By btnAddPhases =By.xpath ("//a[contains(.,'Dodaj fazê')]");
		By txtbxName = By.id("name");
		By selectRelease = By.id("releaseName");
		By txtbxStartDate = By.id("startDate");
		By txtbxEndDate = By.id("endDate");
		By txtbxDescription = By.id("description");
		By btnSave = By.id("save");
		String nazwaWydania = "NowaNazwa2";
		String xpathExpression = "//a[contains(.,'"+nazwaWydania+"')]";
		By itemPhases = By.xpath(xpathExpression);
		public By addPhasesInfo = By.xpath("//p[contains(.,'Faza zosta³a dodana.')]");
		
		public AddPhasesPage(WebDriver driver){
			this.driver = driver;
		}
		public void clickActions(){
			PageUtils.click(driver, btnActions, "przycisk akcji");
		}
		public void clickPhases(){
			PageUtils.click(driver, btnPhases, "przycisk fazy");
		}
		public void clickAddPhases(){
			PageUtils.click(driver, btnAddPhases, "przycisk dodaj faze");
		}
		public void setName (String name ){
			PageUtils.sendKey(driver, txtbxName, "nazwa", name);
		}
		public void setRelease (String release){
			PageUtils.sendKey(driver, selectRelease, "wydanie", release);
		}
		public void clickRelease(){
			PageUtils.click(driver, itemPhases, " przycisk wydanie");
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
			PageUtils.click(driver,  btnSave,"przycisk zapisz" );
		}

}
