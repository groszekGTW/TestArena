package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class ReleaseSectionPage {
	WebDriver driver;
		
	By btnAddRelease = By.xpath("//a[@href='http://testarena.gpe.pl/add_release']");
	By btnAction = By.id("action_icon");
	By btnEditRelease = By.xpath ("//a[contains(.,'Edytuj')]");
	By btnCloneRelease = By.xpath ("//a[contains(.,'Klonuj')]");
	By btnDeleteRelease = By.xpath ("//a[contains(.,'Usuñ')]");
	By btnDeletingRelease = By.xpath("//button[contains(.,'Tak')]");
	By btnPhases = By.xpath("//a[contains(.,'Fazy')]");
	public By addReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o dodane.')]");
	public By addReleases = By.xpath("//a[contains(.,'Wydanie1')]");
	public By editReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o zapisane.')]");
	public By editRelease = By.xpath("//a[contains(.,'NowaNazwa1')]");
	public By cloneReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o sklonowane.')]");
	public By cloneRelease = By.xpath("//a[contains(.,'NowaNazwa2')]");
	public By deletingReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o usuniête.')]");
	public By addPhasesInfo = By.xpath("//p[contains(.,'Faza zosta³a dodana.')]");
		
	public ReleaseSectionPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickAddRelease(){
		PageUtils.click(driver, btnAddRelease, "przycisk dodaj wydanie");
	}
	public void clickAction(){
		PageUtils.click(driver, btnAction, "przycisk akcji");
	}
	public void clickEditRelease(){
		PageUtils.click(driver, btnEditRelease, "przycisk edytuj");
	}
	public void clickCloneRelease(){
		PageUtils.click(driver, btnCloneRelease, "przycisk klonuj");
	}
	public void clickDeleteRelease(){
		PageUtils.click(driver, btnDeleteRelease, "przycisk usuñ");
	}
	public void clickDeletingRelease(){
		PageUtils.click(driver, btnDeletingRelease, "przycisk tak");
	}
	public void clickPhases(){
		PageUtils.click(driver, btnPhases, "przycisk fazy");
	}
	public void releaseClickEdit(){
		this.clickAction();
		this.clickEditRelease();
	}
	public void releaseClickClone(){
	    this.clickAction(); 
	    this.clickCloneRelease(); 
	}
	public void releaseDelete(){
		this.clickAction();
		this.clickDeleteRelease();
		this.clickDeletingRelease();
	}
	public void releaseClickPhases(){
		this.clickAction();
		this.clickPhases();
	}

}
