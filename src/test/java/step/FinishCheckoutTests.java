package step;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.home.HomeShoppingPage;
import pageObjects.step.FinishCheckoutPage;

public class FinishCheckoutTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;
    private FinishCheckoutPage finishCheckoutPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.finishCheckout(true);
    }

    @Test(groups = smoke)
    public void verifyStepTwoPageTest() {
        finishCheckoutPage.verifyPage();
        finishCheckoutPage.clickOnBackToHome();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        homeShoppingPage = new HomeShoppingPage(driver);
        finishCheckoutPage = new FinishCheckoutPage(driver);
    }
}
