package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageLogin {
	
	WebDriver driver;
	private By userField;
	private By passwordField;
	private By submitButton;
	private By fields;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		submitButton = By.name("submit");
		fields = By.tagName("input");
	}
	
	public void Login(String user, String password) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(submitButton).click();
		File myScreenshot= null;
		myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("LOGIN"+ System.currentTimeMillis()+".png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void field_login(String user, String pass) {
		List<WebElement> loginField = driver.findElements(fields);
		loginField.get(1).sendKeys(user);
		loginField.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void inputNumber() {
		List<WebElement> loginField = driver.findElements(fields);
		System.out.println("Numero de inputs: " + loginField.size());
		Assert.assertTrue(loginField.size()==4);
	}

}
