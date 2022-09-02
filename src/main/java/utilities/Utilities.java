package utilities;

import io.qameta.allure.Step;
import org.testng.Assert;

public class Utilities {
    private final Logs log = new Logs();

    public void waitSeconds(int n) {
        try {
            Thread.sleep(n * 1000L);
        } catch (InterruptedException interruptedException) {
            log.error(interruptedException.getLocalizedMessage());
        }
    }

    @Step("Verifying url")
    public void verifyUrl(String string1, String string2) {
        log.info("Verifying current url is the same as mainUrl");
        Assert.assertEquals(string1, string2);
    }
}
