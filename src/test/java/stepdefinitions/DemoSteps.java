package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

public class DemoSteps {
	
	WebDriver driver=null;
	String actualAmount;

	@Given("I want to place an order to buy a laptop in {string}")
	public void i_want_to_place_an_order_to_buy_a_laptop_in(String strUrl) {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.addArguments("start-maximized");
		driver=new ChromeDriver(chromeOptions);
		driver.navigate().to(strUrl);
		  
	}

	@When("I look my laptop {string} in Laptops section")
	public void i_look_my_laptop_in_laptops_section(String strMac) {
		HomePage home = new HomePage(driver);
		home.laptopsCategory();
		LaptopsPage laptops = new LaptopsPage(driver);
		laptops.selectPro(strMac);
		SummaryPage summary = new SummaryPage(driver);
		actualAmount = summary.addToCart();
		MenuPage optmenu = new MenuPage(driver);
		optmenu.cartOption();
		PlacePage place = new PlacePage(driver);
		place.placeOrder();
		
	}

	@When("I fill the user details {string} {string} {string} {string} {string} {string}")
	public void fillUserDetails(String strName, String strCountry, String strCity, String strCard, String strMonth, String strYear) {
		OrderFormPlace orderForm = new OrderFormPlace(driver);
		orderForm.formDetails(strName, strCountry, strCity, strCard, strMonth, strYear);
	}

	@When("I fill incomplete user details {string} {string} {string}")
	public void fillIncompleteUserDetails(String strName, String strCountry, String strCity) throws InterruptedException {
		OrderFormPlace orderForm = new OrderFormPlace(driver);
		orderForm.incompleteFormDetails(strName, strCountry, strCity);
	}

	@Then("I verify the {string} {string} of my order")
	public void i_verify_the_of_my_order(String strExpectedResult, String name) {
		ConfirmationPage confirmation = new ConfirmationPage(driver);
		confirmation.confirmationText(strExpectedResult, actualAmount, name);
		driver.quit();

	}

	@Then("I verify that error message {string} is displayed")
	public void verify_i_get_error_message(String strExpectedResult) {
		ConfirmationPage confirmation = new ConfirmationPage(driver);
		confirmation.errorMessage(strExpectedResult);
		driver.quit();

	}
}
