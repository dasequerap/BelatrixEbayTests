package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.ProductItem;

public class EbayResultsPage{
	private WebDriver currentDriver;
	private WebDriverWait resultsPageWait;
	private WebElement pumaCheckBox;
	private WebElement sizeTenCheckBox;
	String resultsLocatorTag, resultsLocatorTagXpath;
	
	public EbayResultsPage(WebDriver driver, WebDriverWait wait) {
		currentDriver = driver;
		currentDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		resultsPageWait = wait;
		resultsLocatorTag = "srp-river-results-listing";
		resultsLocatorTagXpath = "//li[contains(@id, 'srp-river-results-listing')]";
	}
	
	public void selectPumaBrand() {
		pumaCheckBox = currentDriver.findElement(
			By.xpath("//input[@aria-label='PUMA']"));
		pumaCheckBox.click();
	}
	
	public void selectShoesSizeTen() {
		sizeTenCheckBox = currentDriver.findElement(
			By.xpath("//input[@aria-label='10']"));
		sizeTenCheckBox.click();
	}
	
	public void clickSortResultsButton() {
		resultsPageWait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//button[@aria-controls='w7']")));
		currentDriver.findElement(By.xpath("//button[@aria-controls='w7']")).click();
	}
	
	public void orderByPriceAscendant() {
		clickSortResultsButton();
		currentDriver.findElement(By.linkText("Precio + Envío: más bajo primero"))
			.click();
	}
	
	public void orderByPriceDescendant() {
		clickSortResultsButton();
		currentDriver.findElement(By.linkText("Precio + Envío: más alto primero"))
			.click();
	}
		
	public String getNumberOfResults() {
		return this.currentDriver.findElement(
			By.className("srp-controls__count-heading")).getText();
	}
	
	public List<ProductItem> getTopResults(int resultsNumber) {
		List<WebElement> itemsList = currentDriver.findElements(
			By.xpath(resultsLocatorTagXpath));
		List<ProductItem> productItems = new ArrayList<ProductItem>();
		
		for(int index = 1; index < itemsList.size(); index++) {
			productItems.add(new ProductItem(
				itemsList.get(index).findElement(By.className("s-item__link")).getText(),
				itemsList.get(index).findElement(By.className("s-item__price")).getText()
			));
		}
		return productItems;
	}
	
	public void quitPage() {
		currentDriver.close();
	}
	
}
