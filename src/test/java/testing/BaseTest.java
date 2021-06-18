package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.WebDriverFactory;

public abstract class BaseTest {

	protected WebDriver driver;

    @BeforeClass(alwaysRun = true, description = "Open Chrome Browser for Testing")
    public void setUp() {
    	
    	String browser = "chrome";
        System.out.println("Here starts the automation with: " + browser);

        // Get correct driver for desire browser
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

	protected abstract WebDriver getDriver();

    @AfterClass(alwaysRun = true, description = "Closes and kill the browser session")
    public void tearDown() {
        driver.close();
        driver.quit();
    }
    
}