package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

	public static WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			return new ChromeDriver();
	} else if (browser.equalsIgnoreCase("Edge")) {
		System.setProperty("webdriver.edge.driver", "C:/Windows/System32/msedgedriver.exe");
		return new EdgeDriver();
	} else {
		return null;
	}
}
}