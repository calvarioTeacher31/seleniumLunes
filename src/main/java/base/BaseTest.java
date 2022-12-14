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

@Listeners({SuiteListeners.class, TestListeners.class})
public abstract class BaseTest {
    protected final Logs log = new Logs();
    protected DriverManager driverManager = new DriverManager();
    protected SoftAssert softAssert;
    private WebDriver driver;
    protected final String smoke = "Smoke";
    protected final String regression = "Regression";
    protected final String setup = "Setup";
    protected final DataProviders dataProviders = new DataProviders();
    protected CommonFlows commonFlows;

    @BeforeMethod(alwaysRun = true, description = "Setup Base")
    public void setupBase() {
        softAssert = new SoftAssert();
        driver = driverManager.createDriver();
        initPages(driver);
        commonFlows = new CommonFlows(driver);
        commonFlows.goToIndex(); //go to index
    }

    @AfterMethod(alwaysRun = true, description = "Teardown Base")
    public void teardownBase() {
        log.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void initPages(WebDriver driver);
}
