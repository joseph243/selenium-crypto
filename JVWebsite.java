package automation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JVWebsite {

	public static boolean projectsPage() {
		boolean isPassing = true;
		WebElement projectsLink = SeleniumClass.getDriver().findElement(By.linkText("Projects"));
		projectsLink.click();
		ArrayList<WebElement> objects = new ArrayList<WebElement>();
		
		WebElement thisWebsiteLink = SeleniumClass.getDriver().findElement(By.linkText(("This Website / Home")));
		WebElement selenium1Link = SeleniumClass.getDriver().findElement(By.linkText(("Selenium Browser Automation - JV Website")));
		WebElement powershellLink1 = SeleniumClass.getDriver().findElement(By.linkText("Powershell Script: Folder Cleanup"));
		WebElement powershellLink2 = SeleniumClass.getDriver().findElement(By.linkText("Powershell Script: SSO Troubleshooting"));
		WebElement androidLink = SeleniumClass.getDriver().findElement(By.linkText("Android App: \"Workout Partner\" ON HOLD"));
		WebElement woodworking = SeleniumClass.getDriver().findElement(By.linkText("Woodworking Projects"));

		objects.add(powershellLink1);
		objects.add(powershellLink2);
		objects.add(thisWebsiteLink);
		objects.add(selenium1Link);
		objects.add(androidLink);
		objects.add(woodworking);
		
		for (WebElement object : objects) {
			if (!object.isDisplayed()) {
				isPassing = false;
			}
		System.out.println(object.isDisplayed() + " | " + object.getText());
		}
		return isPassing;
	}
	
	public static boolean picturesPage()
	{
		boolean isPassing = true;
		
		WebElement picturesLink = SeleniumClass.getDriver().findElement(By.linkText("Pictures"));
		picturesLink.click();
		ArrayList<WebElement> objects = new ArrayList<WebElement>();
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("Charlie 2021")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("Galveston Family Vacation 2020")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("Skiing with the Silvers 2020")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("Yellowstone 2019 Pictures")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("California 2018 Pictures")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("California 2018 Ride Video")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("Ski Trip 2018 Pictures")));

		for (WebElement object : objects) {
			if (!object.isDisplayed()) {
				isPassing = false;
			}
		System.out.println(object.isDisplayed() + " | " + object.getText());
		}	
		return isPassing;
	}

	public static boolean contactInfo()
	{
		boolean isPassing = true;
		//not a link, a button.  cant find this
		// WebElement contactLink = ;
		// contactLink.click();
		
		ArrayList<WebElement> objects = new ArrayList<WebElement>();
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("joseph@josephvanderzwart.com")));
		objects.add(SeleniumClass.getDriver().findElement(By.linkText("LinkedIn")));

		for (WebElement object : objects) {
			if (!object.isDisplayed()) {
				isPassing = false;
			}
		System.out.println(object.isDisplayed() + " | " + object.getText());
		}	

		return isPassing;
	}
}
