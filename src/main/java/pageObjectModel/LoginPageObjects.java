package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	public WebDriver driver;
	private By login = By.xpath("//a[text()='Login']");

	private By Email = By.xpath("//input[@id='input-email']");

	private By password = By.xpath("//input[@id='input-password']");

	private By SubmitButton = By.xpath("//input[@value='Login']");
	
	private By MyaccountActual = By.xpath("//h2[text()='My Account']");
	
	private By actual = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

	public LoginPageObjects(WebDriver driver2) {
		this.driver = driver2;
	}

	// methods for locators
	
	public WebElement clickOnLogin() {

		return driver.findElement(login);

	}
	public WebElement clickOnEmail() {

		return driver.findElement(Email);

	}

	public WebElement clickOnPassword() {

		return driver.findElement(password);

	}

	public WebElement clickOnSubmit() {

		return driver.findElement(SubmitButton);

	}
	public WebElement MyAccountActualText() {

		return driver.findElement(MyaccountActual);

	}
	public WebElement actualWarningText() {

		return driver.findElement(actual);

	}
}
