package pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends AbstractPage<MyAccountPage> {

	private Log log = LogFactory.getLog(MyAccountPage.class);

	@FindBy(css = "a.login")
	private WebElement loginLink;

	@FindBy(css = "div#center_column > p")
	private WebElement welcomeMessage;

	public MyAccountPage(final WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		log.info("Can't navigate to the resultspage directly");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		final String url = driver.getCurrentUrl();
		Assert.assertTrue(url.endsWith("?controller=my-account"));
	}

	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}

}
