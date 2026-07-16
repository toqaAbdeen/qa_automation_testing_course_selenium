package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constant;

public class Assertions implements Constant {
	public void checkAccountIsCreated() {
		String actualResult = driver.findElement(By.cssSelector("[data-qa='account-created']")).getText();

		Assert.assertEquals(actualResult, "ACCOUNT CREATED!", "Text is not matching");	}

}
