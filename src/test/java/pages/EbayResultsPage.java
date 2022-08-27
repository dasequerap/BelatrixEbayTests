package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import models.ProductItemModel;

public class EbayResultsPage{
	private final WebDriver currentDriver;
	private final WebDriverWait resultsPageWait;
	final String resultsLocatorTagXpath;
	
	public EbayResultsPage(WebDriver driver, WebDriverWait wait) {
		currentDriver = driver;
		currentDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		resultsPageWait = wait;
		resultsLocatorTagXpath = "//li[contains(@id, 'srp-river-results-listing')]";
	}
	
	public void selectPumaBrand() {
		WebElement pumaCheckBox = currentDriver.findElement(
				By.xpath("//input[@aria-label='PUMA']"));
		pumaCheckBox.click();
	}
	
	public void selectShoesSizeTen() {
		WebElement sizeTenCheckBox = currentDriver.findElement(
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
	
	/*public List<ProductItemModel> getTopResults() {
		List<WebElement> itemsList = currentDriver.findElements(
			By.xpath(resultsLocatorTagXpath));
		List<ProductItemModel> productItems = new ArrayList<ProductItemModel>();
		
		for(int index = 1; index < itemsList.size(); index++) {
			productItems.add(new ProductItemModel(
				itemsList.get(index).findElement(By.className("s-item__link")).getText(),
				itemsList.get(index).findElement(By.className("s-item__price")).getText()
			));
		}
		return productItems;
	}*/
	
	public void quitPage() {
		currentDriver.close();
	}
	
}
