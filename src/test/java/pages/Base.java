package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.FirefoxWebdriver;

public class Base {
	protected FirefoxWebdriver firefoxDriver;
	protected WebDriverWait driverWait;
	protected WebDriver currentDriver;
	
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
