package bar;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.bars.FooterPage;

import static data.DataProviders.URL_DP;

public class FooterTests extends BaseTest {
    private FooterPage footerPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setUp() {
        commonFlows.goToHome();
    }

    @Test(groups = smoke)
    public void verifyFooterTest() {
        footerPage.verifyPage();
    }

    @Test(groups = regression, dataProvider = URL_DP, dataProviderClass = DataProviders.class)
    public void verifySocialLinksTest(String socialName, String url) {
        footerPage.verifySocialLink(socialName, url);
    }

    @Override
    protected void initPages(WebDriver driver) {
        footerPage = new FooterPage(driver);
    }
}
