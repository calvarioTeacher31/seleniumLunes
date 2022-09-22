package pageObjects.home;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.list.$$;
import webElements.single.$;

public class HomeShoppingPage extends BasePage {
    private final $ productsLabel = $(By.xpath("//span[text()='Products']"));
    private final $ robotImage = $(By.className("peek"));
    private final $ inventoryContainer = $(By.id("inventory_container"));
    private final $$ buttonList = $$(By.xpath("//button[text()='Add to cart']"));
    private final $ selectFilterItem = $(By.cssSelector("select[data-test='product_sort_container']"));
    private final $$ itemPriceList = $$(By.className("inventory_item_price"));
    private final $$ itemNameList = $$(By.className("inventory_item_name"));

    public HomeShoppingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Home Shopping Page to load")
    public void waitPageToLoad() {
        waitPage(productsLabel, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Home Shopping Page")
    public void verifyPage() {
        softAssert.assertTrue(productsLabel.isDisplayed(), "Products Label");
        softAssert.assertTrue(robotImage.isDisplayed(), "Robot Image");
        softAssert.assertTrue(inventoryContainer.isDisplayed(), "Inventory Container");
        softAssert.assertAll();
    }

    @Step("Clicking on all items")
    public void addAllItemsToCart() {
        log.info("Clicking on all items");
        buttonList.clickAll();
    }

    @Step("Ordering items by price")
    public void orderItemsByPrice(boolean isLowToHigh) {
        if (isLowToHigh) { //low to high case
            log.info("Selecting low to high on price select");
            selectFilterItem.selectByValue("lohi");
        } else { //high to low case
            log.info("Selecting high to low on price select");
            selectFilterItem.selectByValue("hilo");
        }
    }

    @Step("Ordering items by name")
    public void orderItemsByName(boolean isAZ) {
        if (isAZ) { //A to Z case
            log.info("Selecting A to Z on name select");
            selectFilterItem.selectByValue("az");
        } else { //Z to A case
            log.info("Selecting Z to A on name select");
            selectFilterItem.selectByValue("za");
        }
    }

    @Step("Verifying price order")
    public void verifyItemPriceOrder(boolean isLowToHigh) {
        log.info("Getting first item price from price list");
        var firstItemPrice = Double.parseDouble(
                itemPriceList.getFirst().getText().substring(1)
        ); //first price 49.99

        log.info("Getting last item price from price list");
        var lastItemPrice = Double.parseDouble(
                itemPriceList.getLast().getText().substring(1)
        ); //last price 7.99

        if (isLowToHigh) { //low to high case
            log.info("Verifying first price is lower than last price");
            Assert.assertTrue(firstItemPrice < lastItemPrice);
        } else { //high to low case
            log.info("Verifying last price is lower than first price");
            Assert.assertTrue(firstItemPrice > lastItemPrice);
        }
    }

    @Step("Verifying item name order")
    public void verifyItemNameOrder(boolean isAZ) {
        log.info("Getting first item name from item name list");
        var firstItemName = itemNameList.getFirst().getText();

        log.info("Getting last item name from item name list");
        var lastItemName = itemNameList.getLast().getText();

        if (isAZ) { //A to Z case
            log.info("Verifying item name list is ordered A to Z");
            Assert.assertTrue(firstItemName.compareToIgnoreCase(lastItemName) < 0);
        } else { //Z to A case
            log.info("Verifying item name list is ordered Z to A");
            Assert.assertTrue(firstItemName.compareToIgnoreCase(lastItemName) > 0);
        }
    }
}
