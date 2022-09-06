package customLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomVerifications {


    public void verifyIsdIsDisplayed(By locator, WebDriver driver) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }
 

}
