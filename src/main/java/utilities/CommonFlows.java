package utilities;

import data.DataProviders;
import models.UserInformation;
import org.openqa.selenium.WebDriver;
import pageObjects.bars.BurgerMenuPage;
import pageObjects.bars.HeaderPage;
import pageObjects.home.HomeShoppingPage;
import pageObjects.login.LoginPage;
import pageObjects.step.CartPage;
import pageObjects.step.FinishCheckoutPage;
import pageObjects.step.StepOnePage;
import pageObjects.step.StepTwoPage;

public class CommonFlows {
    private final WebDriver driver;
    private final String mainUrl = "https://www.saucedemo.com/";
    private final DataProviders dataProviders = new DataProviders();

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var loginPage = new LoginPage(driver);

        driver.get(mainUrl);
        loginPage.waitPageToLoad();
    }

    public void goToHome() {
        var loginPage = new LoginPage(driver);
        var homeShoppingPage = new HomeShoppingPage(driver);
        var validCredentials = dataProviders.getValidCredentials();

        loginPage.fillForm(validCredentials.getUsername(), validCredentials.getPassword());
        homeShoppingPage.waitPageToLoad();
    }

    public void openBurgerMenu() {
        var headerPage = new HeaderPage(driver);
        var burgerMenuPage = new BurgerMenuPage(driver);

        goToHome();
        headerPage.openBurgerMenu();
        burgerMenuPage.waitPageToLoad();
    }

    public void goToCart(boolean addItems) {
        var homeShoppingPage = new HomeShoppingPage(driver);
        var headerPage = new HeaderPage(driver);
        var cartPage = new CartPage(driver);

        goToHome();

        if (addItems) {
            homeShoppingPage.addAllItemsToCart();
        }

        headerPage.clickOnCart();
        cartPage.waitPageToLoad();
    }

    public void goToStepOne(boolean addItems) {
        var cartPage = new CartPage(driver);
        var stepOnePage = new StepOnePage(driver);

        goToCart(addItems);
        cartPage.clickOnCheckout();
        stepOnePage.waitPageToLoad();
    }

    public void goToStepTwo(boolean addItems) {
        var stepOnePage = new StepOnePage(driver);
        var stepTwoPage = new StepTwoPage(driver);
        var userInformation = new UserInformation();

        goToStepOne(addItems);
        stepOnePage.fillForm(userInformation.getFirstname(), userInformation.getLastname(),
                userInformation.getZipcode());
        stepTwoPage.waitPageToLoad();
    }

    public void finishCheckout(boolean addItems) {
        var stepTwoPage = new StepTwoPage(driver);
        var finishCheckout = new FinishCheckoutPage(driver);

        goToStepTwo(addItems);
        stepTwoPage.clickOnFinish();
        finishCheckout.waitPageToLoad();
    }
}