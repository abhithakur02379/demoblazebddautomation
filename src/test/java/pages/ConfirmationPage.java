package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ConfirmationPage {
	WebDriver driver;
	
	By lbl_MsgConfirmation = By.xpath("//h2[.='Thank you for your purchase!']");
	By buttonOK = By.xpath("//button[text()='OK']");

	By listElements = By.xpath("//p[@class='lead text-muted ']");

	By buttonAddToCart = By.xpath("//a[text()='Add to cart']");


	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void confirmationText(String strExpectedResult, String amount, String name) {

		String[] stringArray;
		String s = driver.findElement(listElements).getText();
		stringArray = s.split("\n");
		Assert.assertTrue(stringArray[0].contains("Id"));
		String[] expectedAmount = stringArray[1].split(" ");
		Assert.assertEquals(amount, expectedAmount[1]);
		Assert.assertTrue(stringArray[3].contains(name));

		String msgConfirmation = driver.findElement(lbl_MsgConfirmation).getText();
		Assert.assertEquals(msgConfirmation, strExpectedResult);
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(buttonOK)).click();
	}

	public void errorMessage(String strExpectedResult) throws InterruptedException {

		String errorMessage = null;
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).ignoring(NoAlertPresentException.class)
				.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		errorMessage = driver.switchTo().alert().getText();
		alert.accept();
		driver.switchTo().defaultContent();

		Assert.assertEquals(errorMessage, strExpectedResult);
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(buttonOK)).click();
	}



}
