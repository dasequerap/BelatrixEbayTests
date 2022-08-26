package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.FirefoxWebdriver;

import java.io.IOException;
import java.time.Duration;

import helpers.PropertiesReader;


public abstract class Base extends LoadableComponent<Base> {
	protected final FirefoxWebdriver driver;
	protected final WebDriverWait driverWait;
	protected final WebDriver currentDriver;

	protected final PropertiesReader properties;

	public Base() throws IOException {
		properties = new PropertiesReader("config");
		driver = new FirefoxWebdriver();
		driver.initDriver();
		currentDriver = driver.getCurrentDriver();
		driverWait = driver.getImplicitWait(
				Duration.ofSeconds(Long.parseLong(properties.getProperty("pageTimeout"))));
	}

	public String getTitle(){
		return this.driver.getCurrentDriver().getTitle();
	}

	public void get(String url) { this.driver.getUrl(url); }

	public WebDriver getCurrentDriver() { return currentDriver; }

	protected void waitPage(){
		this.currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	protected void waitElementToBeClickable(WebElement element){
		this.driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void quit() {
		this.currentDriver.close();
	}
}
