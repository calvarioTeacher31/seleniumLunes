package pageObjects.step;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class StepOnePage extends BasePage {
    private final $ checkoutButton = $(By.id("checkout"));
    private final $ continueShoppingButton = $(By.id("continue-shopping"));

    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Step One Page to load")
    public void waitPageToLoad() {
        waitPage(checkoutButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Step One Page")
    public void verifyPage() {
        softAssert.assertTrue(checkoutButton.isDisplayed(), "Checkout Button");
        softAssert.assertTrue(continueShoppingButton.isDisplayed(), "Continue Shopping Button");
        softAssert.assertAll();
    }

    @Step("Clicking on checkout")
    public void clickOnCheckout() {
        log.info("Clicking on checkout");
        checkoutButton.click();
    }

    @Step("Clicking on continue shopping")
    public void clickOnContinueShopping() {
        log.info("Clicking on continue shopping");
        continueShoppingButton.click();
    }
}
