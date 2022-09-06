package data;

import models.Credentials;
import utilities.Logs;

import java.util.HashMap;

public class MapParser {
    private final Logs log = new Logs();
    private final ExcelReader excelReader = new ExcelReader();

    public HashMap<String, Credentials> getCredentialsMap() {
        log.debug("Creating credential map");
        var map = new HashMap<String, Credentials>();
        var credentialList = excelReader.getCredentialList();

        for (var credential : credentialList) {
            map.put(credential.getKey(), credential);
        }
        return map;
    }
}
