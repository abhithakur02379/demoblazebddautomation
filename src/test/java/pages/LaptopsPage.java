package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LaptopsPage {
	WebDriver driver;

	public LaptopsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectPro(String laptop) {

		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+laptop+"']")));
		driver.findElement(By.xpath("//a[text()='" + laptop + "']")).click();
	}
}