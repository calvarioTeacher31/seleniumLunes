package pageObjects.login;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class LoginPage extends BasePage {
    private final $ usernameInput = $(By.id("user-name"));
    private final $ passwordInput = $(By.id("password"));
    private final $ loginButton = $(By.id("login-button"));
    private final $ robotImage = $(By.className("bot_column"));
    private final $ errorMessage = $(By.cssSelector("h3[data-test='error']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Login Page to Load")
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Login Page")
    public void verifyPage() {
        softAssert.assertTrue(usernameInput.isDisplayed(), "Username Input");
        softAssert.assertTrue(passwordInput.isDisplayed(), "Password Input");
        softAssert.assertTrue(loginButton.isDisplayed(), "Login Button");
        softAssert.assertTrue(robotImage.isDisplayed(), "Robot Image");
        softAssert.assertAll();
    }

    @Step("Filling login form")
    public void fillForm(String username, String password) {
        logs.info("Filling username: " + username);
        usernameInput.sendKeys(username);

        logs.info("Filling password: " + password);
        passwordInput.sendKeys(password);

        logs.info("Clicking on login button");
        loginButton.click();
    }

    @Step("Verifying error message")
    public void verifyErrorMessage(String errorText) {
        softAssert.assertTrue(errorMessage.isDisplayed(), "Visibility");
        softAssert.assertEquals(errorMessage.getText(), errorText, "Visibility");
        softAssert.assertAll();
    }
}
