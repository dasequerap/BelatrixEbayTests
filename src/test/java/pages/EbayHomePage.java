package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class EbayHomePage extends Base{
	
	private final String ebayHomePageUrl = properties.getProperty("homeUrl");

	@FindBy(id="gh-ac")
	private WebElement searchTextBox;

	@FindBy(id="gh-btn")
	private WebElement searchButton;
	
	public EbayHomePage() throws IOException {
		super();
		PageFactory.initElements(this.getCurrentDriver(), this);
	}

	@Override
	protected void load() {
		this.get(ebayHomePageUrl);
		this.waitPage();
		this.waitElementToBeClickable(searchTextBox);
	}

	@Override
	protected void isLoaded() throws Error {
		Assertions.assertTrue(this.getTitle().contains("eBay"));
	}

	public String getHomePageTitle() {
		return this.currentDriver.getTitle();
	}
	
	private EbayHomePage typeSearchTerm(String text) {
		searchTextBox.sendKeys(text);
		return this;
	}
	
	private EbayResultsPage clickOnSearchButton() {
		searchButton.click();
		return new EbayResultsPage(this.currentDriver, this.driverWait);
	}

	public EbayResultsPage searchItem(String text){
		return typeSearchTerm(text).clickOnSearchButton();
	}
}
