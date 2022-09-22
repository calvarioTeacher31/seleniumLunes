package step;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.step.StepOnePage;
import pageObjects.step.StepTwoPage;

import static data.DataProviders.USER_INFORMATION_DP;

public class StepTwoTests extends BaseTest {
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true, description = "setup")
    public void setUp() {
        commonFlows.goToStepTwo(true);
    }

    @Test(groups = smoke)
    public void verifyStepTwoPage() {
        stepTwoPage.verifyPage();
        stepTwoPage.clickOnCancelButton();
        stepOnePage.waitPageToLoad();
        stepOnePage.verifyPage();
    }

    @Test(groups = regression, dataProvider = USER_INFORMATION_DP, dataProviderClass = DataProviders.class)
    public void errorMessageTest(String firstname, String lastname, String zipcode, String errorMessage) {
        stepTwoPage.fillForm(firstname, lastname, zipcode);
        stepTwoPage.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages(WebDriver driver) {
        stepOnePage = new StepOnePage(driver);
        stepTwoPage = new StepTwoPage(driver);
    }
}
