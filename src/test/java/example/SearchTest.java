package example;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsPage;

@Test
public class SearchTest extends AbstractTestBase {

	public void submitSearch_shouldDisplayResult() {
		new HomePage(driver).get().searchFor("shirt");

		Assertions.assertThat(new SearchResultsPage(driver).getProductNames()).contains("Faded Short Sleeves T-shirt");
	}

	public void submitSearch_shouldDisplayNameAndPrice() {
		new HomePage(driver).get().searchFor("sleeves");

		new SearchResultsPage(driver).getResults().forEach(r -> System.out.println(r.getProductName()));
	}
}
