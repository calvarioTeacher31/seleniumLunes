package utilities;

import data.DataProviders;
import org.openqa.selenium.WebDriver;
import pageObjects.bars.BurgerMenuPage;
import pageObjects.bars.HeaderPage;
import pageObjects.home.HomeShoppingPage;
import pageObjects.login.LoginPage;
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

    public void goToStepOne(boolean addItems) {
        var homeShoppingPage = new HomeShoppingPage(driver);
        var headerPage = new HeaderPage(driver);
        var stepOne = new StepOnePage(driver);

        goToHome();

        if (addItems) {
            homeShoppingPage.addAllItemsToCart();
        }

        headerPage.clickOnCart();
        stepOne.waitPageToLoad();
    }

    public void goToStepTwo(boolean addItems) {
        var stepOnePage = new StepOnePage(driver);
        var stepTwoPage = new StepTwoPage(driver);

        goToStepOne(addItems);
        stepOnePage.clickOnCheckout();
        stepTwoPage.waitPageToLoad();
    }
}
