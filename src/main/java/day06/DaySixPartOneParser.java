package day06;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DaySixPartOneParser implements Parse<List<Race>> {
    @Override
    public List<Race> from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        var inputs = reader.lines()
                .map(line -> Arrays.stream(line.split("\\s+")).skip(1).map(Integer::parseInt).toList())
                .toList();


        int size = inputs.stream().findFirst().get().size();
        return IntStream.range(0, size)
                .mapToObj(raceNr -> new Race(inputs.get(0).get(raceNr), inputs.get(1).get(raceNr)))
                .toList();
    }
}
