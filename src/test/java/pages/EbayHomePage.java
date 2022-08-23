package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EbayResultsPage;

public class EbayHomePage extends Base{
	
	private final String ebayHomePageUrl;
	private final WebElement SearchTextBox;
	private final WebElement SearchTextButton;
	
	public EbayHomePage() {
		ebayHomePageUrl = "https://www.ebay.com/";
		openEbayHomePage();
		this.driverWait.until(ExpectedConditions.elementToBeClickable(
			By.id("gh-ac")));
		SearchTextBox = this.currentDriver.findElement(By.id("gh-ac"));
		SearchTextButton = this.currentDriver.findElement(By.id("gh-btn"));
	}
	
	public void openEbayHomePage() {
		this.openEbayPage(ebayHomePageUrl);
		this.currentDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public String getHomePageTitle() {
		return this.currentDriver.getTitle();
	}
	
	private EbayHomePage enterTextOnSearchBox(String text) {
		SearchTextBox.sendKeys(text);
		return this;
	}
	
	private EbayResultsPage clickOnSearchButton() {
		SearchTextButton.click();
		return new EbayResultsPage(this.currentDriver, this.driverWait);
	}

	public EbayResultsPage searchItem(String text){
		return enterTextOnSearchBox(text).clickOnSearchButton();
	}
	
}
