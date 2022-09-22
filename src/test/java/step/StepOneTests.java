package step;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.home.HomeShoppingPage;
import pageObjects.step.StepOnePage;

public class StepOneTests extends BaseTest {
    private StepOnePage stepOnePage;
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod(alwaysRun = true, description = "setup")
    public void setUp() {
        commonFlows.goToStepOne(true);
    }

    @Test(groups = smoke)
    public void verifyStepOneTest() {
        stepOnePage.verifyPage();
        stepOnePage.clickOnContinueShopping();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        stepOnePage = new StepOnePage(driver);
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
