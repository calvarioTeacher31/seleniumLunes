package pageObjects.step;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class FinishCheckoutPage extends BasePage {
    private final $ titleLabel = $(By.className("complete-header"));
    private final $ descriptionLabel = $(By.className("complete-text"));
    private final $ ponyImage = $(By.cssSelector("img[alt='Pony Express']"));
    private final $ backToHomeButton = $(By.id("back-to-products"));

    public FinishCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Finish Checkout Page to load")
    public void waitPageToLoad() {
        waitPage(ponyImage, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Finish Checkout Page")
    public void verifyPage() {
        softAssert.assertTrue(titleLabel.isDisplayed(), "Title label");
        softAssert.assertTrue(descriptionLabel.isDisplayed(), "Description label");
        softAssert.assertTrue(ponyImage.isDisplayed(), "Pony image");
        softAssert.assertTrue(backToHomeButton.isDisplayed(), "Back to Home Button");
        softAssert.assertAll();
    }

    @Step("Clicking on back to home button")
    public void clickOnBackToHome() {
        logs.info("Clicking on back to home button");
        backToHomeButton.click();
    }
}
