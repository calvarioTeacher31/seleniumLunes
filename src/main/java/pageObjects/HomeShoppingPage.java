package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import locators.CustomLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeShoppingPage extends BasePage {
    private final CustomLocator productLabel =
            new CustomLocator(By.xpath("//span[text()='Products']"), driver);
    private final CustomLocator filterSelect =
            new CustomLocator(By.cssSelector("select[data-test='product_sort_container']"), driver);
    private final CustomLocator sideBarMenuButton =
            new CustomLocator(By.id("react-burger-menu-btn"), driver);

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
        softAssert.assertTrue(productLabel.verifyIsDisplayed(), "Product label is not displayed");
        softAssert.assertTrue(filterSelect.verifyIsDisplayed(), "Filter select is not displayed");
        softAssert.assertAll();
    }

    @Step("Clicking to open menu bar")
    public void openMenuBar() {
        log.info("Clicking to open menu bar");
        sideBarMenuButton.click();
    }
}
