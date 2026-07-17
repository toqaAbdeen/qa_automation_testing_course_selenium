package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constant;

public class Assertions implements Constant {
	public void checkAccountIsCreated() {
		String actualResult = driver.findElement(By.cssSelector("[data-qa='account-created']")).getText();

		Assert.assertEquals(actualResult, "ACCOUNT CREATED!", "Text is not matching");
		Assert.assertTrue("test" == "test","This is not equal");
		Assert.assertTrue(true,"This is not equal");

	 }

	public void checkMessageBarIsContain() {
		String message = driver.findElement(By.className("alert-success")).getText();
		Assert. assertEquals(message, "Success! Your details have been submitted successfully.", "Text is not matching");
	}
}
