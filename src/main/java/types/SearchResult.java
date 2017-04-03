package types;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResult {

	private String productName;
	private String price;

	public SearchResult(final WebElement el) {
		productName = el.findElement(By.cssSelector("a.product-name")).getText();
		price = el.findElement(By.cssSelector("span.product-price")).getText();
	}

	public String getProductName() {
		return productName;
	}

	public String getPrice() {
		return price;
	}

}
