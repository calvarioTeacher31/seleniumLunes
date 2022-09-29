package bar;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.bars.HeaderPage;

public class HeaderTests extends BaseTest {
    public HeaderPage headerPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.goToHome();
    }

    @Test(groups = smoke)
    public void verifyHeaderTest() {
        headerPage.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        headerPage = new HeaderPage(driver);
    }
}
