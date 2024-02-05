package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummaryPage {
	WebDriver driver;

	By buttonAddToCart = By.xpath("//a[text()='Add to cart']");
	By labelAmount = By.xpath("//small//parent::h3");
	
	public SummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public String addToCart() {
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(buttonAddToCart));
		String a = driver.findElement(labelAmount).getText();
		String[] b = a.split("[^a-zA-Z0-9]");
		String amount = b[1];
		driver.findElement(buttonAddToCart).click();
		new WebDriverWait(driver,Duration.ofSeconds(60)).ignoring(NoAlertPresentException.class)
        .until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		return amount;
	}

}

