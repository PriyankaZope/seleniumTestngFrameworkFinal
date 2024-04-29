package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	public static String email = generateRandomEmailID();

	public void driverInitialization() throws IOException {
		// Property file data reading
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HP\\eclipse-workspace\\SeleniumTestngFrameWork\\src\\main\\java\\data.properties");

		// Access data from property file
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edgedriver")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Please select valid driver name");
		}

	}

	private static String generateRandomEmailID() {
		return "abc" + System.currentTimeMillis() + "@gmail.com";

	}
	@BeforeMethod
	public void launchBrowserAndUrl() throws IOException {
		driverInitialization();
		driver.get(prop.getProperty("url"));
	}
}
