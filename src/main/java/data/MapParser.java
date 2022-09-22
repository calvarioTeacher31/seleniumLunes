package data;

import models.Credentials;
import models.ErrorMessage;
import models.Url;
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

    public HashMap<String, Url> getUrlMap() {
        log.debug("Creating url map");
        var map = new HashMap<String, Url>();
        var urlList = excelReader.getUrlList();

        for (var url : urlList) {
            map.put(url.getKey(), url);
        }
        return map;
    }

    public HashMap<String, ErrorMessage> getErrorMessageMap() {
        log.debug("Creating error message map");
        var map = new HashMap<String, ErrorMessage>();
        var errorMessageList = excelReader.getErrorMessageList();

        for (var errorMessage : errorMessageList) {
            map.put(errorMessage.getKey(), errorMessage);
        }
        return map;
    }
}
