package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class ReleaseDetailsPage {
	WebDriver driver;
		
	By txtbxName = By.id("name");
	By txtbxStartDate = By.id("startDate");
	By txtbxEndDate = By.id("endDate");
	By txtbxDescription = By.id("description");
	By btnSave = By.id("save");
		
	public ReleaseDetailsPage(WebDriver driver) {
		this.driver = driver;
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
	public void setDescription (String description){
		PageUtils.sendKey(driver, txtbxDescription, "opis", description);
	}
	public void clickSave(){
		PageUtils.click(driver, btnSave, "przycisk zapisz");
	}
	public void releaseDetail(String name,String startDate,String endDate, String description ){
		this.setName(name);  
	    this.setStartDate(startDate); 
	    this.setEndDate(endDate);
	    this.setDescription(description);
	    this.clickSave();
	}

}
