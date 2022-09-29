package pageObjects.step;

import base.BasePage;
import io.qameta.allure.Step;
import models.ShoppingItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.single.$;

import java.util.List;

public class StepTwoPage extends BasePage {
    private final $ itemSubTotalLabel = $(By.className("summary_subtotal_label"));
    private final $ taxLabel = $(By.className("summary_tax_label"));
    private final $ itemTotalLabel = $(By.className("summary_total_label"));
    private final $ cancelButton = $(By.id("cancel"));
    private final $ finishButton = $(By.id("finish"));

    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Step Two Page to load")
    public void waitPageToLoad() {
        waitPage(finishButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Step Two Page")
    public void verifyPage() {
        softAssert.assertTrue(itemSubTotalLabel.isDisplayed(), "Item Subtotal label");
        softAssert.assertTrue(taxLabel.isDisplayed(), "Tax label");
        softAssert.assertTrue(itemTotalLabel.isDisplayed(), "Item Total label");
        softAssert.assertTrue(cancelButton.isDisplayed(), "Cancel Button");
        softAssert.assertTrue(finishButton.isDisplayed(), "Finish Button");
        softAssert.assertAll();
    }

    @Step("Clicking on finish button")
    public void clickOnFinish() {
        logs.info("Clicking on finish button");
        finishButton.click();
    }

    @Step("Clicking on cancel button")
    public void clickOnCancel() {
        logs.info("Clicking on cancel button");
        cancelButton.click();
    }

    @Step("Verifying item price")
    public void verifyItemPrice(List<ShoppingItem> shoppingItemList) {
        var itemTotal = getItemTotal();
        var sum = 0.0;
        for (var shoppingItem : shoppingItemList) {
            sum += shoppingItem.getPrice();
        }
        logs.info("Verifying both sum are equals");
        Assert.assertEquals(itemTotal, sum);
    }

    @Step("Getting item total")
    private double getItemTotal() {
        logs.info("Getting item total");
        var priceText = itemSubTotalLabel.getText(); //Item total: $129.99
        var dollarIndex = priceText.indexOf("$"); // index of $
        return Double.parseDouble(priceText.substring(dollarIndex + 1)); // 129.99
    }
}
