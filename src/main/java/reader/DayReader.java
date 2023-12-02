package reader;

import java.io.InputStream;

public class DayReader {
    public static InputStream readDay(int day) {
        var fileName = makeFileName(day);
        return readResourceFile(fileName);
    }

    public static InputStream readFile(String fileName) {
        return readResourceFile(fileName);
    }

    private static InputStream readResourceFile(String fileName) {
        var classloader = Thread.currentThread().getContextClassLoader();
        var inputStream = classloader.getResourceAsStream(fileName);

        assert inputStream != null;
        return inputStream;
    }

    private static String makeFileName(int day) {
        return String.format("%d.txt", day);
    }
}
