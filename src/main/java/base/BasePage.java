package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webElements.list.$$;
import webElements.single.$;

public abstract class BasePage {
    protected final Logs logs = new Logs();
    protected final WebDriver driver;
    private final int timeOut;
    private final int defaultTimeOut = 5;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.timeOut = defaultTimeOut;
        softAssert = new SoftAssert();
    }

    public BasePage(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
        softAssert = new SoftAssert();
    }

    protected void waitPage($ element, String pageName) {
        var message = String.format("Waiting %s to load", pageName);
        logs.info(message);

        element.waitForVisibility(timeOut);

        message = String.format("%s loaded successfully", pageName);
        logs.info(message);
    }

    protected $ $(By locator) {
        return new $(locator, driver);
    }

    protected $$ $$(By locator) {
        return new $$(locator, driver);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
