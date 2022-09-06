package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomVerifications {
    private WebElement element;

    private void findElement(By locator, WebDriver driver) {
        element = driver.findElement(locator);
    }

    public boolean verifyIsDisplayed(By locator, WebDriver driver) {
        findElement(locator, driver);
        return element.isDisplayed();
    }
}
