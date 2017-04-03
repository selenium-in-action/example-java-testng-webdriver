package example;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTestBase {
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", findFileOnPath("drivers/mac/chromedriver")); // geckodriver
		// System.setProperty("webdriver.gecko.driver", findFileOnPath("drivers/mac/geckodriver")); // geckodriver
		driver = new ChromeDriver();

		// Open the website
		driver.get("http://www.demo.selenium-in-action.io/index.php");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

	private static String findFileOnPath(final String fileName) {
		return AbstractTestBase.class.getClassLoader().getResource(fileName).getPath();
	}
}
