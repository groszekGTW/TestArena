package pages.otherpages.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PageUtils;

public class TestsSection {
	
	public TestsSection(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	private By viewTitle = By.xpath("//h1[@class='content_title']");
	private By typeFilter = By.id("type");
	private By authorFilter = By.id("author");
	private By resultCountPerPage = By.id("resultCountPerPage");
	private By filterButton = By.id("j_filterButton");
	private By searchField = By.id("search");
	private By searchButton = By.id("j_searchButton");
	private By openButton = By.xpath("//a[@class='open button_link']");
	private By addTestCase = By.xpath("//a[@href='http://testarena.gpe.pl/test/add_test_case']");
	private By infoBox = By.xpath("//div[@id='j_info_box']/p");
	private By decisionInfoBox = By.xpath("//div[@id='j_popup_delete_test']/p");
	private By acctionlist = By.id("action_icon");
	private By acctionEdit = By.xpath("//a[contains(.,'Edytuj')]");
	private By acctionDelete = By.xpath("//a[contains(.,'Usuñ')]");
	private By decisionInfoBoxYes = By.xpath("//button[contains(.,'Tak')]");

	
	public void getTitlelView(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewTitle));
	}
	
	public void selectTypeFilter(String type){
		PageUtils.selectFilter(driver, typeFilter, "Filtr typ", type);
	}
	
	public void selectResultCountPerPage(String result){
		PageUtils.selectFilter(driver, resultCountPerPage, "Filtr autor", result);
	}
	
	public void selectAuthorFilter(String author){
		PageUtils.selectFilter(driver, authorFilter, "Filtr autor", author);
	}
	
	public void clickFilterButton(){
		PageUtils.click(driver, filterButton, "przycisk filtr");
	}
	
	public void fillSearchField(String searchKey){
		PageUtils.sendKey(driver, searchField, "szukaj", searchKey);
	}
	
	public void clickSearchButton(){
		PageUtils.click(driver, searchButton, "przycisk szukaj");
	}
	
	public void clickOpenButton(){
		PageUtils.click(driver, openButton, "dodaj");
	}
	
	public void clickAddTestCase(){
		PageUtils.click(driver, addTestCase, "przypadek testowy");
	}
	
	public void actionEdit() throws InterruptedException{
		PageUtils.click(driver, acctionlist, "akcji");
		Thread.sleep(2000);
		PageUtils.click(driver, acctionEdit, "Akcje edytuj");
	}
	
	public void actionDelete() throws InterruptedException{
		PageUtils.click(driver, acctionlist, "akcji");
		Thread.sleep(2000);
		PageUtils.click(driver, acctionDelete, "Akcje usuñ");
	}
	public void	clickYes(){
		PageUtils.click(driver, decisionInfoBoxYes, "Przycisk tak w komunikacie decyzji");
	}
	public void getInfoBoxAfterSave(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
	}
	
	public void searchForResult(String szukanaFraza){
		this.fillSearchField(szukanaFraza);
		this.clickSearchButton();
	}
	
	public void getInfoBoxAfterTryToDelete(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(decisionInfoBox));
	}
	public void getInfoBoxAfterDelete(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(infoBox));
	}
	public  void choseYes(){
		this.getInfoBoxAfterTryToDelete();
		this.clickYes();
	}
	
	public void addNewTestCase() {
		this.clickOpenButton();
		this.clickAddTestCase();
	}




}
