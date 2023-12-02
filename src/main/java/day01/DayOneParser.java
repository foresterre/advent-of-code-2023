package day01;

import solution.Parse;

import java.io.*;

public class DayOneParser implements Parse<CalibrationDocument> {

    private final DigitOccurrenceMatcher mapping;

    public DayOneParser(boolean includeSpelledOutDigits) {
       mapping = new DigitOccurrenceMatcher(includeSpelledOutDigits);
    }

    @Override
    public CalibrationDocument from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        var values = reader.lines()
                .map(line -> {
                    var firstElement = mapping.findFirstMatching(line);
                    var lastElement = mapping.findLastMatching(line);

                    return new CalibrationValue(firstElement, lastElement);
                })
                .toList();


        return new CalibrationDocument(values);
    }

}
