package data;

import com.poiji.bind.Poiji;
import models.Credentials;
import models.ErrorMessage;
import models.ShoppingItem;
import models.Url;
import utilities.Logs;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final Logs log = new Logs();
    private final String excelPath = "src/test/resources/data/testData.xlsx";

    public List<Credentials> getCredentialList() {
        log.debug("Reading credentials from excel");
        return Poiji.fromExcel(new File(excelPath), Credentials.class);
    }

    public List<Url> getUrlList() {
        log.debug("Reading url from excel");
        return Poiji.fromExcel(new File(excelPath), Url.class);
    }

    public List<ErrorMessage> getErrorMessageList() {
        log.debug("Reading error message from excel");
        return Poiji.fromExcel(new File(excelPath), ErrorMessage.class);
    }

    public List<ShoppingItem> getShoppingItemList() {
        log.debug("Reading shopping item from excel");
        return Poiji.fromExcel(new File(excelPath), ShoppingItem.class);
    }
}
