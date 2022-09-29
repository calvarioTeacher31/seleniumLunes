package pageObjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class FooterPage extends BasePage {
    private final $ robotImage = $(By.className("footer_robot"));
    private final $ footerCopy = $(By.className("footer_copy"));
    private final $ socialList = $(By.className("social"));

    private $ getSocialElement(String socialName) {
        var xpath = String.format("//a[text()='%s']", socialName);
        return $(By.xpath(xpath));
    }

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting Bottom Bar Page to load")
    public void waitPageToLoad() {
        waitPage(robotImage, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying Bottom Bar Page")
    public void verifyPage() {
        softAssert.assertTrue(robotImage.isDisplayed(), "Robot Image");
        softAssert.assertTrue(footerCopy.isDisplayed(), "Footer Image");
        softAssert.assertTrue(socialList.isDisplayed(), "Social List");
        softAssert.assertAll();
    }

    @Step("Verifying Social Link")
    public void verifySocialLink(String socialName, String url) {
        logs.info("Verifying social link " + socialName);
        var socialElement = getSocialElement(socialName);
        softAssert.assertTrue(socialElement.isDisplayed(), "Displayed");
        softAssert.assertTrue(socialElement.isEnabled(), "Enabled");
        softAssert.assertEquals(socialElement.getHref(), url, "Url Mismatch");
        softAssert.assertAll();
    }
}
