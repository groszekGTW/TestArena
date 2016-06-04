package pages.otherpages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;


public class TaskAddingDetails {
	
		public TaskAddingDetails(WebDriver driver) {
		this.driver = driver;
		}
		
		WebDriver driver;
		WebDriverWait WebDriverWait;
		WebElement WebElement;
		
		private By titleView = By.xpath("//h1[@class='content_title']");
		private By titleField = By.id("title");
		private By descriptionField = By.id("description");
		private By releaseField = By.id("releaseName");
		private By environmentsField = By.id("token-input-environments");
		private By versionsField = By.id("token-input-versions");
		private By priorityList = By.id("priority");
		private By dueDateField = By.id("dueDate");
		private By assigneeNameField = By.id("assigneeName");
		private By assigneeNameList = By.xpath("//li[@class='ui-menu-item']");
		private By saveButton = By.id("save");
		
		public void getTitleView(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(titleView));
		}
			
		public void addTitle(String title){
			PageUtils.sendKey(driver, titleField, "tytu³", title);
		}
		
		public void addEnvironment(String envirioment) throws InterruptedException{
			PageUtils.sendKeyAndEnter(driver, environmentsField, "srodowiska", envirioment);
		}
		
		public void selectRelease(String release){
			PageUtils.sendKey(driver, releaseField, "wydanie", release);
		}
		
		
		public void selectVersion(String version) throws InterruptedException{	
			PageUtils.sendKeyAndEnter(driver, versionsField, "wersje", version);
		}
		
		public void selectPriority(String priority){
			PageUtils.selectFilter(driver, priorityList, "prioryte", priority);
		}
		
		public void selectDueDate(String date) throws InterruptedException{
			PageUtils.sendKeyAndEnter(driver, dueDateField, "termin realizacji", date);
		}
		
		public void asigneeSomeone(String someone) throws InterruptedException{
			PageUtils.sendKey(driver, assigneeNameField, "przypisz do", someone);
			PageUtils.click(driver, assigneeNameList, "Lista osób do przypisania");
			PageUtils.click(driver, titleView, "tytu³ widoku");
		}
		
		public void addDescription(String description) throws InterruptedException{
			PageUtils.sendKey(driver, descriptionField, "opis", description);
			PageUtils.click(driver, titleView, "tytu³ widoku");

		}
		 public void zapiszZmiany(){
			PageUtils.click(driver, saveButton, "zapisz");
		}
		
		 public void dodajNoweZadanie(String envirioment,String release, String version,String priority,String date,String someone,String title,String description) throws InterruptedException{
			 this.addEnvironment(envirioment);
			 this.selectRelease(release);
			 this.selectVersion(version);
			 this.selectPriority(priority);
			 this.selectDueDate(date);
			 this.asigneeSomeone(someone);
			 this.addTitle(title);
			 this.addDescription(description);
			 this.zapiszZmiany();			 
		 }

}
