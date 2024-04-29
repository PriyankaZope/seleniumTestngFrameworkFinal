package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.RegistrationPageObjects;
import resources.BaseClass;
import resources.Constant;
import resources.commonMethods;

public class VerifyRegistrationTestcase extends BaseClass {

	@Test
	public void verifyRegistrationWithValidData () throws IOException {
		
		
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		
		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.clickOnFirstName().sendKeys(Constant.firstname);
		rpo.clickOnLastName().sendKeys(Constant.lastname);
		rpo.clickOnEmail().sendKeys(email);
		
		//using implicit wait by common method
		commonMethods.implicitelywaits(driver, 2, rpo.clickOnTelephone());
		
		rpo.clickOnTelephone().sendKeys(Constant.phone);	
		rpo.clickOnPassword().sendKeys(Constant.password);
		rpo.clickOnPasswordConfirm().sendKeys(Constant.confirmpassword);
		rpo.clickOnCheckbox().click();
		rpo.clickOnContinue().click();
		
		SoftAssert sa = new SoftAssert();
		
		String actual ="";
				String expected = "Your Account Has Been Created!";
		sa.assertEquals(false, false);
	}
	
	@Test
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {

	

		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);

		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.clickOnContinue().click();

		SoftAssert sa = new SoftAssert();

		String fnActual = driver
				.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
		String fnExpected = "First Name must be between 1 and 32 characters!";

		String lnActual = driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']"))
				.getText();
		String lnExpected = "Last Name must be between 1 and 32 characters!";

		sa.assertEquals(fnActual, fnExpected);

		sa.assertEquals(lnActual, lnExpected);
		sa.assertAll();

	}

}
	
	
	
	
	
	
	
	

