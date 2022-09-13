package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class HomeShoppingPage extends BasePage {
    private final $ productsLabel = $(By.xpath("//span[text()='Products']"));
    private final $ robotImage = $(By.className("peek"));
    private final $ inventoryContainer = $(By.id("inventory_container"));
    private final $$ buttonList = $$(By.xpath("//button[text()='Add to cart']"));
    private final $ shoppingCart = $(By.className("shopping_cart_badge"));

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

    @Step("Verifying item count")
    public void verifyItemCount(int expectedCount) {
        var cartCounter = Integer.parseInt(shoppingCart.getText());

        softAssert.assertTrue(shoppingCart.isDisplayed(), "Displayed");
        softAssert.assertEquals(cartCounter, expectedCount, "Counter");
        softAssert.assertAll();
    }
}
