package pageObjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class HeaderPage extends BasePage {
    private final $ appLogo = $(By.className("app_logo"));
    private final $ cartImage = $(By.className("shopping_cart_link"));
    private final $ burgerButton = $(By.id("react-burger-menu-btn"));
    private final $ itemCounter = $(By.className("shopping_cart_badge"));

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Top Bar to Load")
    public void waitPageToLoad() {
        waitPage(appLogo, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Top Bar Page")
    public void verifyPage() {
        softAssert.assertTrue(appLogo.isDisplayed(), "App Logo");
        softAssert.assertTrue(cartImage.isDisplayed(), "Cart Image");
        softAssert.assertTrue(burgerButton.isDisplayed(), "Burger Button");
        softAssert.assertAll();
    }

    @Step("Clicking on burger Button to open burger menu")
    public void openBurgerMenu() {
        logs.info("Clicking on burger Button to open burger menu");
        burgerButton.click();
    }

    @Step("Clicking on cart image")
    public void clickOnCart() {
        logs.info("Clicking on cart image");
        cartImage.click();
    }

    @Step("Verifying item count")
    public void verifyItemCount(int expectedCount) {
        var cartCounter = Integer.parseInt(itemCounter.getText());

        softAssert.assertTrue(itemCounter.isDisplayed(), "Displayed");
        softAssert.assertEquals(cartCounter, expectedCount, "Counter");
        softAssert.assertAll();
    }
}
