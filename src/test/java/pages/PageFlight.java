package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFlight {
	
	WebDriver driver;
	
	public PageFlight(WebDriver driver) {
		this.driver = driver;
	}

	public void enterReservationFlight() {
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")).click();
	}
}
