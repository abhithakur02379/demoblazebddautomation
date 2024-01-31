package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlacePage {
	WebDriver driver;
	
	By buttonPlaceOrder = By.xpath("//button[text()='Place Order']");
	
	public PlacePage(WebDriver driver) {
		this.driver = driver;
	}

	public void placeOrder() {
		driver.findElement(buttonPlaceOrder).click();
	}
}
