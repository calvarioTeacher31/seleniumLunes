package utilities;

import data.DataProviders;
import org.openqa.selenium.WebDriver;
import pageObjects.HomeShoppingPage;
import pageObjects.LoginPage;

public class CommonFlows {
    private final WebDriver driver;
    private final String mainUrl = "https://www.saucedemo.com/";
    private final DataProviders dataProviders = new DataProviders();

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var loginPage = new LoginPage(driver);

        driver.get(mainUrl);
        loginPage.waitPageToLoad();
    }

    public void goToHome() {
        var loginPage = new LoginPage(driver);
        var homeShoppingPage = new HomeShoppingPage(driver);
        var validCredentials = dataProviders.getValidCredentials();

        loginPage.fillForm(validCredentials.getUsername(), validCredentials.getPassword());
        homeShoppingPage.waitPageToLoad();
    }

    public void goToStepOne() {
        goToHome();
        //click en el carrito
    }
}
