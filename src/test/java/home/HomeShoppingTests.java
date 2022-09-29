package home;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.bars.HeaderPage;
import pageObjects.home.HomeShoppingPage;

public class HomeShoppingTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;
    private HeaderPage headerPage;

    @BeforeMethod(alwaysRun = true, description = setup)
    public void setup() {
        commonFlows.goToHome();
    }

    @Test(groups = {smoke})
    public void verifyHomeShoppingPageTest() {
        homeShoppingPage.verifyPage();
    }

    @Test(groups = {smoke})
    public void verifyCountTest() {
        homeShoppingPage.addAllItemsToCart();
        headerPage.verifyItemCount(6);
    }

    @Test(groups = {regression})
    public void selectItemPriceTest() {
        homeShoppingPage.orderItemsByPrice(false);
        homeShoppingPage.verifyItemPriceOrder(false);

        homeShoppingPage.orderItemsByPrice(true);
        homeShoppingPage.verifyItemPriceOrder(true);
    }

    @Test(groups = {regression})
    public void selectItemNameTest() {
        homeShoppingPage.orderItemsByName(false);
        homeShoppingPage.verifyItemNameOrder(false);

        homeShoppingPage.orderItemsByName(true);
        homeShoppingPage.verifyItemNameOrder(true);
    }

    @Override
    protected void initPages(WebDriver driver) {
        homeShoppingPage = new HomeShoppingPage(driver);
        headerPage = new HeaderPage(driver);
    }
}
