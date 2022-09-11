package home;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomeShoppingPage;

public class HomeShoppingTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod(alwaysRun = true, description = "Setup")
    public void setup() {
        commonFlows.goToHomeShoppingPage();
    }

    @Test(groups = {smoke})
    public void verifyHomeShoppingPage() {
        homeShoppingPage.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
