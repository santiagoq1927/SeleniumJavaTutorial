package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {
	
	WebDriver driver;
	private By tittlePage;
	
	public PageLogon(WebDriver driver) {
		this.driver = driver;
		tittlePage = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/span");
	}
	
	public void asserLogonPage() {
		Assert.assertTrue(driver.findElement(tittlePage).getText().contains("Enter your userName and password correct"));
	}

}
