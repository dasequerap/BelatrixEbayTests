package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.FirefoxWebdriver;

import java.time.Duration;

public abstract class Base extends LoadableComponent<Base> {
	protected final FirefoxWebdriver firefoxDriver;
	protected final WebDriverWait driverWait;
	protected final WebDriver currentDriver;
	public Base() {
		firefoxDriver = new FirefoxWebdriver();
		firefoxDriver.initDriver();
		currentDriver = firefoxDriver.getCurrentDriver();
		driverWait = firefoxDriver.getImplicitWait(Duration.ofSeconds(10));
	}

	public String getTitle(){
		return this.firefoxDriver.getCurrentDriver().getTitle();
	}

	public void get(String url) { this.firefoxDriver.getUrl(url); }

	public WebDriver getCurrentDriver() { return currentDriver; }

	public void quit() {
		this.currentDriver.close();
	}
}
