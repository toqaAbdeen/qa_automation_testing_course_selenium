package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import support.Constant;

public class Assertions implements Constant {
	public void checkAccountIsCreated() {
		String actualResult = driver.findElement(By.cssSelector("[data-qa='account-created']")).getText();

		Assert.assertEquals(actualResult, "ACCOUNT CREATED!", "Text is not matching");
		Assert.assertTrue("test" == "test", "This is not equal");
		Assert.assertTrue(true, "This is not equal");

	}

	public void checkMessageBarIsContain() {
		String message = driver.findElement(By.className("alert-success")).getText();
		Assert.assertEquals(message, "Success! Your details have been submitted successfully.", "Text is not matching");
	}
	
	// PROJECT

	public void checkProductDetailsPageIsDisplayed() {

		String actualTitle = driver.findElement(By.cssSelector(".product-information h2")).getText();

		Assert.assertFalse(actualTitle.isEmpty(), "Product details page is not displayed");

	}

	public void checkQuantityIsUpdated() {

		String quantity = driver.findElement(By.id("quantity")).getAttribute("value");

		Assert.assertEquals(quantity, "2", "Product quantity is not updated to 2");

	}

	public void checkProductAddedToCart() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));

		Assert.assertTrue(modal.isDisplayed(), "Add to cart modal is not displayed");

		Assert.assertTrue(driver.findElement(By.xpath("//u[text()='View Cart']")).isDisplayed(),
				"View Cart is not displayed");

	}

	public void checkOrderConfirmationMessage() {

		String message = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();

		Assert.assertEquals(message, "Congratulations! Your order has been confirmed!",
				"Order confirmation message is not matching");

	}

	public void checkCartPageIsDisplayed() {

		String url = driver.getCurrentUrl();

		Assert.assertTrue(url.contains("view_cart"), "Cart page is not displayed");

	}

	public void checkCheckoutPageIsDisplayed() {

		boolean checkoutText = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed();

		Assert.assertTrue(checkoutText, "Checkout page is not displayed");

	}
}
