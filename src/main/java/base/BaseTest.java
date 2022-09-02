package base;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.DriverManager;
import utilities.Logs;
import utilities.Utilities;

@Listeners({SuiteListeners.class, TestListeners.class})
public class BaseTest extends DriverManager {
    protected final Logs log = new Logs();
    protected final Utilities utilities = new Utilities();
    protected DriverManager driverManager = new DriverManager();
    protected SoftAssert softAssert;
    protected WebDriver driver;
    protected final String smoke = "Smoke";
    protected final String regression = "Regression";
    protected final String mainUrl = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true, description = "Master precondition")
    public void setupBase() {
        softAssert = new SoftAssert();
        driver = driverManager.createDriver();

        log.info("Navigating to the main url");
        driver.get(mainUrl);

        log.info("Waiting main page to load");
        utilities.waitSeconds(1); //wait page to load
    }

    @AfterMethod(alwaysRun = true, description = "Master teardown")
    public void teardownBase() {
        log.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
