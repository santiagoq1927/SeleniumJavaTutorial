package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests {
	
	private WebDriver driver;
	ArrayList<String> tabs; 
	private Helpers help = new Helpers();
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		String googleWindow = "window.open('https://www.google.com')";
		javaScriptExecutor.executeScript(googleWindow);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		help.sleepSecond(5);
		
	}
	
	/*@Test
	public void pruebaUno() {
		PageLogin login = new PageLogin(driver);
		PageReservation reservation = new PageReservation(driver);
		login.Login("user1","user1");
		help.sleepSecond(5);
		reservation.assertPageLoginOk();
	}*/
	
	@Test
	public void LoginIncorrecto() {
		WebDriverManager.setWindowSize(driver, "maximized");
		driver.switchTo().window(tabs.get(1)).navigate().to("https://www.youtube.com");
		driver.switchTo().window(tabs.get(0));
		PageLogin login = new PageLogin(driver);
		PageLogon logon =  new PageLogon(driver);
		login.Login("algo","123");
		help.sleepSecond(5);
		logon.asserLogonPage();
		//esto es una linea de codigo de comentario
		
	}
	
	@Test
	public void fligthReservation() {
		WebDriverManager.setWindowSize(driver, "fullscreen");
		PageLogin login = new PageLogin(driver);
		PageReservation reservation = new PageReservation(driver);
		login.Login("user2","user2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//help.sleepSecond(5);
		reservation.assertPageLoginOk();
		reservation.enterReservationFlight();
		help.sleepSecond(6);
		reservation.assertPageReservation();
		reservation.selectPassengers(2);
		reservation.selectDepartingFrom(4);
		reservation.selectArrivingIn("London");
		help.sleepSecond(5);
	}
	
	@Test
	public void pruebaInputsNumber() {
		WebDriverManager.setWindowSize(driver,400,400);
		PageLogin login = new PageLogin(driver);
		login.inputNumber();
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()){
			Screenshooter.takeScreenshot("Error", driver);
		}
		driver.switchTo().window(tabs.get(1)).close();
		driver.switchTo().window(tabs.get(0)).close();
	}

}
