package basic;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests extends BaseTest {
    @Test(groups = {smoke})
    @Description("Current url test")
    public void currentUrlTest() {
        log.info("Verifying current url is the same as mainUrl");
        Assert.assertEquals(driver.getCurrentUrl(), mainUrl);
    }

    @Test(groups = {smoke, regression})
    @Description("Navigate to stackoverflow test")
    public void navigateBackTest() {
        log.info("Getting the current url");
        var currentUrl = driver.getCurrentUrl(); //saucedemo

        log.info("Navigating to stackoverflow");
        driver.get("https://stackoverflow.com/");

        log.info("Waiting stackoverflow to load for 3 seconds");
        utilities.waitSeconds(3);

        log.info("Returning to saucedemo by pressing navigate back");
        driver.navigate().back();

        log.info("Waiting saucedemo to load");
        utilities.waitSeconds(3);

        log.info("Verifying current url is the same as mainUrl");
        Assert.assertEquals(driver.getCurrentUrl(), currentUrl);
    }

    @Test(groups = {smoke})
    @Description("Current url test")
    public void failedTest() {
        utilities.verifyUrl(driver.getCurrentUrl(), "meme.com");
    }

    @Test(groups = {smoke}, enabled = false)
    @Description("Current url test")
    public void failed2Test() {
        utilities.verifyUrl(driver.getCurrentUrl(), "meme.com");
    }

    @Override
    protected void initPages() {
        
    }
}
