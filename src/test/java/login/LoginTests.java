package login;

import base.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = {smoke})
    @Description("Login Test")
    public void loginTest() {
        var username = "standard_user";
        var password = "secret_sauce";

        var usernameInput = driver.findElement(By.id("user-name"));
        var passwordInput = driver.findElement((By.id("password")));
        var loginButton = driver.findElement((By.cssSelector("input[data-test='login-button']")));
        var productsLabel = driver.findElement((By.xpath("//span[text()='Products']")));

        log.info("Filling username: " + username);
        usernameInput.sendKeys(username);

        log.info("Filling password: " + password);
        passwordInput.sendKeys(password);

        log.info("Clicking on login button");
        loginButton.click();

        log.info("Waiting shopping page to load");
        utilities.waitSeconds(2);

        Assert.assertTrue(productsLabel.isDisplayed());
    }
}
