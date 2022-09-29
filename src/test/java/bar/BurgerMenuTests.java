package bar;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.bars.BurgerMenuPage;
import pageObjects.login.LoginPage;

public class BurgerMenuTests extends BaseTest {
    private BurgerMenuPage burgerMenuPage;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.openBurgerMenu();
    }

    @Test(groups = smoke)
    public void verifyBurgerMenuTest() {
        burgerMenuPage.verifyPage();
    }

    @Test(groups = smoke)
    public void logoutTest() {
        burgerMenuPage.clickOnLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test(groups = regression)
    public void verifyAboutOption() {
        burgerMenuPage.verifyAboutOption(dataProviders.aboutOptionUrl());
    }

    @Override
    protected void initPages(WebDriver driver) {
        burgerMenuPage = new BurgerMenuPage(driver);
        loginPage = new LoginPage(driver);
    }
}
