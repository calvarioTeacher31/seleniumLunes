package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import locators.CustomLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private final CustomLocator usernameInput = new CustomLocator(By.id("user-name"), driver);
    private final CustomLocator passwordInput = new CustomLocator(By.id("password"), driver);
    private final CustomLocator loginButton = new CustomLocator(By.id("login-button"), driver);
    private final CustomLocator robotImage = new CustomLocator(By.className("bot_column"), driver);
    private final CustomLocator invalidCredentialsError =
            new CustomLocator(By.cssSelector("h3[data-test='error']"), driver);

    public LoginPage(WebDriver driver) {
        super(driver, 3);
    }

    @Override
    @Step("Waiting Login Page to load")
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Login Page")
    public void verifyPage() {
        softAssert.assertTrue(usernameInput.verifyIsDisplayed(), "User name input is not displayed");
        softAssert.assertTrue(passwordInput.verifyIsDisplayed(), "Password input is not displayed");
        softAssert.assertTrue(loginButton.verifyIsDisplayed(), "Login Button is not displayed");
        softAssert.assertTrue(robotImage.verifyIsDisplayed(), "Robot image is not displayed");
        softAssert.assertAll();
    }

    @Step("Filling login form")
    public void fillForm(String username, String password) {
        log.info("Filling username: " + username);
        usernameInput.sendKeys(username);

        log.info("Filling password: " + username);
        passwordInput.sendKeys(password);

        log.info("Clicking on login button");
        loginButton.click();
    }

    @Step("Verifying error message")
    public void verifyErrorMessage(String text) {
        log.info("Waiting error message to appear");
        var webElementText = invalidCredentialsError.waitForVisibility().getText();

        log.info("Verifying credentials error has correct text");
        Assert.assertEquals(webElementText, text);
    }
}
