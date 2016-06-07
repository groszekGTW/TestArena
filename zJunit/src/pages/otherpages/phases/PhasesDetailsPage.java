package pages.otherpages.phases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class PhasesDetailsPage {
	WebDriver driver;
		
	By btnAddPhases =By.xpath ("//a[contains(.,'Dodaj fazê')]");
	By txtbxName = By.id("name");
	By selectRelease = By.id("releaseName");
	By txtbxDescription = By.id("description");
	By btnSave = By.id("save");
	String nazwaWydania = "NowaNazwa2";
	String xpathExpression = "//a[contains(.,'"+nazwaWydania+"')]";
	By itemPhases = By.xpath(xpathExpression);
	public By addPhasesInfo = By.xpath("//p[contains(.,'Faza zosta³a dodana.')]");
		
	public PhasesDetailsPage(WebDriver driver){
		this.driver = driver;
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
	public void setDescription (String description){
		PageUtils.sendKey(driver, txtbxDescription, "opis", description);
	}
	public void clickSave(){
		PageUtils.click(driver,  btnSave,"przycisk zapisz" );
	}
	public void releasePhases(String name,String relase, String description ){
		this.clickAddPhases();
		this.setName(name);  
	    this.setRelease(relase); 
	    this.clickRelease();
	    this.setDescription(description);
	    this.clickSave();
	}

}
