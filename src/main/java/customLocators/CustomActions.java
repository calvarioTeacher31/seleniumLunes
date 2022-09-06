package customLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomActions {
    WebElement webElement;

    private void findElement(By locator, WebDriver driver) {
        webElement = driver.findElement(locator);
    }

    public void click(By locator, WebDriver driver) {
        findElement(locator, driver);
        webElement.click();
    }

    public void sendKeys(By locator, WebDriver driver, String text) {
        findElement(locator, driver);
        webElement.sendKeys(text);
    }

    public void waitForView(By locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
