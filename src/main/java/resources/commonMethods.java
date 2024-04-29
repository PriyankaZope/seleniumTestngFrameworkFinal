package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class commonMethods {

	// common method for waits
	public static void implicitelywaits(WebDriver driver1, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// common methods for assert
	public static void handleAssertion(String actual, String expected) {
		SoftAssert sa = new SoftAssert();

		String actualText = actual;
		String expectedText = expected;

		sa.assertEquals(actualText, expectedText);

		sa.assertAll();
	}

}
