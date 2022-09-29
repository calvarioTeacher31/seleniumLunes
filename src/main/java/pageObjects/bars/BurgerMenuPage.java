package pageObjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class BurgerMenuPage extends BasePage {
    private final $ aboutOption = $(By.id("about_sidebar_link"));
    private final $ logoutOption = $(By.id("logout_sidebar_link"));
    private final $ allItemsOption = $(By.id("inventory_sidebar_link"));
    private final $ resetAppStateOption = $(By.id("reset_sidebar_link"));

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Burger Menu Page to load")
    public void waitPageToLoad() {
        waitPage(aboutOption, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Burger Menu Page")
    public void verifyPage() {
        softAssert.assertTrue(aboutOption.isDisplayed(), "About Option");
        softAssert.assertTrue(logoutOption.isDisplayed(), "Logout Option");
        softAssert.assertTrue(allItemsOption.isDisplayed(), "All Items Option");
        softAssert.assertTrue(resetAppStateOption.isDisplayed(), "Reset App State Option");
        softAssert.assertAll();
    }

    @Step("Verifying about option link")
    public void verifyAboutOption(String url) {
        logs.info("Verifying about option link");
        softAssert.assertTrue(aboutOption.isDisplayed());
        softAssert.assertTrue(aboutOption.isEnabled());
        softAssert.assertEquals(aboutOption.getHref(), url);
        softAssert.assertAll();
    }

    @Step("Clicking on logout option")
    public void clickOnLogout() {
        logs.info("Clicking on logout option");
        logoutOption.click();
    }
}
