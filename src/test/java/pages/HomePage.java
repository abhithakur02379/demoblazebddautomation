package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	By labelLaptops = By.xpath("//a[text()='Laptops']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void laptopsCategory() {
		driver.findElement(labelLaptops).click();
	}
}