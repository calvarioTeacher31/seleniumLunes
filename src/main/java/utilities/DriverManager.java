package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    protected final Logs log = new Logs();
    protected WebDriver driver;
    private boolean headlessMode = true;

    public WebDriver createDriver() {
        var browserName = System.getProperty("browser");
        var headlessString = System.getProperty("headlessMode");

        if (browserName == null) {
            log.debug("Setting default local browser to CHROME");
            browserName = "CHROME";
        }

        if (headlessString == null) {
            log.debug("Setting default headless mode to false");
            headlessMode = false;
        }

        log.debug("Initializing the driver");
        switch (browserName) {
            case "CHROME":
                log.debug("Chrome driver");
                WebDriverManager.chromedriver().setup();
                var chromeOptions = new ChromeOptions().setHeadless(headlessMode);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "EDGE":
                log.debug("Edge driver");
                WebDriverManager.edgedriver().setup();
                var edgeOptions = new EdgeOptions().setHeadless(headlessMode);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "FIREFOX":
                log.debug("Firefox driver");
                WebDriverManager.firefoxdriver().setup();
                var firefoxOptions = new FirefoxOptions().setHeadless(headlessMode);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "SAFARI":
                log.debug("Safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                log.error("Bad driver name");
                driver = null;
        }

        log.debug("Maximizing window");
        driver.manage().window().maximize();

        log.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        FileManager.staticDriver = driver;

        return driver;
    }
}
