package data;

import com.poiji.bind.Poiji;
import models.Credentials;
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
}
