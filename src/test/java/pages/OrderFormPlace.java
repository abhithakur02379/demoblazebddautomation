package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormPlace {
	WebDriver driver;
	
	By lbl_name = By.id("name");
	By lbl_country = By.id("country");
	By lbl_city = By.id("city");
	By lbl_creditcard = By.id("card");
	By lbl_month = By.id("month");
	By lbl_year = By.id("year");
	By btn_purchase = By.xpath("//button[.='Purchase']");
	
	public OrderFormPlace(WebDriver driver) {
		this.driver = driver;
	}

	public void formDetails(String strName, String strCountry, String strCity, String strCard, String strMonth, String strYear) {

		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(btn_purchase));
		driver.findElement(lbl_name).sendKeys(strName);
		driver.findElement(lbl_country).sendKeys(strCountry);
		driver.findElement(lbl_city).sendKeys(strCity);
		driver.findElement(lbl_creditcard).sendKeys(strCard);
		driver.findElement(lbl_month).sendKeys(strMonth);
		driver.findElement(lbl_year).sendKeys(strYear);
		driver.findElement(btn_purchase).click();
	}

	public void incompleteFormDetails(String strName,String strCountry, String strCity) throws InterruptedException {

		new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(btn_purchase));
		driver.findElement(lbl_name).sendKeys(strName);
		driver.findElement(lbl_country).sendKeys(strCountry);
		driver.findElement(lbl_city).sendKeys(strCity);
		driver.findElement(btn_purchase).click();
		Thread.sleep(5000);
	}
}
