package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import org.junit.jupiter.api.Assertions;

import pages.EbayResultsPage;

public class EbayHomePage extends Base{
	
	private final String ebayHomePageUrl = "https://www.ebay.com/";

	@FindBy(id="gh-ac")
	private WebElement searchTextBox;

	@FindBy(id="gh-btn")
	private WebElement searchButton;
	
	public EbayHomePage() {
		PageFactory.initElements(this.getCurrentDriver(), this);
	}

	@Override
	protected void load() {
		this.get(ebayHomePageUrl);
		this.currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//this.driverWait.until(ExpectedConditions.elementToBeClickable(By.id("gh-ac")));
	}

	@Override
	protected void isLoaded() throws Error {
		Assertions.assertTrue(this.getTitle().contains("eBay"));
	}

	public String getHomePageTitle() {
		return this.currentDriver.getTitle();
	}
	
	private EbayHomePage enterTextOnSearchBox(String text) {
		searchTextBox.sendKeys(text);
		return this;
	}
	
	private EbayResultsPage clickOnSearchButton() {
		searchButton.click();
		return new EbayResultsPage(this.currentDriver, this.driverWait);
	}

	public EbayResultsPage searchItem(String text){
		return enterTextOnSearchBox(text).clickOnSearchButton();
	}
}
