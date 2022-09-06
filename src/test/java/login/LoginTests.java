package login;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @Test(groups = {smoke})
    @Description("Login Test")
    public void loginTest() {
        var username = "standard_user";
        var password = "secret_sauce";

        loginPage.loginForm(username, password);

        log.info("Waiting shopping page to load");
        utilities.waitSeconds(2);

        homePage.verifyProductLabelIsDisplayed();
    }


    @Override
    protected void initPages() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
}
