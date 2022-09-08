package base;

import locators.CustomLocator;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

public abstract class BasePage {
    protected final Logs log = new Logs();
    protected final WebDriver driver;
    private final int timeOut;
    protected SoftAssert softAssert;


    public BasePage(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
        softAssert = new SoftAssert();
    }

    protected void waitPage(CustomLocator customLocator, String pageName) {
        var message = String.format("Waiting %s to load", pageName);
        log.info(message);

        customLocator.waitForVisibility(timeOut);

        message = String.format("%s loaded successfully", pageName);
        log.info(message);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}