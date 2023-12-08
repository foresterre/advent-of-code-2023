package day06;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DaySixPartTwoParser implements Parse<List<Race>> {
    @Override
    public List<Race> from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        var inputs = reader.lines()
                .map(line -> line.chars().filter(Character::isDigit).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append))
                .mapToLong(sb -> Long.parseLong(sb.toString()))
                .toArray();

        return Collections.singletonList(new Race(inputs[0], inputs[1]));
    }
}
