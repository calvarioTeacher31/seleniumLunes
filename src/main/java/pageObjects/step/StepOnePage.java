package pageObjects.step;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class StepOnePage extends BasePage {
    private final $ firstnameInput = $(By.id("first-name"));
    private final $ lastnameInput = $(By.id("last-name"));
    private final $ zipcodeInput = $(By.id("postal-code"));
    private final $ cancelButton = $(By.id("cancel"));
    private final $ continueButton = $(By.id("continue"));
    private final $ errorMessageLabel = $(By.cssSelector("h3[data-test='error']"));

    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Step Two Page to load")
    public void waitPageToLoad() {
        waitPage(continueButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Step Two Page")
    public void verifyPage() {
        softAssert.assertTrue(firstnameInput.isDisplayed(), "Firstname Input");
        softAssert.assertTrue(lastnameInput.isDisplayed(), "Lastname Input");
        softAssert.assertTrue(zipcodeInput.isDisplayed(), "Zipcode Input");
        softAssert.assertTrue(cancelButton.isDisplayed(), "Cancel Button");
        softAssert.assertTrue(continueButton.isDisplayed(), "Continue Button");
        softAssert.assertAll();
    }

    @Step("Filling user information form")
    public void fillForm(String firstname, String lastname, String zipcode) {
        logs.info("Filling firstname");
        firstnameInput.sendKeys(firstname);

        logs.info("Filling lastname");
        lastnameInput.sendKeys(lastname);

        logs.info("Filling zipcode");
        zipcodeInput.sendKeys(zipcode);

        logs.info("Clicking on continue");
        continueButton.click();
    }

    @Step("Clicking on cancel button")
    public void clickOnCancelButton() {
        logs.info("Clicking on cancel button");
        cancelButton.click();
    }

    @Step("Verifying error message")
    public void verifyErrorMessage(String errorMessage) {
        logs.info("Verifying error message");
        softAssert.assertTrue(errorMessageLabel.isDisplayed());
        softAssert.assertEquals(errorMessageLabel.getText(), errorMessage);
        softAssert.assertAll();
    }
}
