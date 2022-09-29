package listeners;

import base.BaseListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.Logs;

public class SuiteListeners extends BaseListener implements ISuiteListener {
    private final Logs log = new Logs();

    @Override
    public void onStart(ISuite suite) {
        fileManager.deleteAllureReports().deleteTestEvidence().redirectStdErr();
        log.startSuite(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("End suite");
    }
}
