package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Constant;

public class Actions implements Constant {

	WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

	public void visitAutomationexerciseWebsite() {
		driver.get("https://automationexercise.com/login");
	}

	public void typeUserName(String name) {
		driver.findElement(By.name("name")).sendKeys(name);
	}

	public void typeEmailInputField() {
		driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(generateRandomEmail());
	}

	public String generateRandomEmail() {
		Random randomNumber = new Random();
		int index = randomNumber.nextInt(10000);
		String email = "toqatest" + index + "@gmail.com";
		return email;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void clickOnSignUpButton() {
		driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

	}

	public void selectGender() {
		driver.findElement(By.id("id_gender2")).click();
	}

	public void typeInMandatoryField(String DataQA, String Value) {
		driver.findElement(By.cssSelector("[data-qa=" + DataQA + "]")).sendKeys(Value);
	}

	public void selectCountry(String country) {
		WebElement menu = driver.findElement(By.name("country"));
		Select dropdown = new Select(menu);
		dropdown.selectByVisibleText(country);
	}

	public void clickOnCreateAccountButton() {
		driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
	}

	public void closeBrowser() {
		driver.close();
	}

	// contact us

	public void openContactUsPage() {
		driver.get("https://automationexercise.com/contact_us");
	}

	public void clickOnSubmitButtonInContactUsForm() {
		driver.findElement(By.cssSelector("[data-qa=submit-button]")).click();
		driver.switchTo().alert().accept();
	}

	// PROJECT

	public void visitAutomationexerciseProductPage() {
		driver.get("https://automationexercise.com/products");
	}

	public void selectRandomProduct() throws InterruptedException {

		// Go to Products page
		driver.findElement(By.cssSelector("a[href='/products']")).click();

		Thread.sleep(3000);

		// Get number of products
		List<WebElement> viewProducts = driver.findElements(By.cssSelector("a[href^='/product_details/']"));

		Random random = new Random();

		int index = random.nextInt(viewProducts.size());

		Thread.sleep(2000);

		// Get element again to avoid stale element
		viewProducts = driver.findElements(By.cssSelector("a[href^='/product_details/']"));

		viewProducts.get(index).click();
	}

	public void changeProductQuantity(int quantity) {

		WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity")));

		quantityField.clear();
		quantityField.sendKeys(String.valueOf(quantity));
	}

	public void clickAddToCart() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-default.cart")));

		addButton.click();
	}

	public void clickViewCart() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']"))).click();

	}

	public void clickProceedToCheckout() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".check_out"))).click();

	}

	public void clickPlaceOrder() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/payment']"))).click();

	}

	public void fillPaymentData() {

		driver.findElement(By.name("name_on_card")).sendKeys("Toqa");

		driver.findElement(By.name("card_number2")).sendKeys("123456789");

		driver.findElement(By.name("cvc")).sendKeys("100");

		driver.findElement(By.name("expiry_month")).sendKeys("12");

		driver.findElement(By.name("expiry_year")).sendKeys("2030");

	}

	public void clickPayButton() {

		driver.findElement(By.id("submit")).click();

	}

	public void clickPayAndConfirm() {

		driver.findElement(By.id("submit")).click();

	}

	public void clickLogin() {

		driver.findElement(By.cssSelector("a[href='/login']")).click();

	}

	public void typeLoginEmail(String email) {

		driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys(email);

	}

	public void typeLoginPassword(String password) {

		driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys(password);

	}

	public void clickLoginButton() {

		driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

	}

}