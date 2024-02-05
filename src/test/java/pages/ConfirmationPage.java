package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ConfirmationPage {
	WebDriver driver;
	
	By lbl_MsgConfirmation = By.xpath("//h2[.='Thank you for your purchase!']");
	By buttonOK = By.xpath("//button[text()='OK']");

	By listElements = By.xpath("//p[@class='lead text-muted ']");


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
		new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(buttonOK)).click();
	}

	public void errorMessage(String strExpectedResult) {

		String errorMessage;
		new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		errorMessage = driver.switchTo().alert().getText();
		alert.accept();
		Assert.assertEquals(errorMessage, strExpectedResult);

	}



}
