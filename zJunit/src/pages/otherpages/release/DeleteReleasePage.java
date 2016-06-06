package pages.otherpages.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageUtils;

public class DeleteReleasePage {
		
		WebDriver driver;
		
		By btnAction = By.id("action_icon");
		By btnDeleteRelease = By.xpath ("//a[contains(.,'Usuñ')]");
		By btnDeletingRelease = By.xpath("//button[contains(.,'Tak')]");
		public By deletingReleaseInfo = By.xpath("//p[contains(.,'Wydanie zosta³o usuniête.')]");
		
		public DeleteReleasePage(WebDriver driver){
			this.driver = driver;
		}
		public void clickAction(){
			PageUtils.click(driver, btnAction, "przycisk akcji");
		}
		public void clickDeleteRelease(){
			PageUtils.click(driver, btnDeleteRelease, "przycisk usuñ");
		}
		public void clickDeletingRelease(){
			PageUtils.click(driver, btnDeletingRelease, "przycisk tak");
		}
		
}
