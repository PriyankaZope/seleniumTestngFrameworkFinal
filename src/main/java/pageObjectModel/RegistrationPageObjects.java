package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObjects {
	public WebDriver driver;

	// will store locators hereccount
	private By myAccount = By.xpath("//a[@title='My Account']");
	
	private By register = By.xpath("//a[text()='Register']");

	private By firstName = By.xpath("//input[@id='input-firstname']");

	private By lastName = By.xpath("//input[@id='input-lastname']");

	private By email = By.xpath("//input[@id='input-email']");

	private By telephone = By.xpath("//input[@id='input-telephone']");

	private By password = By.xpath("//input[@id='input-password']");

	private By confirmPassword = By.xpath("//input[@id='input-confirm']");

	private By checkbox = By.xpath("//input[@name='agree']");

	private By continueButton = By.xpath("//input[@value='Continue']");
	
	private By actual=By.xpath("//h1[text()='Your Account Has Been Created!']");

	public RegistrationPageObjects(WebDriver driver2) {
		this.driver= driver2;
	}

	// methods for locators
	public WebElement clickOnMyAccount() {

		return driver.findElement(myAccount);

	}

	public WebElement clickOnRegister() {

		return driver.findElement(register);

	}

	public WebElement clickOnFirstName() {

		return driver.findElement(firstName);

	}

	public WebElement clickOnLastName() {

		return driver.findElement(lastName);

	}

	public WebElement clickOnEmail() {

		return driver.findElement(email);

	}

	public WebElement clickOnTelephone() {

		return driver.findElement(telephone);

	}

	public WebElement clickOnPassword() {

		return driver.findElement(password);

	}

	public WebElement clickOnPasswordConfirm() {

		return driver.findElement(confirmPassword);

	}

	public WebElement clickOnCheckbox() {

		return driver.findElement(checkbox);

	}

	public WebElement clickOnContinue() {

		return driver.findElement(continueButton);

	}
	public WebElement actualText() {

		return driver.findElement(actual);

	}
}
