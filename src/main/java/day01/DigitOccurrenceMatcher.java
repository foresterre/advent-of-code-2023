package day01;

import com.google.common.collect.ImmutableMap;

import java.util.Comparator;

public class DigitOccurrenceMatcher {
    private final ImmutableMap<String, Integer> mapping;

    DigitOccurrenceMatcher(boolean includeSpelledOutDigits) {
        var builder = new ImmutableMap.Builder<String, Integer>();

        builder.put("1", 1);
        builder.put("2", 2);
        builder.put("3", 3);
        builder.put("4", 4);
        builder.put("5", 5);
        builder.put("6", 6);
        builder.put("7", 7);
        builder.put("8", 8);
        builder.put("9", 9);

        if (includeSpelledOutDigits) {
            builder.put("one", 1);
            builder.put("two", 2);
            builder.put("three", 3);
            builder.put("four", 4);
            builder.put("five", 5);
            builder.put("six", 6);
            builder.put("seven", 7);
            builder.put("eight", 8);
            builder.put("nine", 9);
        }

        this.mapping = builder.build();
    }

    public int findFirstMatching(String line) {
        var match = mapping.entrySet()
                .stream()
                .map(entry -> {
                    var index = line.indexOf(entry.getKey());

                    // represented digit -> index
                    return new DigitToIndexMapping(entry.getValue(), index);
                })
                .filter(tuple -> tuple.index() != -1)
                .min(Comparator.comparingInt(DigitToIndexMapping::index))
                .map(DigitToIndexMapping::digit);

        assert match.isPresent();

        return match.get();
    }

    public int findLastMatching(String line) {
        var match = mapping.entrySet()
                .stream()
                .map(entry -> {
                    var index = line.lastIndexOf(entry.getKey());
                    return new DigitToIndexMapping(entry.getValue(), index);
                })
                .filter(tuple -> tuple.index() != -1)
                .max(Comparator.comparingInt(DigitToIndexMapping::index))
                .map(DigitToIndexMapping::digit);

        assert match.isPresent();

        return match.get();
    }

    private record DigitToIndexMapping(int digit, int index) {}

}
