package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWebElement {
    private final By locator;
    private final WebDriver driver;
    private final CustomActions customActions = new CustomActions();
    private final CustomVerifications customVerifications = new CustomVerifications();
    private final CustomAttributes customAttributes = new CustomAttributes();
    private WebDriverWait wait;

    public CustomWebElement(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public CustomWebElement click() {
        customActions.click(locator, driver);
        return this;
    }

    public CustomWebElement sendKeys(String text) {
        customActions.sendKeys(locator, driver, text);
        return this;
    }

    public boolean isDisplayed() {
        return customVerifications.isDisplayed(locator, driver);
    }

    public String getText() {
        return customAttributes.getText(locator, driver);
    }

    public CustomWebElement waitForVisibility(int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //explicit wait per se
        return this;
    }

    public CustomWebElement waitForVisibility() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  //explicit wait per se
        return this;
    }
}