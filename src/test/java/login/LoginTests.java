package login;

import base.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.home.HomeShoppingPage;
import pageObjects.login.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private HomeShoppingPage homeShoppingPage;

    @Test(groups = {smoke}, enabled = false)
    @Description("Login Test")
    public void loginTest() {
        var credentials = dataProviders.getValidCredentials();
        loginPage.fillForm(credentials.getUsername(), credentials.getPassword());
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Test(groups = {regression})
    @Description("Invalid credentials Test")
    public void invalidCredentialTest() {
        var errorMessage = "Epic sadface: Sorry, this user has been locked out.";
        var credentials = dataProviders.getLockedCredentials();
        loginPage.fillForm(credentials.getUsername(), credentials.getPassword());
        loginPage.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
