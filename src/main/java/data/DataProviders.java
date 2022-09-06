package data;

import models.Credentials;
import utilities.Logs;

public class DataProviders {
    private final Logs log = new Logs();
    private final MapParser mapParser = new MapParser();
    private final ExcelReader excelReader = new ExcelReader();

    public Credentials getValidCredentials() {
        log.debug("Getting valid credentials");
        return mapParser.getCredentialsMap().get("valid");
    }

    public Credentials getLockedCredentials() {
        log.debug("Getting locked credentials");
        return mapParser.getCredentialsMap().get("locked");
    }
}
