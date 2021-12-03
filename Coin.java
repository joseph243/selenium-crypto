package automation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Coin {

	// my collection of data
	static Map<Integer, Asset> assets = new HashMap<Integer, Asset>();

	public static boolean getDataCoinMarketCap() throws Throwable {

		// action item for keypresses
		Actions action = new Actions(SeleniumClass.getDriver());

		// allow page load
		Thread.sleep(5000);

		// scroll the page slowly to load all elements into the table.
		for (int k = 0; k < 20; k++) {
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(500);
		}

		// identify table and rows
		WebElement table = SeleniumClass.getDriver().findElement(By.tagName("table"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));

		// debug
		System.out.println("DEBUG: " + tableRows.size() + " coins found.");

		// iterate rows/cells and collect data
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > 1) {
				// 1 = rank
				// 2 = name / symbol
				// 3 = price
				// 4 = 24hr
				// 5 = 7day
				// 6 = market cap
				// 7 = 24hr volume
				// grab each row data and assign to a new object
				Asset asset = new Asset(cells.get(1).getText(), cells.get(2).getText(), cells.get(3).getText(),
						cells.get(4).getText(), cells.get(5).getText(), cells.get(6).getText(), cells.get(7).getText());
				// add new object to list
				asset.setPrice(cells.get(3).getText());
				assets.put(asset.getRank(), asset);
			}
		}

		// verify 100 coins collected and return pass/fail
		CoinReporter.addLine("Get Top 100", "Total coins found = " + String.valueOf(assets.size()));
		return (assets.size() == 100);
	}

	public static boolean hasCoinbase() throws Throwable {
		Thread.sleep(1000); // allow page load
		// read list of coins
		List<WebElement> listSupported = SeleniumClass.getDriver()
				.findElements(By.className("s27-crypto-base-asset__ticker"));
		WebElement searchBar = SeleniumClass.getDriver().findElement(By.className("s05-search-bar__input"));
		int matchCount = 0;
		int lookedCount = 0;
		for (WebElement item : listSupported) {
			for (int i=1; i < assets.size()+1; i++)
			{
				if (assets.get(i).getSymbol().equalsIgnoreCase(item.getText()))
						{
							matchCount++;
							assets.get(i).setOnCoinbase(true);
							break;
						}
			}
			lookedCount ++;
			searchBar.clear();
		    searchBar.sendKeys("looking for coins... " + lookedCount + "/" + listSupported.size() + " searched.");
		}
		CoinReporter.addLine("Has Coinbase" , (matchCount + "/" + assets.size() + " assets on coinbase."));
		return (matchCount > 40); // sanity check
	}

}
