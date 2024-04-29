package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPageObjects;
import pageObjectModel.RegistrationPageObjects;
import resources.BaseClass;
import resources.Constant;
import resources.commonMethods;

public class VerifyLoginTestCase extends BaseClass {

	@Test
	public void verifyLoginithValidData() throws IOException, InterruptedException {

		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.clickOnMyAccount().click();

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.clickOnLogin().click();

		lpo.clickOnEmail().sendKeys(email);
		Thread.sleep(4000);
		lpo.clickOnPassword().sendKeys(Constant.password);
		lpo.clickOnSubmit().click();

		SoftAssert sa = new SoftAssert();

		String actual = lpo.MyAccountActualText().getText();
		String expected = "My Account";
		sa.assertEquals(actual, expected);
		sa.assertAll();

	}

	@Test
	public void verifyLoginithInValidData() throws IOException, InterruptedException {

		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.clickOnMyAccount().click();

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.clickOnLogin().click();

		lpo.clickOnEmail().sendKeys(email);
		
		commonMethods.implicitelywaits(driver, 2, lpo.clickOnPassword());
		lpo.clickOnPassword().sendKeys(Constant.invalidPassword);
		lpo.clickOnSubmit().click();

	/*	SoftAssert sa = new SoftAssert();

		String actual = lpo.actualWarningText().getText();
		String expected = Constant.expectedWarningText;

		sa.assertEquals(actual, expected);
		sa.assertAll();
         */
		
		//using assertion by common method
		commonMethods.handleAssertion(lpo.actualWarningText().getText(), Constant.expectedWarningText);
	}

}
