package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class ReleaseCloneDetailsPage {
	WebDriver driver;
		
	By txtbxName = By.id("name");
	By txtbxEndDate = By.id("endDate");
	By selectEnvironments = By.xpath("//input[contains(@id,'token-input-environments')]");
	By btnEnvironments = By.id("token-input-envitonments");
	By selectVersions = By.id("token-input-versions");
	By btnSave = By.id("save");
		
		
	public ReleaseCloneDetailsPage(WebDriver driver){
		this.driver = driver;
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
	public void releaseClone(String name,String endData,String environment,String version ) throws InterruptedException{

	     this.setName(name); 
	     this.setEndDate(endData); 	 
	     this.selectEnvironment(environment);   
	     this.selectVersion(version);   
	     this.clickSave();
	 }
}


