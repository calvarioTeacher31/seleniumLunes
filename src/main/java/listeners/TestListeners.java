package listeners;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.DriverManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    private final Logs log = new Logs();

    @Override
    public void onTestStart(ITestResult result) {
        log.startTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.endTest("SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        var driverManager = new DriverManager();
        var driver = getDriverFromResult(result);
        driverManager.getScreenshot(driver, result.getName());
        log.endTest("FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.endTest("SKIPPED");
    }

    private WebDriver getDriverFromResult(ITestResult result) {
        var currentClass = result.getInstance();
        return ((BaseTest) currentClass).getDriver();
    }
}