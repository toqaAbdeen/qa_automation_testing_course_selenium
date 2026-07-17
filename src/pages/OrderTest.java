package pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;

public class OrderTest extends Actions {

	Assertions assertions = new Assertions();

	@BeforeSuite
	public void setup() {
		maximizeBrowser();
	}

	@Test(description = "Validate user can add product with quantity 2")
	public void productsFunctionality() {

		visitAutomationexerciseWebsite();

		typeLoginEmail("abdeentoqa97@gmail.com");

		typeLoginPassword("12345678");

		clickLoginButton();
		visitAutomationexerciseProductPage();

		selectRandomProduct();

		assertions.checkProductDetailsPageIsDisplayed();

		changeProductQuantity(2);

		assertions.checkQuantityIsUpdated();

		clickAddToCart();

		assertions.checkProductAddedToCart();

		clickViewCart();

		assertions.checkCartPageIsDisplayed();

		clickProceedToCheckout();

		assertions.checkCheckoutPageIsDisplayed();
		clickPlaceOrder();

		fillPaymentData();

		clickPayButton();

		assertions.checkOrderConfirmationMessage();

	}

	@AfterSuite
	public void afterTest() {
//		closeBrowser();
	}

}