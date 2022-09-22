package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileManager {
    private final Logs logs = new Logs();

    public FileManager redirectStdErr() {
        logs.debug("Redirecting stderr");
        var file = new File("src/test/resources/logs/stderr.log");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintStream ps = new PrintStream(fos);
        System.setErr(ps);
        return this;
    }
}
