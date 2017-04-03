package example;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsPage;

@Test
public class DataDrivenSearchTest extends AbstractTestBase {

	@DataProvider
	public Object[][] data() {
		return new Object[][]{ //
			{ "Dress" }, //
			{ "Sleeves" }, //
			{ "Blouse" }, //
			{ "T-shirt" } //
		};
	}

	@Test(dataProvider = "data")
	public void searchSuccess(final String query) {
		final SearchResultsPage searchResultsPage = new HomePage(driver).get() //
				.searchFor(query);

		Assertions.assertThat(searchResultsPage.getResults().size()).isGreaterThan(0);
	}
}