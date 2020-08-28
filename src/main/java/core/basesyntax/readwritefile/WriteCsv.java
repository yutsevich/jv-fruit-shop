package core.basesyntax.readwritefile;

import core.basesyntax.readwritefile.interfaces.IWriteCsv;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class WriteCsv implements IWriteCsv {
    public static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT.withHeader("fruit", "quantity");

    public WriteCsv() {
    }

    @Override
    public boolean writeCsv(Map<String, Integer> currentBalance, String pathName) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(pathName), CSV_FORMAT)) {
            for (Map.Entry<String, Integer> entry : currentBalance.entrySet()) {
                printer.printRecord(entry.getKey(), entry.getValue());
            }
        } catch (IOException exception) {
            System.out.println(("file " + pathName + " is not written"));
            exception.printStackTrace();
        }
        return false;
    }
}
