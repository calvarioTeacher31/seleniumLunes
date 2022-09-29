package listeners;

import base.BaseListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class AllureListeners extends BaseListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus().name().equalsIgnoreCase("FAILED") ||
                result.getStatus().name().equalsIgnoreCase("BROKEN")) {
            fileManager.getAllureScreenshot(staticDriver);
        }
    }
}