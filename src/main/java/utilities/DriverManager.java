package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class DriverManager {
    protected final Logs log = new Logs();
    private final String screenShotPath = "src/test/resources/screenshots";
    protected WebDriver driver;

    public WebDriver createDriver() {
        var browserName = System.getProperty("browser");

        if (browserName == null) {
            log.debug("Setting default local browser to CHROME");
            browserName = "CHROME";
        }

        log.debug("Initializing the driver");
        switch (browserName) {
            case "CHROME":
                log.debug("Chrome driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "EDGE":
                log.debug("Edge driver");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "SAFARI":
                log.debug("Safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }

        log.debug("Maximizing window");
        driver.manage().window().maximize();

        log.debug("Deleting cookies");
        driver.manage().deleteAllCookies();

        return driver;
    }

    public void getScreenshot(WebDriver driver, String screenshotName) {
        log.debug("Taking screenshot");

        var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        var path = String.format("%s/%s.png", screenShotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            log.error("Path does not exists");
            log.error(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "Screenshot failure", type = "image", fileExtension = "png")
    public byte[] getAllureScreenshot(WebDriver driver) {
        log.debug("Taking allure screenshot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void deleteScreenshotDirectory() {
        try {
            log.debug("Cleaning screenshot folder");
            FileUtils.deleteDirectory(new File(screenShotPath));
        } catch (IOException ioException) {
            log.error("Failed cleaning screenshot folder");
            log.error(ioException.getLocalizedMessage());
        }
    }
}