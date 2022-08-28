package pages;

import helpers.FirefoxWebDriver;
import org.openqa.selenium.WebDriver;
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
	
	public EbayHomePage(FirefoxWebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(this.getDriver(), this);
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
		return this.getDriver().getTitle();
	}

	public EbayResultsPage search(String searchTerm) throws IOException {
		searchTextBox.sendKeys(searchTerm);
		searchButton.click();
		return new EbayResultsPage(this.driver, searchTerm);
	}

}
