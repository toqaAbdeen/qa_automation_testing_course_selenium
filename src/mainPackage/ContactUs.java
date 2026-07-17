package mainPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;
import support.Constant;

public class ContactUs extends Actions implements Constant {
	Assertions assertions = new Assertions();

	@BeforeTest
	public void setup() {
		maximizeBrowser();
	}
	
	@Test(description = "Validate that the user can contact the organization")
	public void contactUsFunctionality() {
		openContactUsPage();
		typeInMandatoryField("name", "Toqa"); 
		typeInMandatoryField("email","ToqaTest@test.com");
		typeInMandatoryField("subject", "Testing only");
		typeInMandatoryField("message", "Hello this is test");
		clickOnSubmitButtonInContactUsForm();
		assertions.checkMessageBarIsContain();
		
		
	}
	
	@AfterTest
	public void afterTest() {
		closeBrowser();
	}
}
