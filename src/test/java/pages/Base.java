package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.FirefoxWebDriver;

import java.io.IOException;
import java.time.Duration;

import helpers.PropertiesReader;


public abstract class Base extends LoadableComponent<Base> {
	protected final FirefoxWebDriver driver;
	protected final WebDriverWait driverWait;

	protected final PropertiesReader properties;

	public Base(FirefoxWebDriver driver) throws IOException {
		this.properties = new PropertiesReader("config");
		this.driver = driver;
		driverWait = driver.getImplicitWait(
				Duration.ofSeconds(Long.parseLong(properties.getProperty("pageTimeout"))));
	}

	public String getTitle(){ return this.driver.getCurrentDriver().getTitle();	}

	public void get(String url) { this.driver.getUrl(url); }

	public WebDriver getDriver() { return this.driver.getCurrentDriver(); }

	protected void waitPage(){ this.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	}

	protected void waitElementToBeClickable(WebElement element){
		this.driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void quit() {
		this.getDriver().quit();
	}
}
