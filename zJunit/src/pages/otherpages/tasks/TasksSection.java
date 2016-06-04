package pages.otherpages.tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.PageUtils;

public class TasksSection {
		
		public TasksSection(WebDriver driver) {
			this.driver = driver;
		}
	
		WebDriver driver;
		
		private By titleView = By.xpath("//h1[@class='content_title']");
		private By addTask = By.xpath("//a[@href='http://testarena.gpe.pl/task_add']");
		private By releaseFilter = By.xpath("//select[@id='release']");
		private By phaseFilter = By.xpath("//select[@id='phase']");		
		private By statusFilter = By.xpath("//select[@id='status']");		
		private By priorityFilter = By.xpath("//select[@id='priority']");		
		private By assignerFilter = By.xpath("//select[@id='assigner']");		
		private By assigneeFilter = By.xpath("//select[@id='assignee']");		
		private By environmentFilter = (By.xpath("//select[@id='environment']"));		
		private By resultCountPerPageFilter = By.xpath("//select[@id='resultCountPerPage']");		
		private By exceededDueDateCheckbox = By.xpath("//input[@id='exceededDueDate']");		
		private By filterButton = By.xpath("//button[@id='j_filterButton']");
		private By actionList = By.id("action_icon");
		private By actionListClose = By.xpath("//a[contains(.,'Zamknij')]");
		private By infoBox = By.id("j_info_box");
				
		public By getViewTitle(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(titleView));
			return titleView;
		}
		
		
		public void addNewTask(){
			PageUtils.click(driver, addTask, "dodaj zadanie");
		}
			
		public void selectFiltrRelease(String release){
			PageUtils.selectFilter(driver, releaseFilter, "filtr wydanie", release);
		}
		
		public void selectFilterPhase(String phase){
			PageUtils.selectFilter(driver, phaseFilter, "filtr faza", phase);
		}
			
		public void selectFilterStatus(String status){
			PageUtils.selectFilter(driver, statusFilter, "filtr status", status);
		}
		
		public void selectFilterPriority(String priority){			
			PageUtils.selectFilter(driver, priorityFilter, "filtr priorytet", priority);
		}
		
		public void selectFilterAssigner(String assigner){	
			PageUtils.selectFilter(driver, assignerFilter, "filtr przydzielil", assigner);
		}
		
		public void selectFilterAssignee(String assignee){			
			PageUtils.selectFilter(driver, assigneeFilter, "filtr przydzielone do", assignee);
		}
				
		public void selectFilterEnvirionment(String envirionment){			
			PageUtils.selectFilter(driver, environmentFilter, "filtr srodowisko", envirionment);
		}
		
		public void selectFilterResult(String result){			
			PageUtils.selectFilter(driver, resultCountPerPageFilter, "filtr Wynik", result);
		}
		public void selectFilterExceededDueDate(){
			PageUtils.click(driver, exceededDueDateCheckbox, "checkbox przekroczony termin");
		}
		
		public void clickFilterButton(){
			PageUtils.click(driver, filterButton, "filtruj");
		}
					
		public void actionClose() throws InterruptedException{		
			PageUtils.click(driver, actionList, "akcji");
			Thread.sleep(2000);
			PageUtils.click(driver, actionListClose, "akcja zamknij");
		}
		
		public void asercjaZadania(){
			String Expected=driver.findElement(getViewTitle()).getText();		 
			Assert.assertEquals(Expected, "Zadania");
		}
		public void getInfoBox(){
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
		}
		
		public void filtrowaniePrzezFiltry(String status,String priority,String assigner,String assignee,String envirionment,String result){
						
			this.selectFilterStatus(status);
			this.selectFilterPriority(priority);
			this.selectFilterAssigner(assigner);
			this.selectFilterAssignee(assignee);
			this.selectFilterEnvirionment(envirionment);
			this.selectFilterResult(result);
			this.clickFilterButton();
		}		
}
