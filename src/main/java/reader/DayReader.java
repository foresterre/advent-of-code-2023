package reader;

import java.io.File;
import java.io.InputStream;

public class DayReader {
    public static InputStream readDay(int day) {
        var fileName = makeFolderName(day) + "input";
        return readResourceFile(fileName);
    }

    public static InputStream readFile(int day, String fileName) {
        var path = makeFolderName(day) + fileName;
        return readResourceFile(path);
    }

    private static InputStream readResourceFile(String fileName) {
        var classloader = Thread.currentThread().getContextClassLoader();
        var inputStream = classloader.getResourceAsStream(fileName);

        assert inputStream != null;
        return inputStream;
    }

    private static String makeFolderName(int day) {
        return day + File.separator;
    }
}
