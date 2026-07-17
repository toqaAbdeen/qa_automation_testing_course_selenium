package mainPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;

public class SignUpPage extends Actions {

	Assertions assertions = new Assertions();

	String username = "ToqaTest";

	@BeforeSuite
	public void setup() {
		maximizeBrowser();
	}

	@Test(description = "Validate that the user can sign up successfully")
	public void signUpFunctionalty() {

		// Navigate to website
		visitAutomationexerciseWebsite();

		// Wait setup
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Signup information
		typeUserName(username);
		typeEmailInputField();
		clickOnSignUpButton();

		// Account Information
		selectGender();

		typeInMandatoryField("passwordd", "test@123");
		typeInMandatoryField("first_name", "Toqa");
		typeInMandatoryField("last_name", "Abdeen");
		typeInMandatoryField("address", "Nablus");

		selectCountry("Israel");

		typeInMandatoryField("state", "state");
		typeInMandatoryField("city", "Nablus");
		typeInMandatoryField("zipcode", "123455");
		typeInMandatoryField("mobile_number", "0597000000");

		// Create Account
		clickOnCreateAccountButton();

		/// static wait
		// Thread.sleep(1000);
		// Implicit wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Explicit wait
		// WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
		// driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
		// driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));

		assertions.checkAccountIsCreated();
	}

	@AfterSuite
	public void afterTest() {
		closeBrowser();
	}
}