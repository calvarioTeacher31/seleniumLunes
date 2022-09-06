package pageObjects;

import base.BasePage;
import customLocators.CustomLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final CustomLocator loginInput = new CustomLocator(By.id("user-name"), driver);
    private final CustomLocator passwordInput = new CustomLocator(By.id("password"), driver);
    private final CustomLocator loginButton = new
            CustomLocator(By.cssSelector("input[data-test='login-button']"), driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitPageToLoad() {

    }

    @Override
    protected void verifyPage() {

    }

    public void loginForm(String username, String password) {
        loginInput.waitForView().sendKeys("Aloha").click().sendKeys("pipipippi").verifyIsDisplayed();
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
