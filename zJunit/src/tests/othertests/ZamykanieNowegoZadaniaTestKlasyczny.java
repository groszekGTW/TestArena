package tests.othertests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ZamykanieNowegoZadaniaTestKlasyczny {
	
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
 
        driver.get("http://testarena.gpe.pl");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement username = driver.findElement(By.id("email"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		username.isEnabled();
		System.out.println("Pole adres e-mail jest dostêpne");
		username.sendKeys("groszkowskimichal@gmail.com");
        
		WebElement Password = driver.findElement(By.id("password"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    Password.isEnabled();
		System.out.println("Pole has³o jest dostêpne");
	    Password.sendKeys("Gro3chu!");
	    
	    WebElement Login = driver.findElement(By.id("login"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    Login.isEnabled();
		System.out.println("Pole zaloguj jest dostêpne");
	    Login.click();
	    
	    String Expected = driver.findElement(By.xpath("//span[@class='user-info']/small")).getText();		 
		Assert.assertEquals(Expected, "groszkowskimichal@gmail.com");
		
	    WebElement otworzMenuZadania = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/tasks']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://testarena.gpe.pl/tasks']")));
	    otworzMenuZadania.isEnabled();
		System.out.println("Sekcja zadania lewego panelu nawigacji jest dostêpna");
	    otworzMenuZadania.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='content_title']")));
	    String Expected1=driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		Assert.assertEquals(Expected1, "Zadania");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='status']")));
	    WebElement filtrStatus = driver.findElement(By.xpath("//select[@id='status']"));
		filtrStatus.isEnabled();
		System.out.println("Pole filtr status jest dostêpne");
		WebElement element = driver.findElement(By.xpath("//select[@id='status']")); 
		Select dropDown = new Select(element); 
		dropDown.selectByVisibleText("Nowe");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='priority']")));
		WebElement filtrPriorytet = driver.findElement(By.xpath("//select[@id='priority']"));
		filtrPriorytet.isEnabled();
		System.out.println("Pole filtr priorytet jest dostêpne");
		WebElement element1 = driver.findElement(By.xpath("//select[@id='priority']")); 
		Select dropDown1 = new Select(element1); 
		dropDown1.selectByVisibleText("Krytyczny");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assigner']")));
		WebElement filtrPrzydzielil = driver.findElement(By.xpath("//select[@id='assigner']"));
		filtrPrzydzielil.isEnabled();
		System.out.println("Pole filtr przydzieli³ jest dostêpne");
		WebElement element2 = driver.findElement(By.xpath("//select[@id='assigner']")); 
		Select dropDown2 = new Select(element2); 
		dropDown2.selectByVisibleText("Micha³ Groszkowski");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assignee']")));
		WebElement filtrPrzydzieloneDo = driver.findElement(By.xpath("//select[@id='assignee']"));
		filtrPrzydzieloneDo.isEnabled();
		System.out.println("Pole filtr przydzielone do jest dostêpne");
		WebElement element3 = driver.findElement(By.xpath("//select[@id='assignee']")); 
		Select dropDown3 = new Select(element3); 
		dropDown3.selectByVisibleText("Micha³ Groszkowski");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='environment']")));
		WebElement filtrSrodowisko = driver.findElement(By.xpath("//select[@id='environment']"));
		filtrSrodowisko.isEnabled();
		System.out.println("Pole filtr œrodowisko jest dostêpne");
		WebElement element4 = driver.findElement(By.xpath("//select[@id='environment']")); 
		Select dropDown4 = new Select(element4); 
		dropDown4.selectByVisibleText("Nowe srodowisko");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='resultCountPerPage']")));
		WebElement filtrWynik = driver.findElement(By.xpath("//select[@id='resultCountPerPage']"));
		filtrWynik.isEnabled();
		System.out.println("Pole filtr wynik jest dostêpne");
		WebElement element5 = driver.findElement(By.xpath("//select[@id='resultCountPerPage']")); 
		Select dropDown5 = new Select(element5); 
		dropDown5.selectByVisibleText("10");

		WebElement przyciskFiltr = driver.findElement(By.xpath("//button[@id='j_filterButton']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_filterButton']")));
	    przyciskFiltr.isEnabled();
		System.out.println("Pole filtruj jest dostêpne");
		przyciskFiltr.click();
		
		WebElement dodajZadanie = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/task_add']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://testarena.gpe.pl/task_add']")));
		dodajZadanie.isEnabled();
		System.out.println("Pole dodaj zadanie jest dostêpne");
		dodajZadanie.click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("token-input-environments")));
		WebElement srodowiska = driver.findElement(By.id("token-input-environments"));
		srodowiska.isEnabled();
		System.out.println("Pole srodowiska jest dostêpne");
		srodowiska.sendKeys("Nowe srodowisko");
		Thread.sleep(2000);
		srodowiska.sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("releaseName")));
		WebElement wydanie = driver.findElement(By.id("releaseName"));
		wydanie.isEnabled();
		System.out.println("Pole wydanie jest dostêpne");
		wydanie.sendKeys("wyd1");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("token-input-versions")));
		WebElement wersje = driver.findElement(By.id("token-input-versions"));
		wersje.isEnabled();
		System.out.println("Pole wersje jest dostêpne");
		wersje.sendKeys("nowa wersja");
		Thread.sleep(2000);
		wersje.sendKeys(Keys.ENTER);	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priority")));
		WebElement priorytet = driver.findElement(By.id("priority"));
		priorytet.isEnabled();
		System.out.println("Pole priorytet jest dostêpne");
		WebElement element6 = driver.findElement(By.id("priority")); 
		Select dropDown6 = new Select(element6); 
		dropDown6.selectByVisibleText("Krytyczny");
		
		WebElement terminRealizacjiPole = driver.findElement(By.id("dueDate"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dueDate")));
		terminRealizacjiPole.isEnabled();
		System.out.println("Pole terminRealizacji jest dostêpne");
		terminRealizacjiPole.sendKeys("2018-08-23 23:59");
		terminRealizacjiPole.sendKeys(Keys.ENTER);
		
		WebElement tytulWidoku = driver.findElement(By.xpath("//h1[@class='content_title']"));
		WebElement przypiszDo = driver.findElement(By.id("assigneeName"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assigneeName")));
		przypiszDo.isEnabled();
		System.out.println("Pole przypisz do jest dostêpne");
		przypiszDo.sendKeys("Mi");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ui-menu-item']")));
		WebElement przypiszDoKtos = driver.findElement(By.xpath("//li[@class='ui-menu-item']"));
		przypiszDoKtos.isEnabled();
		System.out.println("Lista osób do przypisania jest dostêpna");
		przypiszDoKtos.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='content_title']")));
		tytulWidoku.click();
		
		WebElement tytul = driver.findElement(By.id("title"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
		tytul.isEnabled();
		System.out.println("Pole tytu³ jest dostêpne");
		tytul.sendKeys("tytul");
		
		WebElement opis = driver.findElement(By.id("description"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
		opis.isEnabled();
		System.out.println("Pole opis jest dostêpne");
		opis.sendKeys("opis");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='content_title']")));
		tytulWidoku.click();
		
		WebElement zapisz = driver.findElement(By.id("save"));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("save"))));
		zapisz.isEnabled();
		System.out.println("Pole zapisz jest dostêpne");
		zapisz.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_info_box")));
		String Expected2=driver.findElement(By.id("j_info_box")).getText();
		Assert.assertEquals(Expected2, "Zadanie zosta³o dodane.");
		
/////////////////////////////////////////////////		

		WebElement otworzMenuZadania1 = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/tasks']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://testarena.gpe.pl/tasks']")));
	    otworzMenuZadania1.isEnabled();
		System.out.println("Sekcja zadania lewego panelu nawigacji jest dostêpna");
	    otworzMenuZadania1.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='content_title']")));
	    String Expected11=driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		Assert.assertEquals(Expected11, "Zadania");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='status']")));
	    WebElement filtrStatus1 = driver.findElement(By.xpath("//select[@id='status']"));
		filtrStatus1.isEnabled();
		System.out.println("Pole filtr status jest dostêpne");
		WebElement element01 = driver.findElement(By.xpath("//select[@id='status']")); 
		Select dropDown01 = new Select(element01); 
		dropDown01.selectByVisibleText("Nowe");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='priority']")));
		WebElement filtrPriorytet1 = driver.findElement(By.xpath("//select[@id='priority']"));
		filtrPriorytet1.isEnabled();
		System.out.println("Pole filtr priorytet jest dostêpne");
		WebElement element11 = driver.findElement(By.xpath("//select[@id='priority']")); 
		Select dropDown11 = new Select(element11); 
		dropDown11.selectByVisibleText("Krytyczny");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assigner']")));
		WebElement filtrPrzydzielil1 = driver.findElement(By.xpath("//select[@id='assigner']"));
		filtrPrzydzielil1.isEnabled();
		System.out.println("Pole filtr przydzieli³ jest dostêpne");
		WebElement element21 = driver.findElement(By.xpath("//select[@id='assigner']")); 
		Select dropDown21 = new Select(element21); 
		dropDown21.selectByVisibleText("Micha³ Groszkowski");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assignee']")));
		WebElement filtrPrzydzieloneDo1 = driver.findElement(By.xpath("//select[@id='assignee']"));
		filtrPrzydzieloneDo1.isEnabled();
		System.out.println("Pole filtr przydzielone do jest dostêpne");
		WebElement element31 = driver.findElement(By.xpath("//select[@id='assignee']")); 
		Select dropDown31 = new Select(element31); 
		dropDown31.selectByVisibleText("Micha³ Groszkowski");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='environment']")));
		WebElement filtrSrodowisko1 = driver.findElement(By.xpath("//select[@id='environment']"));
		filtrSrodowisko1.isEnabled();
		System.out.println("Pole filtr œrodowisko jest dostêpne");
		WebElement element41 = driver.findElement(By.xpath("//select[@id='environment']")); 
		Select dropDown41 = new Select(element41); 
		dropDown41.selectByVisibleText("Nowe srodowisko");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='resultCountPerPage']")));
		WebElement filtrWynik1 = driver.findElement(By.xpath("//select[@id='resultCountPerPage']"));
		filtrWynik1.isEnabled();
		System.out.println("Pole filtr wynik jest dostêpne");
		WebElement element51 = driver.findElement(By.xpath("//select[@id='resultCountPerPage']")); 
		Select dropDown51 = new Select(element51); 
		dropDown51.selectByVisibleText("10");

		WebElement przyciskFiltr1 = driver.findElement(By.xpath("//button[@id='j_filterButton']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_filterButton']")));
	    przyciskFiltr1.isEnabled();
		System.out.println("Pole filtruj jest dostêpne");
		przyciskFiltr1.click();
				
////////////////////////////////////////////////
		WebElement akcjeLista = driver.findElement(By.id("action_icon"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action_icon")));
		akcjeLista.isEnabled();
		System.out.println("Pole akcji jest dostêpne");
		akcjeLista.click();
		Thread.sleep(2000);
		WebElement akcjeListaZamknij = driver.findElement(By.xpath("//a[contains(.,'Zamknij')]"));
		akcjeListaZamknij.isEnabled();
		System.out.println("Akcja zamknij jest dostêpna");
		akcjeListaZamknij.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resolutionId")));
		WebElement StatusRozwiazaniaLista =	driver.findElement(By.id("resolutionId"));
		StatusRozwiazaniaLista.isEnabled();
		System.out.println("Pole Status rozwiazania jest dostêpne");
		WebElement element61 = driver.findElement(By.id("resolutionId")); 
		Select dropDown61 = new Select(element61); 
		dropDown61.selectByVisibleText("Powodzenie");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//textarea[@id='comment']")));
		WebElement komentarzPole = driver.findElement(By.xpath("//textarea[@id='comment']"));
		komentarzPole.isEnabled();
		System.out.println("Pole komentarz jest dostêpne");
		komentarzPole.sendKeys("komentarz");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='close']")));
		WebElement zamknij = driver.findElement(By.xpath("//input[@id='close']"));
		zamknij.isEnabled();
		System.out.println("Pole zamknij jest dostêpne");
		zamknij.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("j_info_box"))));
		String Expected3=driver.findElement(By.id("j_info_box")).getText();
		Assert.assertEquals(Expected3, "Zadanie zosta³o zamkniête.");
		
		
//////////////////////////////////////////
		
		WebElement otworzMenuZadania11 = driver.findElement(By.xpath("//a[@href='http://testarena.gpe.pl/tasks']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://testarena.gpe.pl/tasks']")));
	    otworzMenuZadania11.isEnabled();
		System.out.println("Sekcja zadania lewego panelu nawigacji jest dostêpna");
	    otworzMenuZadania11.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='content_title']")));
	    String Expected111=driver.findElement(By.xpath("//h1[@class='content_title']")).getText();		 
		Assert.assertEquals(Expected111, "Zadania");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='status']")));
	    WebElement filtrStatus11 = driver.findElement(By.xpath("//select[@id='status']"));
		filtrStatus11.isEnabled();
		System.out.println("Pole filtr status jest dostêpne");
		WebElement element011 = driver.findElement(By.xpath("//select[@id='status']")); 
		Select dropDown011 = new Select(element011); 
		dropDown011.selectByVisibleText("Nowe");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='priority']")));
		WebElement filtrPriorytet11 = driver.findElement(By.xpath("//select[@id='priority']"));
		filtrPriorytet11.isEnabled();
		System.out.println("Pole filtr priorytet jest dostêpne");
		WebElement element111 = driver.findElement(By.xpath("//select[@id='priority']")); 
		Select dropDown111 = new Select(element111); 
		dropDown111.selectByVisibleText("Krytyczny");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assigner']")));
		WebElement filtrPrzydzielil11 = driver.findElement(By.xpath("//select[@id='assigner']"));
		filtrPrzydzielil11.isEnabled();
		System.out.println("Pole filtr przydzieli³ jest dostêpne");
		WebElement element211 = driver.findElement(By.xpath("//select[@id='assigner']")); 
		Select dropDown211 = new Select(element211); 
		dropDown211.selectByVisibleText("Micha³ Groszkowski");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assignee']")));
		WebElement filtrPrzydzieloneDo11 = driver.findElement(By.xpath("//select[@id='assignee']"));
		filtrPrzydzieloneDo11.isEnabled();
		System.out.println("Pole filtr przydzielone do jest dostêpne");
		WebElement element311 = driver.findElement(By.xpath("//select[@id='assignee']")); 
		Select dropDown311 = new Select(element311); 
		dropDown311.selectByVisibleText("Micha³ Groszkowski");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='environment']")));
		WebElement filtrSrodowisko11 = driver.findElement(By.xpath("//select[@id='environment']"));
		filtrSrodowisko11.isEnabled();
		System.out.println("Pole filtr œrodowisko jest dostêpne");
		WebElement element411 = driver.findElement(By.xpath("//select[@id='environment']")); 
		Select dropDown411 = new Select(element411); 
		dropDown411.selectByVisibleText("Nowe srodowisko");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='resultCountPerPage']")));
		WebElement filtrWynik11 = driver.findElement(By.xpath("//select[@id='resultCountPerPage']"));
		filtrWynik11.isEnabled();
		System.out.println("Pole filtr wynik jest dostêpne");
		WebElement element511 = driver.findElement(By.xpath("//select[@id='resultCountPerPage']")); 
		Select dropDown511 = new Select(element511); 
		dropDown511.selectByVisibleText("10");

		WebElement przyciskFiltr11 = driver.findElement(By.xpath("//button[@id='j_filterButton']"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_filterButton']")));
	    przyciskFiltr11.isEnabled();
		System.out.println("Pole filtruj jest dostêpne");
		przyciskFiltr11.click();
		

  
	    }

	
}
