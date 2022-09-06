package customLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomLocator {
    private final By locator;
    private final WebDriver driver;
    private final CustomActions customActions = new CustomActions();
    private final CustomVerifications customVerifications = new CustomVerifications();

    public CustomLocator(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public CustomLocator click() {
        customActions.click(locator, driver);
        return this;
    }

    public CustomLocator sendKeys(String text) {
        customActions.sendKeys(locator, driver, text);
        return this;
    }

    public CustomLocator waitForView() {
        customActions.waitForView(locator, driver);
        return this;
    }

    public void verifyIsDisplayed() {
        customVerifications.verifyIsdIsDisplayed(locator, driver);
    }
}
