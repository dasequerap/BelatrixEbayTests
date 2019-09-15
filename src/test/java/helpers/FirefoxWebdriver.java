package helpers;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxWebdriver {
	FirefoxDriver driver;
	
	public void initDriver() {
		driver = new FirefoxDriver();
	}
	
	public FirefoxDriver getCurrentDriver() {
		return driver;
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public WebDriverWait getImplicitWait(int timeOut) {
		return new WebDriverWait(driver, timeOut);
	}
	
	public void waitPage(int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public void closeDriver() {
		driver.close();
	}
}
