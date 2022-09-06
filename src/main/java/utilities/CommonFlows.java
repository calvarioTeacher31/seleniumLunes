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

    public void goToLoginPage() {
        driver.get(mainUrl);

        var loginPage = new LoginPage(driver); //wait page to load
        loginPage.waitPageToLoad();
    }

    public void goToHomeShoppingPage() {
        var credentials = dataProviders.getValidCredentials();

        var loginPage = new LoginPage(driver); //wait page to load
        loginPage.fillForm(credentials.getUsername(), credentials.getPassword());

        var homeShoppingPage = new HomeShoppingPage(driver);
        homeShoppingPage.waitPageToLoad();
    }

    public void openSideBarMenu() {
        goToHomeShoppingPage();
        var homeShoppingPage = new HomeShoppingPage(driver);
        homeShoppingPage.openMenuBar();
    }
}
