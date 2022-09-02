package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.DriverManager;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    private final Logs log = new Logs();

    @Override
    public void onStart(ISuite suite) {
        new DriverManager().deleteScreenshotDirectory();
        log.startSuite(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("End suite");
    }
}
