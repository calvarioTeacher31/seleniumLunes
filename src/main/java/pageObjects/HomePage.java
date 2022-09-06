package pageObjects;

import base.BasePage;
import customLocators.CustomLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final CustomLocator productLabel = new CustomLocator(By.xpath("//span[text()='Products']"), driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitPageToLoad() {

    }

    @Override
    protected void verifyPage() {

    }

    public void verifyProductLabelIsDisplayed() {
        productLabel.verifyIsDisplayed();
    }
}
