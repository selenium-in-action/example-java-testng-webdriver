package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import types.SearchResult;

public class SearchResultsPage extends AbstractPage<SearchResultsPage> {

	private Log log = LogFactory.getLog(SearchResultsPage.class);

	@FindBy(css = "ul.product_list a.product-name")
	private List<WebElement> productNames;

	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li")
	private List<WebElement> productList;

	public SearchResultsPage(final WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		log.info("Can't navigate to the resultspage directly");
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(!driver.findElements(By.cssSelector("body#search")).isEmpty());
	}

	public List<String> getProductNames() {
		return productNames.stream().map(e -> e.getText()).collect(Collectors.toList());
	}

	public List<SearchResult> getResults() {
		return productList.stream().map(e -> new SearchResult(e)).collect(Collectors.toList());
	}

}
