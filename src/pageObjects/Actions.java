package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.Constant;

public class Actions implements Constant {
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

}