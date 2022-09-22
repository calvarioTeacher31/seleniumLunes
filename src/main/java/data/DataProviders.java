package data;

import models.Credentials;
import models.UserInformation;
import org.testng.annotations.DataProvider;
import utilities.Logs;

public class DataProviders {
    private final Logs log = new Logs();
    private final MapParser mapParser = new MapParser();
    private final ExcelReader excelReader = new ExcelReader();
    public final static String URL_DP = "url data provider";
    public final static String USER_INFORMATION_DP = "user information data provider";

    public Credentials getValidCredentials() {
        log.debug("Getting valid credentials");
        return mapParser.getCredentialsMap().get("valid");
    }

    public Credentials getLockedCredentials() {
        log.debug("Getting locked credentials");
        return mapParser.getCredentialsMap().get("locked");
    }

    public String aboutOptionUrl() {
        log.debug("Getting about option url");
        return mapParser.getUrlMap().get("Saucelabs").getUrl();
    }

    @DataProvider(name = URL_DP)
    public Object[][] urlDataProvider() {
        var urlMap = mapParser.getUrlMap();
        var urlTwitter = urlMap.get("Twitter");
        var urlFacebook = urlMap.get("Facebook");
        var urlLinkedin = urlMap.get("LinkedIn");
        return new Object[][]{
                {urlTwitter.getKey(), urlTwitter.getUrl()},
                {urlFacebook.getKey(), urlFacebook.getUrl()},
                {urlLinkedin.getKey(), urlLinkedin.getUrl()}
        };
    }

    @DataProvider(name = USER_INFORMATION_DP)
    public Object[][] userInformationDataProvider() {
        var userInformation = new UserInformation();
        var errorMessageMap = mapParser.getErrorMessageMap();
        var firstName = userInformation.getFirstname();
        var lastName = userInformation.getLastname();
        var zipCode = userInformation.getZipcode();
        var empty = "";

        return new Object[][]{
                {empty, lastName, zipCode, errorMessageMap.get("missingFirstname").getErrorMessage()},
                {firstName, empty, zipCode, errorMessageMap.get("missingLastname").getErrorMessage()},
                {firstName, lastName, empty, errorMessageMap.get("missingZipcode").getErrorMessage()}
        };
    }
}
