package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomActions {
    private WebElement element;

    private void findElement(By locator, WebDriver driver) {
        element = driver.findElement(locator);
    }

    public void click(By locator, WebDriver driver) {
        findElement(locator, driver);
        element.click();
    }

    public void sendKeys(By locator, WebDriver driver, String text) {
        findElement(locator, driver);
        element.sendKeys(text);
    }
}
