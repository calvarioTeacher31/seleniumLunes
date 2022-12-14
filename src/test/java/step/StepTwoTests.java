package step;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.home.HomeShoppingPage;
import pageObjects.step.StepTwoPage;

public class StepTwoTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.goToStepTwo(true);
    }

    @Test(groups = smoke)
    public void verifyStepTwoPageTest() {
        stepTwoPage.verifyPage();
        stepTwoPage.clickOnCancel();
        homeShoppingPage.waitPageToLoad();
        homeShoppingPage.verifyPage();
    }

    @Test(groups = regression)
    public void itemPriceTest() {
        stepTwoPage.verifyItemPrice(dataProviders.getShoppingList());
    }

    @Override
    protected void initPages(WebDriver driver) {
        homeShoppingPage = new HomeShoppingPage(driver);
        stepTwoPage = new StepTwoPage(driver);
    }
}
