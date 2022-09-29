package step;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.step.CartPage;
import pageObjects.step.StepOnePage;

import static data.DataProviders.USER_INFORMATION_DP;

public class StepOneTests extends BaseTest {
    private CartPage cartPage;
    private StepOnePage stepOnePage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.goToStepOne(true);
    }

    @Test(groups = smoke)
    public void verifyStepTwoPageTest() {
        stepOnePage.verifyPage();
        stepOnePage.clickOnCancelButton();
        cartPage.waitPageToLoad();
        cartPage.verifyPage();
    }

    @Test(groups = regression, dataProvider = USER_INFORMATION_DP, dataProviderClass = DataProviders.class)
    public void errorMessageTest(String firstname, String lastname, String zipcode, String errorMessage) {
        stepOnePage.fillForm(firstname, lastname, zipcode);
        stepOnePage.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages(WebDriver driver) {
        cartPage = new CartPage(driver);
        stepOnePage = new StepOnePage(driver);
    }
}
