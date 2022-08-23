package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.FirefoxWebdriver;

public class Base {
	protected final FirefoxWebdriver firefoxDriver;
	protected final WebDriverWait driverWait;
	protected final WebDriver currentDriver;
	
	public Base() {
		firefoxDriver = new FirefoxWebdriver();
		firefoxDriver.initDriver();
		currentDriver = firefoxDriver.getCurrentDriver();
		driverWait = firefoxDriver.getImplicitWait(10);
	}
	
	public void openEbayPage(String url) {
		this.firefoxDriver.getUrl(url);
	}
	
	public void quitPage() {
		this.currentDriver.close();
	}
}
