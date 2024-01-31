package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	
WebDriver driver;
	
	By menuCart = By.xpath("//a[text()='Cart']");
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void cartOption() {
		driver.findElement(menuCart).click();
	}

}
