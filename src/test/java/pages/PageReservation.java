package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {
	
	WebDriver driver;
	private By titlePageHome;
	private By linkReservation;
	private By titleReservacion;
	
	
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		titlePageHome = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");
		linkReservation = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
		titleReservacion = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		
	}
	
	public void assertPageLoginOk() {
		Assert.assertTrue(driver.findElement(titlePageHome).getText().contains("Login Successfully"));
		
	}
	
	public void assertPageReservation() {
		Assert.assertTrue(driver.findElement(titleReservacion).getText().contains("Flight Finder to search"));
		
	}
	
	public void enterReservationFlight() {
		driver.findElement(linkReservation).click();	
	}
	
	public void selectPassengers(int cantidad) {
		//WebDriverWait wait  = new WebDriverWait(driver,10);
		
		Select selectPass = new Select(driver.findElement(By.name("passCount")));
		selectPass.selectByVisibleText(Integer.toString(cantidad));
		
	}
	
	public void selectDepartingFrom(int index) {
		Select selectFrom = new Select(driver.findElement(By.name("fromPort")));
		selectFrom.selectByIndex(index);
	}
	
	public void selectArrivingIn(String value) {
		Select selectIn = new Select(driver.findElement(By.name("toPort")));
		selectIn.selectByValue(value);
	}
	

}
