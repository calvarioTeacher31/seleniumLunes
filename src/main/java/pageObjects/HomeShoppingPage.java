package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import locators.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeShoppingPage extends BasePage {
    private final CustomWebElement productLabel =
            new CustomWebElement(By.xpath("//span[text()='Products']"), driver);
    private final CustomWebElement filterSelect =
            new CustomWebElement(By.cssSelector("select[data-test='product_sort_container']"), driver);
    private final CustomWebElement sideBarMenuButton =
            new CustomWebElement(By.id("react-burger-menu-btn"), driver);

    private CustomWebElement getProductLabel(String productName) {
        var dynamicLocator = String.format("//div[text()='%s']", productName);
        return new CustomWebElement(By.xpath(dynamicLocator), driver);
    }

    public HomeShoppingPage(WebDriver driver) {
        super(driver, 3);
    }

    @Override
    @Step("Waiting Home Page to load")
    public void waitPageToLoad() {
        waitPage(productLabel, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Home Page")
    public void verifyPage() {
        softAssert.assertTrue(productLabel.isDisplayed(), "Product label is not displayed");
        softAssert.assertTrue(filterSelect.isDisplayed(), "Filter select is not displayed");
        softAssert.assertAll();
    }

    @Step("Clicking to open menu bar")
    public void openMenuBar() {
        log.info("Clicking to open menu bar");
        sideBarMenuButton.click();

        var product = getProductLabel("Sauce Labs Backpack");
        Assert.assertTrue(product.isDisplayed());
    }
}
