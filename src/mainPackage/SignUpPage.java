package mainPackage;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpPage {
	WebDriver driver;
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver(); // == cy.
		driver.manage().window().maximize();
	}
	@Test(description = "Validate that the user can sign up successfully")
	public void signUpFunctionalty() {

	    driver.get("https://automationexercise.com/login");

	    // Enter Name
	    driver.findElement(By.name("name")).sendKeys("ToqaTest");

	    // Generate Random Email
	    Random randomNumber = new Random();
	    int index = randomNumber.nextInt(10000);
	    String email = "toqatest" + index + "@gmail.com";

	    // Enter Email
	    driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(email);

	    // Click Signup
	    driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

	    // Fill Account Information
	    driver.findElement(By.id("id_gender2")).click();
	    driver.findElement(By.id("password")).sendKeys("test@123");

	    // First Name
	    driver.findElement(By.id("first_name")).sendKeys("Toqa");

	    // Last Name
	    driver.findElement(By.id("last_name")).sendKeys("Abdeen");

	    // Address
	    driver.findElement(By.id("address1")).sendKeys("Nablus");

	    // Country
	    WebElement menu = driver.findElement(By.name("country"));
	    Select dropdown = new Select(menu);
	    dropdown.selectByVisibleText("Israel");

	    // State
	    driver.findElement(By.id("state")).sendKeys("Test");

	    // City
	    driver.findElement(By.id("city")).sendKeys("Nablus");

	    // Zipcode
	    driver.findElement(By.id("zipcode")).sendKeys("123455");

	    // Mobile Number
	    driver.findElement(By.id("mobile_number")).sendKeys("0597000000");

	    // Create Account
	    driver.findElement(By.cssSelector("[data-qa='create-account']")).click();

	    // Verify Account Created
	    String actualResult = driver.findElement(By.cssSelector("[data-qa='account-created']")).getText();

	    Assert.assertEquals(actualResult, "ACCOUNT CREATED!", "Text is not matching");
	}
	
	@AfterTest
	public void afterTeest() {
		driver.close();
	}

}
