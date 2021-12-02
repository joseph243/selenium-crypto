package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumClass {

	private static WebDriver driver = new ChromeDriver();

	public static void navigateTo(String inWebsite) {
		switch (inWebsite) {
		case "josephvanderzwart.com":
			driver.navigate().to("http://josephvanderzwart.com/");
			break;
		case "coinmarketcap.com":
			driver.navigate().to("https://coinmarketcap.com/");
			break;
		default:
			driver.navigate().to(inWebsite);
			break;
		}		
	}
	
	public static void openBrowser() {
		// Launch
		System.out.println("Launching Browser.");
	}

	public static void quitBrowser() {
		// Quit
		System.out.println("Quitting Browser.");
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
