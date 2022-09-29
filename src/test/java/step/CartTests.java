package step;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.home.HomeShoppingPage;
import pageObjects.step.CartPage;

public class CartTests extends BaseTest {
    private CartPage cartPage;
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.goToCart(true);
    }

    @Test(groups = smoke)
    public void verifyStepOneTest() {
        cartPage.verifyPage();
        cartPage.clickOnContinueShopping();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        cartPage = new CartPage(driver);
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
