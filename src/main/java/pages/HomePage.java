package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends AbstractPage<HomePage> {

	@FindBy(css = "a.login")
	private WebElement loginLink;

	@FindBy(css = "input#search_query_top")
	private WebElement searchTextfield;

	@FindBy(css = "button[name='submit_search']")
	private WebElement searchButton;

	public HomePage(final WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		// Open the page
		driver.get("http://demo.selenium-in-action.io/index.php");
	}

	@Override
	protected void isLoaded() throws Error {
		// verify if the correct page is open
		Assert.assertTrue(driver.getTitle().equals("FashionShop"));
	}

	public AuthenticationPage clickOnLogin() {
		loginLink.click();
		return new AuthenticationPage(driver);
	}

	public SearchResultsPage searchFor(final String query) {
		searchTextfield.sendKeys(query);
		searchButton.click();
		return new SearchResultsPage(driver);
	}

}
