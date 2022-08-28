package helpers;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxWebDriver {
	FirefoxDriver driver;
	
	public void initDriver() {
		driver = new FirefoxDriver();
	}
	
	public WebDriver getCurrentDriver() {
		return driver;
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public WebDriverWait getImplicitWait(Duration timeOut) {
		return new WebDriverWait(driver, timeOut);
	}

	public void closeDriver() {
		driver.close();
	}
}
