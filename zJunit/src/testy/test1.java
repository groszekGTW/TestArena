package testy;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import LoginPage.loginPage;
import Zadania.ZadaniaSection;
import Zadania.ZadaniaSzczegoly;
import Zadania.ZamykanieZadania;
import kokpit.menuGorne;
import kokpit.menuLewe;

public class test1 {
	protected WebDriver driver;

	loginPage lgp;
	menuGorne mg;
	menuLewe ml;
	ZadaniaSection zd;
	ZadaniaSzczegoly zs;
	ZamykanieZadania zz;
	 
	@Before	
	public void setup(){	 
	        driver = new FirefoxDriver();	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	 
	        driver.get("http://testarena.gpe.pl");
	 }
	 
	 @Test
	 public void test123() throws InterruptedException {
		 lgp = new loginPage(driver);
		 lgp.loginToArena("groszkowskimichal@gmail.com", "Gro3chu!");
		
		 ml = new menuLewe(driver);
		 ml.getZadania();
		 zd = new ZadaniaSection(driver);
		 zd.WybierzFiltrStatus("Nowe");
		 zd.kliknijPrzyciskFiltr();
		 zd.akcjeZamknij();
		 zz = new ZamykanieZadania(driver);
		 zz.zamknijZadanie("Powodzenie", "komentarz");
		 //asdasdasd

		 

		 //zd.WybierzFiltrWydanie("wyd1");
		

	 }

}
