package base;

import data.DataProviders;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.CommonFlows;
import utilities.DriverManager;
import utilities.Logs;
import utilities.Utilities;

@Listeners({SuiteListeners.class, TestListeners.class})
public abstract class BaseTest extends DriverManager {
    protected final Logs log = new Logs();
    protected final Utilities utilities = new Utilities();
    protected DriverManager driverManager = new DriverManager();
    protected SoftAssert softAssert;
    protected WebDriver driver;
    protected final String smoke = "Smoke";
    protected final String regression = "Regression";
    protected final DataProviders dataProviders = new DataProviders();
    protected CommonFlows commonFlows;

    @BeforeMethod(alwaysRun = true, description = "Master precondition")
    public void setupBase() {
        softAssert = new SoftAssert();
        driver = driverManager.createDriver();
        initPages();
        commonFlows = new CommonFlows(driver);

        commonFlows.goToLoginPage(); //go to index
    }

    @AfterMethod(alwaysRun = true, description = "Master teardown")
    public void teardownBase() {
        log.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void initPages();
}
